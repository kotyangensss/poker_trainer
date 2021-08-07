package com.example.pokertrainer

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class TrainingActivity : AppCompatActivity() {

    private lateinit var dialog: Dialog
    private lateinit var returnButton: ImageButton
    var card1 = generateCard()
    var card2 = generateCard()
    private lateinit var firstCard: ImageView
    private lateinit var secondCard: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        setContentView(R.layout.activity_training)
        returnButton = findViewById(R.id.returnButton)
        firstCard = findViewById(R.id.firstCard)
        secondCard = findViewById(R.id.secondCard)
        dialog = Dialog(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }


    override fun onResume() {
        super.onResume()
        onTouchAnimated(returnButton)
        onTouchImage(firstCard)
        onTouchImage(secondCard)

        firstCard.setOnClickListener {
            chooseSuitDialog(dialog)
//            val resID: Int = firstCard.context.resources
//                .getIdentifier(card1.getPic(), "drawable", firstCard.context.packageName)
//            firstCard.setImageResource(resID)
        }
        secondCard.setOnClickListener {
            chooseSuitDialog(dialog)
//            val resID: Int = secondCard.context.resources
//                .getIdentifier(card2.getPic(), "drawable", secondCard.context.packageName)
//            secondCard.setImageResource(resID)

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