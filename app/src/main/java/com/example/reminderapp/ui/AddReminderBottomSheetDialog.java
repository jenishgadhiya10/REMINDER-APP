package com.example.reminderapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.reminderapp.R;
import com.example.reminderapp.model.Category;
import com.example.reminderapp.model.Priority;
import com.example.reminderapp.model.ReminderItem;
import com.example.reminderapp.model.RepeatFrequency;
import com.example.reminderapp.viewmodel.LifeSyncViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class AddReminderBottomSheetDialog extends BottomSheetDialogFragment {

    private LifeSyncViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_add_reminder, container, false);

        EditText etTitle = view.findViewById(R.id.et_reminder_title);
        EditText etDescription = view.findViewById(R.id.et_reminder_description);
        EditText etDate = view.findViewById(R.id.et_reminder_date);
        EditText etTime = view.findViewById(R.id.et_reminder_time);
        Spinner spinnerCategory = view.findViewById(R.id.spinner_category);
        Button btnSave = view.findViewById(R.id.btn_save_reminder);

        List<String> categoryNames = new ArrayList<>();
        for (Category cat : Category.values()) {
            categoryNames.add(cat.getEmoji() + " " + cat.getDisplayName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, categoryNames);
        spinnerCategory.setAdapter(adapter);

        btnSave.setOnClickListener(v -> {
            String title = etTitle.getText().toString().trim();
            if (!title.isEmpty() && viewModel != null) {
                Category cat = Category.values()[spinnerCategory.getSelectedItemPosition()];
                ReminderItem item = new ReminderItem(
                        "rem_" + System.currentTimeMillis(),
                        title,
                        etDescription.getText().toString().trim(),
                        cat,
                        Priority.HIGH,
                        etTime.getText().toString().trim(),
                        etDate.getText().toString().trim(),
                        RepeatFrequency.DAILY,
                        false,
                        true,
                        null,
                        "Gentle Bell",
                        null
                );
                viewModel.addFullReminder(item);
                dismiss();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(LifeSyncViewModel.class);
    }
}
