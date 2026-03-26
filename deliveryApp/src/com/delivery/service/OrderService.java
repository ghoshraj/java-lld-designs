package com.delivery.service;

import com.delivery.enums.OrderStatus;
import com.delivery.enums.PaymentMode;
import com.delivery.model.Order;
import com.delivery.model.OrderItem;

import java.util.List;

public interface OrderService {

    Order placeOrder(String userId, String restaurantId, List<OrderItem> items,
                     String addressId, PaymentMode paymentMode);

    Order getOrderById(String orderId);

    List<Order> getOrdersByUser(String userId);

    void cancelOrder(String orderId);

    void updateOrderStatus(String orderId, OrderStatus status);
}
