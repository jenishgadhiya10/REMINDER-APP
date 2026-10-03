package com.example.reminderapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.reminderapp.R;
import com.example.reminderapp.model.ReminderItem;
import com.example.reminderapp.viewmodel.LifeSyncViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class SnoozeBottomSheetDialog extends BottomSheetDialogFragment {

    private LifeSyncViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_snooze, container, false);

        Button btn5 = view.findViewById(R.id.btn_snooze_5);
        Button btn15 = view.findViewById(R.id.btn_snooze_15);
        Button btn60 = view.findViewById(R.id.btn_snooze_60);

        View.OnClickListener listener = v -> {
            int mins = 15;
            if (v.getId() == R.id.btn_snooze_5) mins = 5;
            else if (v.getId() == R.id.btn_snooze_60) mins = 60;

            if (viewModel != null) {
                ReminderItem alert = viewModel.getActiveAlertReminder().getValue();
                if (alert != null) {
                    viewModel.snoozeReminder(alert.getId(), mins);
                    viewModel.dismissAlert();
                }
            }
            dismiss();
        };

        btn5.setOnClickListener(listener);
        btn15.setOnClickListener(listener);
        btn60.setOnClickListener(listener);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(LifeSyncViewModel.class);
    }
}
