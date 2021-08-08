package com.example.pokertrainer

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import java.nio.channels.AlreadyBoundException

class MainActivity : AppCompatActivity() {
    private lateinit var playButton : ImageButton
    private lateinit var trainingButton : ImageButton
    private lateinit var settingsButton : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        hideSystemUI(window, View(this))
        setContentView(R.layout.activity_main)

        playButton = findViewById(R.id.playButton)
        trainingButton = findViewById(R.id.trainingButton)
        settingsButton = findViewById(R.id.settingsButton)
    }

    override fun onResume() {
        super.onResume()

        onTouchAnimated(playButton, trainingButton, settingsButton)

        playButton.setOnClickListener {
            MediaPlayer.create(this, R.raw.zadelo).start()
            openNicknameDialog()
        }

        trainingButton.setOnClickListener {
            MediaPlayer.create(this, R.raw.xorowego).start()
            val trainingActivity = Intent(this, TrainingActivity::class.java)
            startActivity(trainingActivity)
        }

        settingsButton.setOnClickListener {
            MediaPlayer.create(this, R.raw.wtani).start()
            openSettingsDialog()
        }
    }



    private fun openNicknameDialog() { // здесь открывается диалог для ввода никнейма, который потом принимает текствью с никнеймом
        val view = View.inflate(this@MainActivity, R.layout.nickname_window, null)

        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setView(view)

        val dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(true)

        val submitButton : ImageButton = view.findViewById(R.id.submitButton)
        val nicknameEt : EditText = view.findViewById(R.id.nicknameEditText)

        submitButton.setOnClickListener {
            dialog.dismiss()
            MediaPlayer.create(this, R.raw.yapudge).start()
            val playActivity = Intent(this, BotActivity::class.java)
            playActivity.putExtra("nickname", nicknameEt.text.toString()) // передаю в интент введенный ник
            startActivity(playActivity)
        }

        dialog.show()
    }

    private fun openSettingsDialog() {
        val view = View.inflate(this, R.layout.settings_window, null)

        val builder = AlertDialog.Builder(this)
        builder.setView(view)

        val dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(true)

        val soundButton : ImageButton = view.findViewById(R.id.soundButton)

        soundButton.setOnClickListener {
            MediaPlayer.create(this, R.raw.pudge).start()
        }

        dialog.show()
    }
}