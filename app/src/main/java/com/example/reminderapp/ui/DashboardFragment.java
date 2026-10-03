package com.example.reminderapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reminderapp.R;
import com.example.reminderapp.model.ReminderItem;
import com.example.reminderapp.viewmodel.LifeSyncViewModel;

import java.util.List;

public class DashboardFragment extends Fragment {

    private LifeSyncViewModel viewModel;
    private ReminderAdapter adapter;
    private TextView tvSummaryTotal, tvSummaryCompleted;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        tvSummaryTotal = view.findViewById(R.id.tv_summary_total);
        tvSummaryCompleted = view.findViewById(R.id.tv_summary_completed);
        RecyclerView rvTimeline = view.findViewById(R.id.rv_dashboard_timeline);

        rvTimeline.setLayoutManager(new LinearLayoutManager(getContext()));
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
        rvTimeline.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(LifeSyncViewModel.class);

        viewModel.getReminders().observe(getViewLifecycleOwner(), reminders -> {
            if (reminders != null) {
                int total = reminders.size();
                int completed = 0;
                for (ReminderItem item : reminders) {
                    if (item.isCompleted()) completed++;
                }
                tvSummaryTotal.setText(String.valueOf(total));
                tvSummaryCompleted.setText(String.valueOf(completed));
                adapter.setReminders(reminders);
            }
        });
    }
}
