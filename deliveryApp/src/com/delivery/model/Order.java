package com.delivery.model;

import com.delivery.enums.OrderStatus;

import java.util.List;

public class Order {
    private String id;
    private User user;
    private Restaurant restaurant;
    private List<OrderItem> items;
    private Address deliveryAddress;
    private DeliveryPartner deliveryPartner;
    private Payment payment;
    private OrderStatus status;

    public Order(String id, User user, Restaurant restaurant,
                 List<OrderItem> items, Address deliveryAddress) {
        this.id = id;
        this.user = user;
        this.restaurant = restaurant;
        this.items = items;
        this.deliveryAddress = deliveryAddress;
        this.status = OrderStatus.CREATED;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setDeliveryPartner(DeliveryPartner deliveryPartner) {
        this.deliveryPartner = deliveryPartner;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    // getters


    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public DeliveryPartner getDeliveryPartner() {
        return deliveryPartner;
    }

    public Payment getPayment() {
        return payment;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
