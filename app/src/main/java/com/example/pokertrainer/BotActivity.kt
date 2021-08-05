package com.example.pokertrainer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton

class BotActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_bot)

        val returnButton : ImageButton = findViewById(R.id.returnButton)

        returnButton.setOnClickListener {
            this.finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("ABOBA", "onDestroy")
    }
}