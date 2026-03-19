package com.notification.service;

import com.notification.channel.NotificationChannel;
import com.notification.model.Notification;
import com.notification.model.User;

public class NotificationService {

    public void sendNotification(User user, String message) {

        // create notification
        Notification notification = new Notification(message);

        // send through all preferred channels
        for (NotificationChannel channel : user.getPreferredChannels()) {
            channel.send(user, notification);
        }

        // store history
        user.addNotification(notification);
    }
}
