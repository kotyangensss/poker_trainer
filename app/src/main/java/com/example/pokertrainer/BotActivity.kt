package com.example.pokertrainer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView

class BotActivity : AppCompatActivity() {

    private lateinit var returnButton: ImageButton
    private lateinit var nicknameTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_bot)

        returnButton = findViewById(R.id.returnButton)
        nicknameTextView = findViewById(R.id.nicknameTextView)
        nicknameTextView.setText(intent.getStringExtra("nickname").toString())
    }

    override fun onResume() {
        super.onResume()

        returnButton.setOnClickListener {
            this.finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("ABOBA", "onDestroy")
    }
}