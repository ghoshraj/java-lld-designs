package com.delivery.service.impl;

import com.delivery.enums.OrderStatus;
import com.delivery.model.DeliveryPartner;
import com.delivery.model.Order;
import com.delivery.service.DeliveryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliveryServiceImpl implements DeliveryService {

    private Map<String, DeliveryPartner> deliveryPartnerMap = new HashMap<>();

    @Override
    public DeliveryPartner assignDeliveryPartner(Order order) {
        for (DeliveryPartner deliveryPartner : deliveryPartnerMap.values()) {
            if (deliveryPartner.isAvailable()) {
                deliveryPartner.setAvailable(false);
                return deliveryPartner;
            }
        }
        return null;
    }

    @Override
    public void addDeliveryPartner(DeliveryPartner partner) {
        deliveryPartnerMap.put(partner.getId(), partner);
    }

    @Override
    public void updatePartnerAvailability(String partnerId, boolean available) {

        DeliveryPartner deliveryPartner = deliveryPartnerMap.get(partnerId);
        if (deliveryPartner != null) {
            deliveryPartner.setAvailable(available);
        }
    }

    @Override
    public List<DeliveryPartner> getAvailablePartners() {
        List<DeliveryPartner> result = new ArrayList<>();

        for (DeliveryPartner partner : deliveryPartnerMap.values()) {
            if (partner.isAvailable()) {
                result.add(partner);
            }
        }

        return result;
    }

    @Override
    public void updateDeliveryStatus(String orderId, OrderStatus status) {

    }
}
