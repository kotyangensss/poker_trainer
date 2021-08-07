package com.example.pokertrainer

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class TrainingActivity : AppCompatActivity() {

    private lateinit var dialog: Dialog

    private lateinit var returnButton: ImageButton
    private lateinit var firstCard: ImageView
    private lateinit var secondCard: ImageView

    private lateinit var firstSetCard : ImageView
    private lateinit var secondSetCard : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        hideSystemUI(window, View(this))
        setContentView(R.layout.activity_training)

        dialog = Dialog(this)

        returnButton = findViewById(R.id.returnButton)
        firstCard = findViewById(R.id.firstCard)
        secondCard = findViewById(R.id.secondCard)

        firstSetCard = findViewById(R.id.firstSetCard)
        secondSetCard = findViewById(R.id.secondSetCard)
    }

    override fun onResume() {
        super.onResume()
        onTouchAnimated(returnButton, firstCard, secondCard)

        firstCard.setOnClickListener {
            chooseSuitDialog(dialog, "first")
        }
        secondCard.setOnClickListener {
            chooseSuitDialog(dialog, "second")
        }
        returnButton.setOnClickListener {
            this.finish()
        }
    }


    private fun chooseSuitDialog(dialog: Dialog, whichPressed : String) {
        dialog.setContentView(R.layout.choose_suit)
        val peaks: ImageView = dialog.findViewById(R.id.imagePeaks)
        val hearts: ImageView = dialog.findViewById(R.id.imageHearts)
        val diamonds: ImageView = dialog.findViewById(R.id.imageDiamonds)
        val clubs: ImageView = dialog.findViewById(R.id.imageClubs)

        onTouchAnimated(peaks, hearts, diamonds, clubs)

        dialog.show()

        peaks.setOnClickListener {
            dialog.dismiss()
             chooseValDialog(dialog, "_peaks", whichPressed)
        }
        hearts.setOnClickListener {
            dialog.dismiss()
            chooseValDialog(dialog, "_hearts", whichPressed)
        }
        clubs.setOnClickListener {
            dialog.dismiss()
            chooseValDialog(dialog, "_clubs", whichPressed)
        }
        diamonds.setOnClickListener {
            dialog.dismiss()
            chooseValDialog(dialog, "_diamonds", whichPressed)
        }
    }

    private fun chooseValDialog(dialog: Dialog, suit: String, whichPressed: String) {
        dialog.setContentView(R.layout.choose_value)

        val two: ImageView = dialog.findViewById(R.id.imageTwo)
        val three: ImageView = dialog.findViewById(R.id.imageThree)
        val four: ImageView = dialog.findViewById(R.id.imageFour)
        val five: ImageView = dialog.findViewById(R.id.imageFive)
        val six: ImageView = dialog.findViewById(R.id.imageSix)
        val seven: ImageView = dialog.findViewById(R.id.imageSeven)
        val eight: ImageView = dialog.findViewById(R.id.imageEight)
        val nine: ImageView = dialog.findViewById(R.id.imageNine)
        val ten: ImageView = dialog.findViewById(R.id.imageTen)
        val jack: ImageView = dialog.findViewById(R.id.imageJack)
        val queen: ImageView = dialog.findViewById(R.id.imageQueen)
        val king: ImageView = dialog.findViewById(R.id.imageKing)
        val ace: ImageView = dialog.findViewById(R.id.imageAce)

        onTouchAnimated(two, three, four, five, six, seven, eight, nine, ten, jack, queen, king, ace)

        // этой функцией убрал миллионы строк кода
        fun setId(vararg cardImages : ImageView) {
            val arr : Array<String> = arrayOf("x2", "x3", "x4", "x5", "x6", "x7", "x8", "x9", "x10", "j", "q", "k", "a")

            for ((iteration, currCard) in cardImages.withIndex()) {
                val resID: Int = currCard.context.resources
                    .getIdentifier("${arr[iteration]}$suit", "drawable", currCard.context.packageName)
                currCard.setImageResource(resID)
            }
        }

        setId(two, three, four, five, six, seven, eight, nine, ten, jack, queen, king, ace)
        dialog.show()

        fun setOnClickForAllImages(vararg images : ImageView) {
            for (image in images) {
                image.setOnClickListener {
                    dialog.dismiss()
                    if (whichPressed == "first") {
                        firstCard.setImageDrawable(image.drawable)
                    } else {
                        secondCard.setImageDrawable(image.drawable)
                    }
                }
            }
        }

        setOnClickForAllImages(two, three, four, five, six, seven, eight, nine, ten, jack, queen, king, ace)
    }
}