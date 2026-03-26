package com.delivery.service.impl;

import com.delivery.enums.OrderStatus;
import com.delivery.enums.PaymentMode;
import com.delivery.enums.PaymentStatus;
import com.delivery.model.*;
import com.delivery.service.*;

import java.util.*;

public class OrderServiceImpl implements OrderService {

    Map<String, Order> orderMap = new HashMap<>();

    private UserService userService;
    private RestaurantService restaurantService;
    private DeliveryService deliveryService;
    private PaymentServiceResolver paymentResolver;

    public OrderServiceImpl(UserService userService, RestaurantService restaurantService,
                            DeliveryService deliveryService, PaymentServiceResolver paymentResolver) {
        this.userService = userService;
        this.restaurantService = restaurantService;
        this.deliveryService = deliveryService;
        this.paymentResolver = paymentResolver;
    }

    @Override
    public Order placeOrder(String userId, String restaurantId, List<OrderItem> items, String addressId, PaymentMode paymentMode) {

        User user = userService.getUserById(userId);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        if (restaurant == null) {
            throw new RuntimeException("Restaurant not found");
        }

        Address deliveryAddress = null;
        for (Address addr : user.getAddresses()) {
            if (addr.getId().equals(addressId)) {
                deliveryAddress = addr;
                break;
            }
        }

        if (deliveryAddress == null) {
            throw new RuntimeException("Address not found");
        }

        String orderId = UUID.randomUUID().toString();
        Order order = new Order(orderId, user, restaurant, items, deliveryAddress);

        PaymentService paymentService = paymentResolver.resolve(paymentMode);

        Payment payment = paymentService.processPayment(order);
        order.setPayment(payment);

        if (payment.getStatus() == PaymentStatus.FAILED) {
            order.setStatus(OrderStatus.CANCELLED);
            return order;
        }

        DeliveryPartner partner = deliveryService.assignDeliveryPartner(order);
        order.setDeliveryPartner(partner);

        order.setStatus(OrderStatus.CONFIRMED);

        orderMap.put(orderId, order);

        return order;
    }

    @Override
    public Order getOrderById(String orderId) {

        Order order = orderMap.get(orderId);

        if (order == null) {
            throw new RuntimeException("Order not found");
        }

        return order;
    }

    @Override
    public List<Order> getOrdersByUser(String userId) {

        List<Order> result = new ArrayList<>();

        for (Order order : orderMap.values()) {
            if (order.getUser().getId().equals(userId)) {
                result.add(order);
            }
        }

        return result;
    }

    @Override
    public void cancelOrder(String orderId) {

        Order order = orderMap.get(orderId);

        if (order == null) {
            throw new RuntimeException("Order not found");
        }
        if (order.getStatus() == OrderStatus.DELIVERED) {
            throw new RuntimeException("Cannot cancel delivered order");
        }

        order.setStatus(OrderStatus.CANCELLED);
        DeliveryPartner partner = order.getDeliveryPartner();

        if (partner != null) {
            deliveryService.updatePartnerAvailability(partner.getId(), true);
        }
    }

    @Override
    public void updateOrderStatus(String orderId, OrderStatus status) {

        Order order = orderMap.get(orderId);

        if (order == null) {
            throw new RuntimeException("Order not found");
        }

        order.setStatus(status);

        // If delivered → free partner
        if (status == OrderStatus.DELIVERED) {

            DeliveryPartner partner = order.getDeliveryPartner();

            if (partner != null) {
                deliveryService.updatePartnerAvailability(partner.getId(), true);
            }
        }
    }
}
