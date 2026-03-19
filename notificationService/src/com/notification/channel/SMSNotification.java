package com.notification.channel;

import com.notification.model.Notification;
import com.notification.model.User;

public class SMSNotification implements NotificationChannel {

    @Override
    public void send(User user, Notification notification) {
        System.out.println("📱 SMS sent to " + user.getPhone() +
                " : " + notification.getMessage() +
                " at " + notification.getTimestamp());
    }
}
