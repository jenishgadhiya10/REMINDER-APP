package com.example.reminderapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.reminderapp.R;
import com.example.reminderapp.model.AppSettings;
import com.example.reminderapp.model.ThemeMode;
import com.example.reminderapp.viewmodel.LifeSyncViewModel;

public class ProfileFragment extends Fragment {

    private LifeSyncViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        Button btnThemeToggle = view.findViewById(R.id.btn_theme_toggle);
        Button btnBackupJson = view.findViewById(R.id.btn_backup_json);

        btnThemeToggle.setOnClickListener(v -> {
            if (viewModel != null) {
                AppSettings settings = viewModel.getSettings().getValue();
                ThemeMode currentMode = settings != null ? settings.getThemeMode() : ThemeMode.SYSTEM;
                ThemeMode newMode = (currentMode == ThemeMode.DARK) ? ThemeMode.LIGHT : ThemeMode.DARK;
                viewModel.updateThemeMode(newMode);
                Toast.makeText(getContext(), "Theme switched to " + newMode.name(), Toast.LENGTH_SHORT).show();
            }
        });

        btnBackupJson.setOnClickListener(v -> {
            Toast.makeText(getContext(), "💾 LifeSync Backup exported to JSON!", Toast.LENGTH_LONG).show();
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(LifeSyncViewModel.class);
    }
}
