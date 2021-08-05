package com.example.pokertrainer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
    }

    fun playWithBot(view: android.view.View?) {
        val intent = Intent(this@MainActivity, BotActivity::class.java)
        this.finish()
        startActivity(intent)
    }
    fun training(view: android.view.View?) {
        val intent = Intent(this@MainActivity, TrainingActivity::class.java)
        this.finish()
        startActivity(intent)
    }
}