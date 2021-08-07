package com.example.pokertrainer

import android.app.Dialog
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var dialog : Dialog // а вот и решение проблемы

    private lateinit var playButton : ImageButton
    private lateinit var trainingButton : ImageButton
    private lateinit var settingsButton : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        hideSystemUI(window, View(this))
        setContentView(R.layout.activity_main)

        dialog = Dialog(this)

        playButton = findViewById(R.id.playButton)
        trainingButton = findViewById(R.id.trainingButton)
        settingsButton = findViewById(R.id.settingsButton)
    }

    override fun onResume() {
        super.onResume()

        onTouchAnimated(playButton, trainingButton, settingsButton)

        playButton.setOnClickListener {
            openNicknameDialog()
        }

        trainingButton.setOnClickListener {
            val trainingActivity = Intent(this, TrainingActivity::class.java)
            startActivity(trainingActivity)
        }

        settingsButton.setOnClickListener {
            openSettingsDialog()
        }
    }



    private fun openNicknameDialog() { // здесь открывается диалог для ввода никнейма, который потом принимает текствью с никнеймом
        dialog.setContentView(R.layout.nickname_window)

        val submitButton : ImageButton = dialog.findViewById(R.id.submitButton)
        val nicknameEt : EditText = dialog.findViewById(R.id.nicknameEditText)

        dialog.show()

        submitButton.setOnClickListener {
            dialog.dismiss()
            val playActivity = Intent(this, BotActivity::class.java)
            playActivity.putExtra("nickname", nicknameEt.text.toString()) // передаю в интент введенный ник
            startActivity(playActivity)
        }
    }

    private fun openSettingsDialog() {
        dialog.setContentView(R.layout.settings_window)

        val soundButton : ImageButton = dialog.findViewById(R.id.soundButton)

        soundButton.setOnClickListener {
            MediaPlayer.create(this, R.raw.pudge).start()
        }

        dialog.show()
    }
}