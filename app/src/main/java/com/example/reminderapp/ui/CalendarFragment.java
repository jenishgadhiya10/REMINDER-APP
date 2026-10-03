package com.example.reminderapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reminderapp.R;
import com.example.reminderapp.model.ReminderItem;
import com.example.reminderapp.viewmodel.LifeSyncViewModel;

public class CalendarFragment extends Fragment {

    private LifeSyncViewModel viewModel;
    private ReminderAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        RecyclerView rvEvents = view.findViewById(R.id.rv_calendar_events);
        rvEvents.setLayoutManager(new LinearLayoutManager(getContext()));
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
        rvEvents.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(LifeSyncViewModel.class);

        viewModel.getReminders().observe(getViewLifecycleOwner(), reminders -> {
            adapter.setReminders(reminders);
        });
    }
}
