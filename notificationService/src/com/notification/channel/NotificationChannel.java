package com.notification.channel;

import com.notification.model.Notification;
import com.notification.model.User;

public interface NotificationChannel {

    void send(User user, Notification notification);
}
