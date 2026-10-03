package com.example.reminderapp.model;

public class AppSettings {
    private ThemeMode themeMode;
    private boolean soundEnabled;
    private boolean vibrationEnabled;
    private boolean calendarSyncEnabled;
    private String selectedLanguage;

    public AppSettings() {
        this.themeMode = ThemeMode.SYSTEM;
        this.soundEnabled = true;
        this.vibrationEnabled = true;
        this.calendarSyncEnabled = true;
        this.selectedLanguage = "English (US)";
    }

    public ThemeMode getThemeMode() { return themeMode; }
    public void setThemeMode(ThemeMode themeMode) { this.themeMode = themeMode; }

    public boolean isSoundEnabled() { return soundEnabled; }
    public void setSoundEnabled(boolean soundEnabled) { this.soundEnabled = soundEnabled; }

    public boolean isVibrationEnabled() { return vibrationEnabled; }
    public void setVibrationEnabled(boolean vibrationEnabled) { this.vibrationEnabled = vibrationEnabled; }

    public boolean isCalendarSyncEnabled() { return calendarSyncEnabled; }
    public void setCalendarSyncEnabled(boolean calendarSyncEnabled) { this.calendarSyncEnabled = calendarSyncEnabled; }

    public String getSelectedLanguage() { return selectedLanguage; }
    public void setSelectedLanguage(String selectedLanguage) { this.selectedLanguage = selectedLanguage; }
}
