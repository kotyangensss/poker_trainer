package com.example.pokertrainer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton

class TrainingActivity : AppCompatActivity() {

    private lateinit var returnButton : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_training)

        returnButton = findViewById(R.id.returnButton)
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