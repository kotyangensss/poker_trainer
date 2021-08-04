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
        val button = findViewById<ImageButton>(R.id.botbutton)
        button.alpha = 0.9F
        val intent = Intent(this@MainActivity, BotActivity::class.java)
        this.finish()
        startActivity(intent)
    }

    fun exit(view: android.view.View?){
       this.finish()
    }
}