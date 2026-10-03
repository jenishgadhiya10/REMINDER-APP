package com.example.reminderapp.model;

public enum Priority {
    LOW("Low", "#10B981"),
    MEDIUM("Medium", "#F59E0B"),
    HIGH("High", "#F97316"),
    CRITICAL("Critical", "#EF4444");

    private final String label;
    private final String colorHex;

    Priority(String label, String colorHex) {
        this.label = label;
        this.colorHex = colorHex;
    }

    public String getLabel() {
        return label;
    }

    public String getColorHex() {
        return colorHex;
    }
}
