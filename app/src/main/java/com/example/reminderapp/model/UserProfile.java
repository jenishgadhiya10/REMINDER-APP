package com.example.reminderapp.model;

public class UserProfile {
    private String name;
    private String email;
    private String avatarInitials;
    private int currentStreak;
    private int totalCompleted;
    private String level;

    public UserProfile() {
        this.name = "Jenish Gadhiya";
        this.email = "jenish@lifesync.app";
        this.avatarInitials = "JG";
        this.currentStreak = 7;
        this.totalCompleted = 142;
        this.level = "Productivity Champion";
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAvatarInitials() { return avatarInitials; }
    public void setAvatarInitials(String avatarInitials) { this.avatarInitials = avatarInitials; }

    public int getCurrentStreak() { return currentStreak; }
    public void setCurrentStreak(int currentStreak) { this.currentStreak = currentStreak; }

    public int getTotalCompleted() { return totalCompleted; }
    public void setTotalCompleted(int totalCompleted) { this.totalCompleted = totalCompleted; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
}
