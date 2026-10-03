package com.example.reminderapp.ui.components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class WeeklyBarChartView extends View {

    private Paint barPaint;
    private Paint trackPaint;
    private Paint labelPaint;
    private RectF rectF;

    private final String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    private final float[] values = {0.85f, 0.90f, 0.75f, 0.95f, 0.88f, 0.92f, 0.80f};

    public WeeklyBarChartView(Context context) {
        super(context);
        init();
    }

    public WeeklyBarChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        rectF = new RectF();

        barPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        barPaint.setColor(Color.parseColor("#4F46E5"));

        trackPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        trackPaint.setColor(Color.parseColor("#224F46E5"));

        labelPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        labelPaint.setColor(Color.parseColor("#64748B"));
        labelPaint.setTextSize(26f);
        labelPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float width = getWidth();
        float height = getHeight();
        float chartHeight = height - 50f;

        float barWidth = 32f;
        float spacing = (width - (days.length * barWidth)) / (days.length + 1);

        for (int i = 0; i < days.length; i++) {
            float x = spacing + i * (barWidth + spacing);
            float valRatio = values[i];
            float barH = chartHeight * valRatio;

            // Track background
            rectF.set(x, 0, x + barWidth, chartHeight);
            canvas.drawRoundRect(rectF, 12f, 12f, trackPaint);

            // Active bar
            rectF.set(x, chartHeight - barH, x + barWidth, chartHeight);
            canvas.drawRoundRect(rectF, 12f, 12f, barPaint);

            // Day Label
            canvas.drawText(days[i], x + barWidth / 2f, height - 10f, labelPaint);
        }
    }
}
