package com.example.reminderapp.ui;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reminderapp.R;
import com.example.reminderapp.model.ReminderItem;

import java.util.ArrayList;
import java.util.List;

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ReminderViewHolder> {

    private List<ReminderItem> reminders = new ArrayList<>();
    private final OnReminderClickListener listener;

    public interface OnReminderClickListener {
        void onToggleComplete(ReminderItem item);
        void onDelete(ReminderItem item);
        void onItemClick(ReminderItem item);
    }

    public ReminderAdapter(OnReminderClickListener listener) {
        this.listener = listener;
    }

    public void setReminders(List<ReminderItem> reminders) {
        this.reminders = reminders != null ? reminders : new ArrayList<>();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReminderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reminder, parent, false);
        return new ReminderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReminderViewHolder holder, int position) {
        ReminderItem item = reminders.get(position);
        holder.bind(item, listener);
    }

    @Override
    public int getItemCount() {
        return reminders.size();
    }

    static class ReminderViewHolder extends RecyclerView.ViewHolder {
        CheckBox cbCompleted;
        TextView tvTitle, tvDescription, tvCategory, tvPriority, tvTime;
        ImageButton btnDelete;

        public ReminderViewHolder(@NonNull View itemView) {
            super(itemView);
            cbCompleted = itemView.findViewById(R.id.cb_completed);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvCategory = itemView.findViewById(R.id.tv_category);
            tvPriority = itemView.findViewById(R.id.tv_priority);
            tvTime = itemView.findViewById(R.id.tv_time);
            btnDelete = itemView.findViewById(R.id.btn_delete);
        }

        public void bind(ReminderItem item, OnReminderClickListener listener) {
            tvTitle.setText(item.getTitle());
            tvDescription.setText(item.getDescription());

            if (item.isCompleted()) {
                tvTitle.setPaintFlags(tvTitle.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                tvTitle.setPaintFlags(tvTitle.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            }

            cbCompleted.setOnCheckedChangeListener(null);
            cbCompleted.setChecked(item.isCompleted());
            cbCompleted.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (listener != null) listener.onToggleComplete(item);
            });

            if (item.getCategory() != null) {
                tvCategory.setText(item.getCategory().getEmoji() + " " + item.getCategory().getDisplayName());
            }

            if (item.getPriority() != null) {
                tvPriority.setText(item.getPriority().getLabel());
                try {
                    tvPriority.setTextColor(Color.parseColor(item.getPriority().getColorHex()));
                } catch (Exception ignored) {}
            }

            tvTime.setText("⏰ " + item.getTime());

            btnDelete.setOnClickListener(v -> {
                if (listener != null) listener.onDelete(item);
            });

            itemView.setOnClickListener(v -> {
                if (listener != null) listener.onItemClick(item);
            });
        }
    }
}
