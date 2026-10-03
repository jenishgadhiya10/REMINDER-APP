package com.example.reminderapp.model;

public enum Category {
    WATER("Water", "💧", "Health", "#0284C7"),
    MEDICINE("Medicine", "💊", "Health", "#E11D48"),
    WALKING("Walking", "🚶", "Health", "#059669"),
    BLOOD_TEST("Blood Test", "🩸", "Health", "#DC2626"),
    MEETING("Meeting", "📅", "Meetings", "#7C3AED"),
    APPOINTMENT("Appointment", "🏥", "Appointments", "#DB2777"),
    WORK("Work", "💼", "Tasks", "#4338CA"),
    STUDY("Study", "🎓", "Tasks", "#2563EB"),
    GOAL("Goal", "🎯", "Goals", "#D97706"),
    FINANCE("Finance", "💰", "Finance", "#CA8A04"),
    BILL_PAYMENT("Bill Payment", "🧾", "Finance", "#0D9488"),
    DOCUMENT_RENEWAL("Document Renewal", "📄", "System", "#0284C7"),
    BIRTHDAY("Birthday", "🎂", "Personal", "#C026D3"),
    ANNIVERSARY("Anniversary", "🎉", "Personal", "#E11D48"),
    TRAVEL("Travel", "✈️", "Personal", "#0284C7"),
    SHOPPING("Shopping", "🛒", "Personal", "#16A34A"),
    CUSTOM("Custom Reminder", "🔔", "General", "#4F46E5");

    private final String displayName;
    private final String emoji;
    private final String group;
    private final String colorHex;

    Category(String displayName, String emoji, String group, String colorHex) {
        this.displayName = displayName;
        this.emoji = emoji;
        this.group = group;
        this.colorHex = colorHex;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmoji() {
        return emoji;
    }

    public String getGroup() {
        return group;
    }

    public String getColorHex() {
        return colorHex;
    }
}
