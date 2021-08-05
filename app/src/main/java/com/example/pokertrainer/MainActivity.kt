package com.example.pokertrainer

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val playButton : ImageButton = findViewById(R.id.playButton)
        val trainingButton : ImageButton = findViewById(R.id.trainingButton)
        val settingsButton : ImageButton = findViewById(R.id.settingsButton)

        playButton.setOnTouchListener { v, event ->
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> playButton.animate().scaleX(1.1f).scaleY(1.1f).duration = 50
                MotionEvent.ACTION_UP -> playButton.animate().scaleX(1f).scaleY(1f).duration = 50
            }
            v?.onTouchEvent(event) ?: true
        }

        playButton.setOnClickListener {
            val playActivity = Intent(this, BotActivity::class.java)
            startActivity(playActivity)
        }

        trainingButton.setOnTouchListener { v, event ->
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> trainingButton.animate().scaleX(1.1f).scaleY(1.1f).duration = 50
                MotionEvent.ACTION_UP -> trainingButton.animate().scaleX(1f).scaleY(1f).duration = 50
            }
            v?.onTouchEvent(event) ?: true
        }

        trainingButton.setOnClickListener {
            val trainingActivity = Intent(this, TrainingActivity::class.java)
            startActivity(trainingActivity)
        }

        settingsButton.setOnTouchListener { v, event ->
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> settingsButton.animate().scaleX(1.1f).scaleY(1.1f).duration = 50
                MotionEvent.ACTION_UP -> settingsButton.animate().scaleX(1f).scaleY(1f).duration = 50
            }
            v?.onTouchEvent(event) ?: true
        }

        settingsButton.setOnClickListener {
            var settingsDialog = SettingsDialogWindow()

            settingsDialog.show(supportFragmentManager, "customSettings")
        }
    }
}