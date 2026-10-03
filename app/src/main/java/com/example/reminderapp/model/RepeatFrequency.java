package com.example.reminderapp.model;

public enum RepeatFrequency {
    ONCE("Once"),
    DAILY("Daily"),
    WEEKDAYS("Weekdays"),
    WEEKLY("Weekly"),
    MONTHLY("Monthly"),
    YEARLY("Yearly"),
    CUSTOM("Custom");

    private final String label;

    RepeatFrequency(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
