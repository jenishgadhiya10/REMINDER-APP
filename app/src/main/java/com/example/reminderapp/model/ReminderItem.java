package com.example.reminderapp.model;

import java.util.ArrayList;
import java.util.List;

public class ReminderItem {
    private String id;
    private String title;
    private String description;
    private Category category;
    private Priority priority;
    private String time;
    private String date;
    private RepeatFrequency repeat;
    private boolean isCompleted;
    private boolean isMyDay;
    private String location;
    private String notificationSound;
    private String notes;
    private List<String> attachments;
    private int snoozeCount;

    public ReminderItem() {
        this.attachments = new ArrayList<>();
        this.repeat = RepeatFrequency.ONCE;
        this.notificationSound = "Chime";
        this.snoozeCount = 0;
    }

    public ReminderItem(String id, String title, String description, Category category, Priority priority,
                        String time, String date, RepeatFrequency repeat, boolean isCompleted, boolean isMyDay,
                        String location, String notificationSound, String notes) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.time = time;
        this.date = date;
        this.repeat = repeat;
        this.isCompleted = isCompleted;
        this.isMyDay = isMyDay;
        this.location = location;
        this.notificationSound = notificationSound != null ? notificationSound : "Chime";
        this.notes = notes;
        this.attachments = new ArrayList<>();
        this.snoozeCount = 0;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public RepeatFrequency getRepeat() { return repeat; }
    public void setRepeat(RepeatFrequency repeat) { this.repeat = repeat; }

    public boolean isCompleted() { return isCompleted; }
    public void setCompleted(boolean completed) { isCompleted = completed; }

    public boolean isMyDay() { return isMyDay; }
    public void setMyDay(boolean myDay) { isMyDay = myDay; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getNotificationSound() { return notificationSound; }
    public void setNotificationSound(String notificationSound) { this.notificationSound = notificationSound; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public List<String> getAttachments() { return attachments; }
    public void setAttachments(List<String> attachments) { this.attachments = attachments; }

    public int getSnoozeCount() { return snoozeCount; }
    public void setSnoozeCount(int snoozeCount) { this.snoozeCount = snoozeCount; }
}
