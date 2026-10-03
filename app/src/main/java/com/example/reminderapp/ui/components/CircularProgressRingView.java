package com.example.reminderapp.ui.components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CircularProgressRingView extends View {

    private Paint trackPaint;
    private Paint progressPaint;
    private Paint textPaint;
    private RectF rectF;

    private float progress = 0.5f; // 0.0 to 1.0
    private String centerText = "50%";
    private int progressColor = Color.parseColor("#4F46E5");

    public CircularProgressRingView(Context context) {
        super(context);
        init();
    }

    public CircularProgressRingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        rectF = new RectF();

        trackPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        trackPaint.setStyle(Paint.Style.STROKE);
        trackPaint.setStrokeWidth(12f);
        trackPaint.setColor(Color.parseColor("#334F46E5"));

        progressPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        progressPaint.setStyle(Paint.Style.STROKE);
        progressPaint.setStrokeWidth(12f);
        progressPaint.setStrokeCap(Paint.Cap.ROUND);
        progressPaint.setColor(progressColor);

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.parseColor("#0F172A"));
        textPaint.setTextSize(28f);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setFakeBoldText(true);
    }

    public void setProgress(float progress, String centerText, int color) {
        this.progress = Math.max(0f, Math.min(1f, progress));
        this.centerText = centerText;
        this.progressColor = color;
        this.progressPaint.setColor(color);
        this.trackPaint.setColor((color & 0x00FFFFFF) | 0x33000000);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float padding = 16f;
        float width = getWidth() - padding * 2;
        float height = getHeight() - padding * 2;
        float size = Math.min(width, height);

        float left = (getWidth() - size) / 2f;
        float top = (getHeight() - size) / 2f;
        rectF.set(left, top, left + size, top + size);

        canvas.drawOval(rectF, trackPaint);

        float sweepAngle = progress * 360f;
        canvas.drawArc(rectF, -90f, sweepAngle, false, progressPaint);

        if (centerText != null && !centerText.isEmpty()) {
            float textY = (getHeight() / 2f) - ((textPaint.descent() + textPaint.ascent()) / 2f);
            canvas.drawText(centerText, getWidth() / 2f, textY, textPaint);
        }
    }
}
