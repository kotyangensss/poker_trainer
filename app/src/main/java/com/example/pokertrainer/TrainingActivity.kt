package com.example.pokertrainer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class TrainingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_training)
    }
    fun returnButton(view: android.view.View?){
        val intent = Intent(this@TrainingActivity, MainActivity::class.java)
        startActivity(intent)
        this.finish()
    }
}