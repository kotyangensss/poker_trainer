package com.example.pokertrainer

import android.view.MotionEvent
import android.widget.ImageButton
import android.widget.ImageView

fun onTouchAnimated(btn : ImageButton) {
    btn.setOnTouchListener { v, event ->
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> btn.animate().scaleX(1.1f).scaleY(1.1f).duration = 50
            MotionEvent.ACTION_UP -> btn.animate().scaleX(1f).scaleY(1f).duration = 50
        }
        v?.onTouchEvent(event) ?: true
    }
}

fun onTouchImage(img : ImageView) {
    img.setOnTouchListener { v, event ->
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> img.animate().scaleX(0.9f).scaleY(0.9f).duration = 50
            MotionEvent.ACTION_UP -> img.animate().scaleX(1f).scaleY(1f).duration = 50
        }
        v?.onTouchEvent(event) ?: true
    }
}
