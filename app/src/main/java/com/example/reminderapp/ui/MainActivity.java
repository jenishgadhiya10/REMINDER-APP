package com.example.reminderapp.ui;

import android.app.AlertDialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.reminderapp.R;
import com.example.reminderapp.data.LifeSyncNotificationHelper;
import com.example.reminderapp.model.ReminderItem;
import com.example.reminderapp.viewmodel.LifeSyncViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private LifeSyncViewModel viewModel;
    private AlertDialog activeAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LifeSyncNotificationHelper.createNotificationChannel(getApplicationContext());

        viewModel = new ViewModelProvider(this).get(LifeSyncViewModel.class);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new MyDayFragment())
                    .commit();
        }

        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.navigation_my_day) {
                selectedFragment = new MyDayFragment();
            } else if (itemId == R.id.navigation_dashboard) {
                selectedFragment = new DashboardFragment();
            } else if (itemId == R.id.navigation_calendar) {
                selectedFragment = new CalendarFragment();
            } else if (itemId == R.id.navigation_add) {
                AddReminderBottomSheetDialog addDialog = new AddReminderBottomSheetDialog();
                addDialog.show(getSupportFragmentManager(), "AddReminderDialog");
                return false;
            } else if (itemId == R.id.navigation_notifications) {
                selectedFragment = new NotificationsFragment();
            } else if (itemId == R.id.navigation_profile) {
                selectedFragment = new ProfileFragment();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
                return true;
            }
            return false;
        });

        viewModel.getActiveAlertReminder().observe(this, reminder -> {
            if (reminder != null) {
                showFullAlertOverlay(reminder);
            } else if (activeAlertDialog != null && activeAlertDialog.isShowing()) {
                activeAlertDialog.dismiss();
            }
        });
    }

    private void showFullAlertOverlay(ReminderItem reminder) {
        if (activeAlertDialog != null && activeAlertDialog.isShowing()) {
            activeAlertDialog.dismiss();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("🚨 " + reminder.getTitle());
        builder.setMessage(reminder.getDescription() + "\n\n⏰ Time: " + reminder.getTime());
        builder.setPositiveButton("✅ Complete", (dialog, which) -> {
            viewModel.toggleReminderCompletion(reminder.getId());
            viewModel.dismissAlert();
        });
        builder.setNeutralButton("😴 Snooze", (dialog, which) -> {
            SnoozeBottomSheetDialog snoozeDialog = new SnoozeBottomSheetDialog();
            snoozeDialog.show(getSupportFragmentManager(), "SnoozeDialog");
        });
        builder.setNegativeButton("❌ Dismiss", (dialog, which) -> {
            viewModel.dismissAlert();
        });

        activeAlertDialog = builder.create();
        activeAlertDialog.show();
    }
}
