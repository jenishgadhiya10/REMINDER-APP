package com.example.reminderapp.data;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LifeSyncAlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String title = intent.getStringExtra("TITLE");
        if (title == null) title = "LifeSync Reminder Alert";

        String message = intent.getStringExtra("MESSAGE");
        if (message == null) message = "You have a scheduled task due now.";

        LifeSyncNotificationHelper.showNotification(context, title, message, (int) System.currentTimeMillis());
    }
}
