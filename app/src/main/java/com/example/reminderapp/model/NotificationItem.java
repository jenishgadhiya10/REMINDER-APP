package com.example.reminderapp.model;

public class NotificationItem {
    private String id;
    private String title;
    private String message;
    private String timestamp;
    private String categoryGroup;
    private boolean isRead;

    public NotificationItem(String id, String title, String message, String timestamp, String categoryGroup, boolean isRead) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.timestamp = timestamp;
        this.categoryGroup = categoryGroup;
        this.isRead = isRead;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getMessage() { return message; }
    public String getTimestamp() { return timestamp; }
    public String getCategoryGroup() { return categoryGroup; }
    public boolean isRead() { return isRead; }
    public void setRead(boolean read) { isRead = read; }
}
