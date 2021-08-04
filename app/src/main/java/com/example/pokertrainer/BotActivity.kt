package com.example.pokertrainer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class BotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bot)
    }
    fun returnButton(view: android.view.View?){
        val intent = Intent(this@BotActivity, MainActivity::class.java)
        startActivity(intent)
        this.finish()
    }
}