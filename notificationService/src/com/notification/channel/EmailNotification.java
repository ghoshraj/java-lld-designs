package com.notification.channel;

import com.notification.model.Notification;
import com.notification.model.User;

public class EmailNotification implements NotificationChannel {

    @Override
    public void send(User user, Notification notification) {
        System.out.println("📧 Email sent to " + user.getEmail() +
                " : " + notification.getMessage() +
                " at " + notification.getTimestamp());
    }
}
