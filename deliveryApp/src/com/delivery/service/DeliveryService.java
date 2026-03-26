package com.delivery.service;

import com.delivery.enums.OrderStatus;
import com.delivery.model.DeliveryPartner;
import com.delivery.model.Order;

import java.util.List;

public interface DeliveryService {

    DeliveryPartner assignDeliveryPartner(Order order);

    void updatePartnerAvailability(String partnerId, boolean available);

    void addDeliveryPartner(DeliveryPartner partner);

    List<DeliveryPartner> getAvailablePartners();

    void updateDeliveryStatus(String orderId, OrderStatus status);
}
