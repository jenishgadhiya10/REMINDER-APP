package com.example.reminderapp.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reminderapp.R;
import com.example.reminderapp.model.Category;
import com.example.reminderapp.model.ReminderItem;
import com.example.reminderapp.ui.components.CircularProgressRingView;
import com.example.reminderapp.viewmodel.LifeSyncViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyDayFragment extends Fragment {

    private LifeSyncViewModel viewModel;
    private ReminderAdapter adapter;
    private CircularProgressRingView progressRing;
    private EditText etQuickTask;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_day, container, false);

        progressRing = view.findViewById(R.id.ring_my_day);
        etQuickTask = view.findViewById(R.id.et_quick_task);
        Button btnQuickAdd = view.findViewById(R.id.btn_quick_add);
        RecyclerView rvReminders = view.findViewById(R.id.rv_my_day_reminders);

        rvReminders.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ReminderAdapter(new ReminderAdapter.OnReminderClickListener() {
            @Override
            public void onToggleComplete(ReminderItem item) {
                viewModel.toggleReminderCompletion(item.getId());
            }

            @Override
            public void onDelete(ReminderItem item) {
                viewModel.deleteReminder(item.getId());
            }

            @Override
            public void onItemClick(ReminderItem item) {
                viewModel.triggerAlert(item);
            }
        });
        rvReminders.setAdapter(adapter);

        btnQuickAdd.setOnClickListener(v -> {
            String text = etQuickTask.getText().toString().trim();
            if (!text.isEmpty()) {
                viewModel.addQuickTask(text, Category.CUSTOM);
                etQuickTask.setText("");
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(LifeSyncViewModel.class);

        viewModel.getReminders().observe(getViewLifecycleOwner(), reminders -> {
            List<ReminderItem> myDayList = new ArrayList<>();
            int completedCount = 0;
            if (reminders != null) {
                for (ReminderItem item : reminders) {
                    if (item.isMyDay()) {
                        myDayList.add(item);
                        if (item.isCompleted()) {
                            completedCount++;
                        }
                    }
                }
            }
            adapter.setReminders(myDayList);

            float ratio = myDayList.isEmpty() ? 0f : (float) completedCount / myDayList.size();
            int pct = (int) (ratio * 100);
            progressRing.setProgress(ratio, pct + "%", Color.parseColor("#4F46E5"));
        });
    }
}
