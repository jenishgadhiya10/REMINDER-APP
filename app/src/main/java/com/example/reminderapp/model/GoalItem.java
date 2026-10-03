package com.example.reminderapp.model;

public class GoalItem {
    private String id;
    private String title;
    private String category;
    private float currentProgress;
    private float targetGoal;
    private String unit;
    private int streakDays;
    private boolean isCompleted;

    public GoalItem(String id, String title, String category, float currentProgress, float targetGoal, String unit, int streakDays) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.currentProgress = currentProgress;
        this.targetGoal = targetGoal;
        this.unit = unit;
        this.streakDays = streakDays;
        this.isCompleted = currentProgress >= targetGoal;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public float getCurrentProgress() { return currentProgress; }
    public void setCurrentProgress(float currentProgress) {
        this.currentProgress = currentProgress;
        this.isCompleted = this.currentProgress >= this.targetGoal;
    }
    public float getTargetGoal() { return targetGoal; }
    public String getUnit() { return unit; }
    public int getStreakDays() { return streakDays; }
    public boolean isCompleted() { return isCompleted; }
}
