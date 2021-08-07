package com.example.pokertrainer

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BotActivity : AppCompatActivity() {

    private lateinit var returnButton: ImageButton
    private lateinit var nicknameTextView: TextView
    private lateinit var foldButton: ImageButton
    private lateinit var callButton: ImageButton
    private lateinit var betButton: ImageButton
    private lateinit var firstCard: ImageView
    private lateinit var secondCard: ImageView
    private var yourStack: UInt = 10000u
    private var enemyStack: UInt = 10000u
    private var bank: UInt = 0u
    private var smallBlind: UInt = 0u
    private var bigBlind: UInt = 0u
    private var round: UInt = 0u
    private var isYourMove: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        hideSystemUI(window, View(this))
        setContentView(R.layout.activity_bot)

        returnButton = findViewById(R.id.returnButton)
        nicknameTextView = findViewById(R.id.nicknameTextView)
        foldButton = findViewById(R.id.foldButton)
        callButton = findViewById(R.id.callButton)
        betButton = findViewById(R.id.betButton)
        firstCard = findViewById(R.id.myCard1)
        secondCard = findViewById(R.id.myCard2)
        nicknameTextView.text = intent.getStringExtra("nickname").toString()

        startRound()
    }

    override fun onResume() {
        super.onResume()

        onTouchAnimated(callButton, foldButton, betButton, returnButton)

        foldButton.setOnClickListener {
            MediaPlayer.create(this, R.raw.elkipalki).start()
            startRound()
        }
        callButton.setOnClickListener {
            MediaPlayer.create(this, R.raw.pudg).start()
        }
        betButton.setOnClickListener {
            MediaPlayer.create(this, R.raw.shaverma).start()
        }

        returnButton.setOnClickListener {
            MediaPlayer.create(this, R.raw.pudgety).start()
            this.finish()
        }
    }

    private fun startRound() {
        round += 1u
        bank += smallBlind + bigBlind
        if (isYourMove) {
            if (yourStack > smallBlind) {
                yourStack -= smallBlind
            }
            if (enemyStack > bigBlind) {
                enemyStack -= bigBlind
            }
        } else {
            if (enemyStack > smallBlind) {
                enemyStack -= smallBlind
            }
            if (yourStack > bigBlind) {
                yourStack -= bigBlind
            }
        }
        isYourMove = !isYourMove
        firstCard.imageAlpha = 255
        secondCard.imageAlpha = 255
        val card1 = generateCard()
        var card2 = generateCard()
        var card3 = generateCard()
        var card4 = generateCard()
        while (card1.getVal() == card2.getVal() && card1.getVal() == card2.getVal()) {
            card2 = generateCard()
        }
        while (card3.getVal() == card2.getVal() && card3.getVal() == card2.getVal()
            || card3.getVal() == card1.getVal() && card3.getVal() == card1.getVal()) {
            card3 = generateCard()
        }
        while (card4.getVal() == card3.getVal() && card4.getVal() == card3.getVal()
            ||card4.getVal() == card2.getVal() && card4.getVal() == card2.getVal()
            || card4.getVal() == card1.getVal() && card4.getVal() == card1.getVal()) {
            card4 = generateCard()
        }

        var id =
            resources.getIdentifier(
                "com.example.pokertrainer:drawable/${card1.getPic()}",
                null,
                null
            )
        firstCard.setImageResource(id)
        id =
            resources.getIdentifier(
                "com.example.pokertrainer:drawable/${card2.getPic()}",
                null,
                null
            )
        secondCard.setImageResource(id)
    }

    private fun startFlop(){}

    private fun startTurn(){}

    private fun startRiver(){}
}