package com.example.reminderapp.model;

public class StreakItem {
    private String id;
    private String name;
    private String category;
    private int currentStreak;
    private int bestStreak;
    private String icon;

    public StreakItem(String id, String name, String category, int currentStreak, int bestStreak, String icon) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.currentStreak = currentStreak;
        this.bestStreak = bestStreak;
        this.icon = icon;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public int getCurrentStreak() { return currentStreak; }
    public int getBestStreak() { return bestStreak; }
    public String getIcon() { return icon; }
}
