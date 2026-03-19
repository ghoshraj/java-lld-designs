package com.notification.model;

import com.notification.channel.NotificationChannel;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String email;
    private String phone;

    private List<NotificationChannel> preferredChannels;
    private List<Notification> history = new ArrayList<>();

    public User(int id, String email, String phone, List<NotificationChannel> channels) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.preferredChannels = channels;
    }

    public List<NotificationChannel> getPreferredChannels() {
        return preferredChannels;
    }

    public void addNotification(Notification notification) {
        history.add(notification);
    }

    public List<Notification> getHistory() {
        return history;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
