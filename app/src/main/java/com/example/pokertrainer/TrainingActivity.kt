package com.example.pokertrainer

import android.app.AlertDialog
import android.app.Dialog
import android.media.MediaPlayer
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
            MediaPlayer.create(this, R.raw.podros).start()
            this.finish()
        }
    }


    private fun chooseSuitDialog(dialog: Dialog, whichPressed : String) {
        dialog.setContentView(R.layout.choose_suit)

        hideDialogUI(dialog, this)

        val peaks: ImageView = dialog.findViewById(R.id.imagePeaks)
        val hearts: ImageView = dialog.findViewById(R.id.imageHearts)
        val diamonds: ImageView = dialog.findViewById(R.id.imageDiamonds)
        val clubs: ImageView = dialog.findViewById(R.id.imageClubs)

        onTouchAnimated(peaks, hearts, diamonds, clubs)

        dialog.show()

        peaks.setOnClickListener {
            dialog.dismiss()
             chooseValDialog("_peaks", whichPressed)
        }
        hearts.setOnClickListener {
            dialog.dismiss()
            chooseValDialog( "_hearts", whichPressed)
        }
        clubs.setOnClickListener {
            dialog.dismiss()
            chooseValDialog("_clubs", whichPressed)
        }
        diamonds.setOnClickListener {
            dialog.dismiss()
            chooseValDialog( "_diamonds", whichPressed)
        }
    }

    private fun chooseValDialog(suit: String, whichPressed: String) {
        val view = View.inflate(this, R.layout.choose_value, null)

        val builder = AlertDialog.Builder(this)
        builder.setView(view)

        val dialog1 = builder.create()
        dialog1.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog1.setCancelable(true)

        val two: ImageView = view.findViewById(R.id.imageTwo)
        val three: ImageView = view.findViewById(R.id.imageThree)
        val four: ImageView = view.findViewById(R.id.imageFour)
        val five: ImageView = view.findViewById(R.id.imageFive)
        val six: ImageView = view.findViewById(R.id.imageSix)
        val seven: ImageView = view.findViewById(R.id.imageSeven)
        val eight: ImageView =view.findViewById(R.id.imageEight)
        val nine: ImageView = view.findViewById(R.id.imageNine)
        val ten: ImageView = view.findViewById(R.id.imageTen)
        val jack: ImageView = view.findViewById(R.id.imageJack)
        val queen: ImageView = view.findViewById(R.id.imageQueen)
        val king: ImageView = view.findViewById(R.id.imageKing)
        val ace: ImageView = view.findViewById(R.id.imageAce)

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
        dialog1.show()

        fun setOnClickForAllImages(vararg images : ImageView) {
            for (image in images) {
                image.setOnClickListener {
                    dialog1.dismiss()
                    MediaPlayer.create(this, R.raw.wikarno).start()
                    if (whichPressed == "first") {
                        firstSetCard.setImageDrawable(image.drawable)
                    } else {
                        secondSetCard.setImageDrawable(image.drawable)
                    }
                }
            }
        }

        setOnClickForAllImages(two, three, four, five, six, seven, eight, nine, ten, jack, queen, king, ace)
    }
}