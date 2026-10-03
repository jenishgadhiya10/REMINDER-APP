package com.example.reminderapp.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.reminderapp.model.AchievementBadge;
import com.example.reminderapp.model.AppSettings;
import com.example.reminderapp.model.Category;
import com.example.reminderapp.model.GoalItem;
import com.example.reminderapp.model.NotificationHistoryItem;
import com.example.reminderapp.model.NotificationItem;
import com.example.reminderapp.model.Priority;
import com.example.reminderapp.model.ReminderItem;
import com.example.reminderapp.model.RepeatFrequency;
import com.example.reminderapp.model.StreakItem;
import com.example.reminderapp.model.SyncAccount;
import com.example.reminderapp.model.ThemeMode;
import com.example.reminderapp.model.UserProfile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LifeSyncRepository {

    private static LifeSyncRepository instance;

    private final MutableLiveData<List<ReminderItem>> remindersLiveData = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<List<GoalItem>> goalsLiveData = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<List<StreakItem>> streaksLiveData = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<List<AchievementBadge>> badgesLiveData = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<List<NotificationItem>> notificationsLiveData = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<List<SyncAccount>> syncAccountsLiveData = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<List<NotificationHistoryItem>> notificationHistoryLiveData = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<UserProfile> userProfileLiveData = new MutableLiveData<>(new UserProfile());
    private final MutableLiveData<AppSettings> settingsLiveData = new MutableLiveData<>(new AppSettings());
    private final MutableLiveData<ReminderItem> activeAlertReminderLiveData = new MutableLiveData<>(null);

    private LifeSyncRepository() {
        initMockData();
    }

    public static synchronized LifeSyncRepository getInstance() {
        if (instance == null) {
            instance = new LifeSyncRepository();
        }
        return instance;
    }

    private void initMockData() {
        List<ReminderItem> initialReminders = new ArrayList<>(Arrays.asList(
                new ReminderItem("rem_1", "Morning Medicine & Vitamins", "Take BP medication with warm water after breakfast", Category.MEDICINE, Priority.HIGH, "09:00 AM", "2025-10-03", RepeatFrequency.DAILY, true, true, null, "Gentle Bell", "Prescription Refill #402"),
                new ReminderItem("rem_2", "Q4 Product Strategy Team Meeting", "Sprint planning & roadmap alignment with design lead", Category.MEETING, Priority.CRITICAL, "11:00 AM", "2025-10-03", RepeatFrequency.WEEKLY, false, true, "Conference Room 3B", "Chime", "Link: https://meet.google.com/lifesync-strategy"),
                new ReminderItem("rem_3", "Hydration Break - Drink 500ml Water", "Maintain daily 3.0L health target", Category.WATER, Priority.MEDIUM, "01:00 PM", "2025-10-03", RepeatFrequency.DAILY, false, true, null, "Chime", null),
                new ReminderItem("rem_4", "Evening 5K Walking Session", "Target 8,000 steps for daily streak", Category.WALKING, Priority.MEDIUM, "04:00 PM", "2025-10-03", RepeatFrequency.DAILY, false, true, "Central City Park", "Chime", null),
                new ReminderItem("rem_5", "Cardiology Doctor Appointment", "Dr. Robert Vance - Annual routine checkup & lab review", Category.APPOINTMENT, Priority.HIGH, "07:00 PM", "2025-10-03", RepeatFrequency.ONCE, false, true, "St. Mary Medical Center, Suite 402", "Emergency Alarm", null),
                new ReminderItem("rem_6", "Electricity & Utility Bill Payment", "Monthly utility auto-debit confirmation", Category.BILL_PAYMENT, Priority.HIGH, "08:30 PM", "2025-10-04", RepeatFrequency.MONTHLY, false, false, null, "Chime", null),
                new ReminderItem("rem_7", "Passport & Visa Renewal Document Check", "Review expiry dates and scan photos", Category.DOCUMENT_RENEWAL, Priority.MEDIUM, "10:00 AM", "2025-10-05", RepeatFrequency.YEARLY, false, false, null, "Chime", null)
        ));
        remindersLiveData.setValue(initialReminders);

        List<GoalItem> initialGoals = new ArrayList<>(Arrays.asList(
                new GoalItem("goal_1", "Drink 3.0L Water Daily", "Health", 2.0f, 3.0f, "L", 12),
                new GoalItem("goal_2", "Walk 8,000 Steps", "Health", 5400f, 8000f, "steps", 7),
                new GoalItem("goal_3", "Study Android System Design", "Study", 1.5f, 2.0f, "hrs", 15),
                new GoalItem("goal_4", "Monthly Savings Target", "Finance", 150f, 200f, "€", 3),
                new GoalItem("goal_5", "Daily Exercise Session", "Health", 20f, 30f, "mins", 9)
        ));
        goalsLiveData.setValue(initialGoals);

        List<StreakItem> initialStreaks = new ArrayList<>(Arrays.asList(
                new StreakItem("s1", "Hydration Champion", "Health", 12, 14, "💧"),
                new StreakItem("s2", "Walking Enthusiast", "Health", 7, 21, "🚶"),
                new StreakItem("s3", "Medicine Adherence", "Health", 30, 30, "💊"),
                new StreakItem("s4", "Focus & Study Streak", "Productivity", 15, 18, "🎓"),
                new StreakItem("s5", "Goal Crusher", "Productivity", 8, 10, "🎯")
        ));
        streaksLiveData.setValue(initialStreaks);

        List<AchievementBadge> initialBadges = new ArrayList<>(Arrays.asList(
                new AchievementBadge("b1", "First Week Completed", "Completed all daily reminders for 7 consecutive days", "⭐", true, "Oct 1, 2025"),
                new AchievementBadge("b2", "7-Day Health Streak", "Maintained water & walking targets for a full week", "🔥", true, "Oct 2, 2025"),
                new AchievementBadge("b3", "30-Day Master", "Logged into LifeSync every day for a month", "👑", true, "Sep 28, 2025"),
                new AchievementBadge("b4", "100-Day Legend", "Achieved 100 perfect day scores", "🏆", false, null),
                new AchievementBadge("b5", "Health Champion", "Logged 100L water and 200,000 steps", "💚", true, "Sep 20, 2025"),
                new AchievementBadge("b6", "Productivity Master", "Cleared 50 high priority tasks on time", "⚡", true, "Sep 15, 2025"),
                new AchievementBadge("b7", "Goal Crusher", "Completed 10 monthly major goals", "🎯", false, null),
                new AchievementBadge("b8", "Legend Status", "Unlock all core achievements in LifeSync", "💎", false, null)
        ));
        badgesLiveData.setValue(initialBadges);

        List<NotificationItem> initialNotifications = new ArrayList<>(Arrays.asList(
                new NotificationItem("n1", "Team Meeting Starting Soon", "Q4 Product Strategy Team Meeting begins in 15 minutes.", "10:45 AM", "Meetings", false),
                new NotificationItem("n2", "Hydration Goal Alert", "You're 1.0L away from completing your 3.0L daily water goal!", "12:30 PM", "Health", false),
                new NotificationItem("n3", "Walking Streak Unlocked", "Great job! You achieved a 7-day walking streak.", "Yesterday", "Goals", true),
                new NotificationItem("n4", "Document Expiry Warning", "Passport renewal check due tomorrow morning.", "Yesterday", "System", true),
                new NotificationItem("n5", "Medicine Reminder Due", "Morning Medicine & Vitamins was marked as completed.", "09:05 AM", "Health", true)
        ));
        notificationsLiveData.setValue(initialNotifications);

        List<SyncAccount> initialSyncAccounts = new ArrayList<>(Arrays.asList(
                new SyncAccount("acc_1", "Google Calendar", "jenish.gadhiya@gmail.com", true, "2 mins ago"),
                new SyncAccount("acc_2", "Outlook Calendar", "j.gadhiya@outlook.com", true, "1 hour ago"),
                new SyncAccount("acc_3", "Device Local Calendar", "System Default Calendar", true, "Just now")
        ));
        syncAccountsLiveData.setValue(initialSyncAccounts);

        List<NotificationHistoryItem> initialHistory = new ArrayList<>(Arrays.asList(
                new NotificationHistoryItem("nh_1", "Morning Medicine & Vitamins", Category.MEDICINE, "09:00 AM", "09:02 AM", 0, "Completed"),
                new NotificationHistoryItem("nh_2", "Hydration Break 1", Category.WATER, "10:30 AM", "10:35 AM", 1, "Completed"),
                new NotificationHistoryItem("nh_3", "Yesterday Evening Walk", Category.WALKING, "05:00 PM", "05:15 PM", 0, "Completed"),
                new NotificationHistoryItem("nh_4", "Weekly Bill Review", Category.BILL_PAYMENT, "08:00 PM", null, 2, "Snoozed"),
                new NotificationHistoryItem("nh_5", "Blood Test Fasting Alert", Category.BLOOD_TEST, "07:00 AM", null, 0, "Missed")
        ));
        notificationHistoryLiveData.setValue(initialHistory);
    }

    public LiveData<List<ReminderItem>> getReminders() { return remindersLiveData; }
    public LiveData<List<GoalItem>> getGoals() { return goalsLiveData; }
    public LiveData<List<StreakItem>> getStreaks() { return streaksLiveData; }
    public LiveData<List<AchievementBadge>> getBadges() { return badgesLiveData; }
    public LiveData<List<NotificationItem>> getNotifications() { return notificationsLiveData; }
    public LiveData<List<SyncAccount>> getSyncAccounts() { return syncAccountsLiveData; }
    public LiveData<List<NotificationHistoryItem>> getNotificationHistory() { return notificationHistoryLiveData; }
    public LiveData<UserProfile> getUserProfile() { return userProfileLiveData; }
    public LiveData<AppSettings> getSettings() { return settingsLiveData; }
    public LiveData<ReminderItem> getActiveAlertReminder() { return activeAlertReminderLiveData; }

    public void toggleReminderCompletion(String id) {
        List<ReminderItem> current = remindersLiveData.getValue();
        if (current != null) {
            List<ReminderItem> updated = new ArrayList<>();
            for (ReminderItem item : current) {
                if (item.getId().equals(id)) {
                    item.setCompleted(!item.isCompleted());
                }
                updated.add(item);
            }
            remindersLiveData.setValue(updated);
        }
    }

    public void addQuickTask(String title, Category category) {
        List<ReminderItem> current = remindersLiveData.getValue();
        if (current == null) current = new ArrayList<>();
        List<ReminderItem> updated = new ArrayList<>(current);
        ReminderItem newItem = new ReminderItem(
                "rem_" + System.currentTimeMillis(),
                title,
                "Quick task created from My Day focus view",
                category,
                Priority.MEDIUM,
                "Today",
                "2025-10-03",
                RepeatFrequency.ONCE,
                false,
                true,
                null,
                "Chime",
                null
        );
        updated.add(0, newItem);
        remindersLiveData.setValue(updated);
    }

    public void addFullReminder(ReminderItem reminder) {
        List<ReminderItem> current = remindersLiveData.getValue();
        if (current == null) current = new ArrayList<>();
        List<ReminderItem> updated = new ArrayList<>(current);
        updated.add(0, reminder);
        remindersLiveData.setValue(updated);
    }

    public void deleteReminder(String id) {
        List<ReminderItem> current = remindersLiveData.getValue();
        if (current != null) {
            List<ReminderItem> updated = new ArrayList<>();
            for (ReminderItem item : current) {
                if (!item.getId().equals(id)) {
                    updated.add(item);
                }
            }
            remindersLiveData.setValue(updated);
        }
    }

    public void snoozeReminder(String id, int minutes) {
        List<ReminderItem> current = remindersLiveData.getValue();
        if (current != null) {
            List<ReminderItem> updated = new ArrayList<>();
            for (ReminderItem item : current) {
                if (item.getId().equals(id)) {
                    item.setSnoozeCount(item.getSnoozeCount() + 1);
                }
                updated.add(item);
            }
            remindersLiveData.setValue(updated);
        }
    }

    public void incrementGoalProgress(String goalId, float amount) {
        List<GoalItem> current = goalsLiveData.getValue();
        if (current != null) {
            List<GoalItem> updated = new ArrayList<>();
            for (GoalItem goal : current) {
                if (goal.getId().equals(goalId)) {
                    float newProgress = Math.min(goal.getCurrentProgress() + amount, goal.getTargetGoal());
                    goal.setCurrentProgress(newProgress);
                }
                updated.add(goal);
            }
            goalsLiveData.setValue(updated);
        }
    }

    public void markNotificationRead(String id) {
        List<NotificationItem> current = notificationsLiveData.getValue();
        if (current != null) {
            List<NotificationItem> updated = new ArrayList<>();
            for (NotificationItem item : current) {
                if (item.getId().equals(id)) {
                    item.setRead(true);
                }
                updated.add(item);
            }
            notificationsLiveData.setValue(updated);
        }
    }

    public void clearAllNotifications() {
        notificationsLiveData.setValue(new ArrayList<>());
    }

    public void updateThemeMode(ThemeMode themeMode) {
        AppSettings settings = settingsLiveData.getValue();
        if (settings != null) {
            settings.setThemeMode(themeMode);
            settingsLiveData.setValue(settings);
        }
    }

    public void triggerAlert(ReminderItem reminder) {
        activeAlertReminderLiveData.setValue(reminder);
    }

    public void dismissAlert() {
        activeAlertReminderLiveData.setValue(null);
    }
}
