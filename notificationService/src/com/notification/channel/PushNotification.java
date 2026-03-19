package com.notification.channel;

import com.notification.model.Notification;
import com.notification.model.User;

public class PushNotification implements NotificationChannel {

    @Override
    public void send(User user, Notification notification) {
        System.out.println("🔔 Push sent : " +
                notification.getMessage() +
                " at " + notification.getTimestamp());
    }
}
