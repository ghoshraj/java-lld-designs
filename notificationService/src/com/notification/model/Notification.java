package com.notification.model;

public class Notification {

    private String msg;
    private long timeStamp;

    public Notification(String msg) {
        this.msg = msg;
        this.timeStamp = System.currentTimeMillis();
    }

    public String getMessage() {
        return msg;
    }

    public long getTimestamp() {
        return timeStamp;
    }
}
