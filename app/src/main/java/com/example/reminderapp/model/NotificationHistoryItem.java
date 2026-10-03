package com.example.reminderapp.model;

public class NotificationHistoryItem {
    private String id;
    private String title;
    private Category category;
    private String triggerTime;
    private String completionTime;
    private int snoozeCount;
    private String status;

    public NotificationHistoryItem(String id, String title, Category category, String triggerTime, String completionTime, int snoozeCount, String status) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.triggerTime = triggerTime;
        this.completionTime = completionTime;
        this.snoozeCount = snoozeCount;
        this.status = status;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public Category getCategory() { return category; }
    public String getTriggerTime() { return triggerTime; }
    public String getCompletionTime() { return completionTime; }
    public int getSnoozeCount() { return snoozeCount; }
    public String getStatus() { return status; }
}
