package com.example.reminderapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.reminderapp.data.LifeSyncRepository;
import com.example.reminderapp.model.AchievementBadge;
import com.example.reminderapp.model.AppSettings;
import com.example.reminderapp.model.Category;
import com.example.reminderapp.model.GoalItem;
import com.example.reminderapp.model.NotificationHistoryItem;
import com.example.reminderapp.model.NotificationItem;
import com.example.reminderapp.model.ReminderItem;
import com.example.reminderapp.model.StreakItem;
import com.example.reminderapp.model.SyncAccount;
import com.example.reminderapp.model.ThemeMode;
import com.example.reminderapp.model.UserProfile;

import java.util.List;

public class LifeSyncViewModel extends ViewModel {

    private final LifeSyncRepository repository;

    public LifeSyncViewModel() {
        this.repository = LifeSyncRepository.getInstance();
    }

    public LiveData<List<ReminderItem>> getReminders() {
        return repository.getReminders();
    }

    public LiveData<List<GoalItem>> getGoals() {
        return repository.getGoals();
    }

    public LiveData<List<StreakItem>> getStreaks() {
        return repository.getStreaks();
    }

    public LiveData<List<AchievementBadge>> getBadges() {
        return repository.getBadges();
    }

    public LiveData<List<NotificationItem>> getNotifications() {
        return repository.getNotifications();
    }

    public LiveData<List<SyncAccount>> getSyncAccounts() {
        return repository.getSyncAccounts();
    }

    public LiveData<List<NotificationHistoryItem>> getNotificationHistory() {
        return repository.getNotificationHistory();
    }

    public LiveData<UserProfile> getUserProfile() {
        return repository.getUserProfile();
    }

    public LiveData<AppSettings> getSettings() {
        return repository.getSettings();
    }

    public LiveData<ReminderItem> getActiveAlertReminder() {
        return repository.getActiveAlertReminder();
    }

    public void toggleReminderCompletion(String id) {
        repository.toggleReminderCompletion(id);
    }

    public void addQuickTask(String title, Category category) {
        repository.addQuickTask(title, category);
    }

    public void addFullReminder(ReminderItem reminder) {
        repository.addFullReminder(reminder);
    }

    public void deleteReminder(String id) {
        repository.deleteReminder(id);
    }

    public void snoozeReminder(String id, int minutes) {
        repository.snoozeReminder(id, minutes);
    }

    public void incrementGoalProgress(String goalId, float amount) {
        repository.incrementGoalProgress(goalId, amount);
    }

    public void markNotificationRead(String id) {
        repository.markNotificationRead(id);
    }

    public void clearAllNotifications() {
        repository.clearAllNotifications();
    }

    public void updateThemeMode(ThemeMode themeMode) {
        repository.updateThemeMode(themeMode);
    }

    public void triggerAlert(ReminderItem reminder) {
        repository.triggerAlert(reminder);
    }

    public void dismissAlert() {
        repository.dismissAlert();
    }
}
