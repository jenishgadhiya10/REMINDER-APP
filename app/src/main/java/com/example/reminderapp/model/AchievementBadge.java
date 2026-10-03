package com.example.reminderapp.model;

public class AchievementBadge {
    private String id;
    private String title;
    private String description;
    private String icon;
    private boolean isUnlocked;
    private String unlockedDate;

    public AchievementBadge(String id, String title, String description, String icon, boolean isUnlocked, String unlockedDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.isUnlocked = isUnlocked;
        this.unlockedDate = unlockedDate;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getIcon() { return icon; }
    public boolean isUnlocked() { return isUnlocked; }
    public String getUnlockedDate() { return unlockedDate; }
}
