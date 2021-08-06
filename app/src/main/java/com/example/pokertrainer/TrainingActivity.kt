package com.example.pokertrainer

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class TrainingActivity : AppCompatActivity() {

    private lateinit var returnButton : ImageButton
    var card = generateCard()
    private lateinit var firstCard : ImageButton
    private lateinit var secondCard : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_training)

        returnButton = findViewById(R.id.returnButton)
        firstCard = findViewById(R.id.firstCard)
        secondCard = findViewById(R.id.secondCard)
    }

    override fun onResume() {
        super.onResume()
        onTouchAnimated(returnButton)
        onTouchAnimated(firstCard)
        onTouchAnimated(secondCard)

        firstCard.setOnClickListener {
            val id =
                resources.getIdentifier("com.example.pokertrainer:drawable/${card.getPic()}", null, null)
            firstCard.setImageResource(id)
            card = generateCard()
        }

        secondCard.setOnClickListener {
            val id =
                resources.getIdentifier("com.example.pokertrainer:drawable/${card.getPic()}", null, null)
            secondCard.setImageResource(id)
            card = generateCard()
        }

        returnButton.setOnClickListener {
            this.finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("ABOBA", "onDestroy")
    }
}