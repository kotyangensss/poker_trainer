package com.example.pokertrainer

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BotActivity : AppCompatActivity() {
    private lateinit var returnButton: ImageButton
    private lateinit var nicknameTextView: TextView
    private lateinit var foldButton: ImageButton
    private lateinit var callButton: ImageButton
    private lateinit var betButton: ImageButton
    private lateinit var firstCard: ImageView
    private lateinit var secondCard: ImageView
    private lateinit var enemyFirstCard: ImageView
    private lateinit var enemySecondCard: ImageView
    private lateinit var flopCard1: ImageView
    private lateinit var flopCard2: ImageView
    private lateinit var flopCard3: ImageView
    private lateinit var turnCard: ImageView
    private lateinit var riverCard: ImageView
    private lateinit var nextButton: ImageButton
    private var yourStack: UInt = 10000u
    private var enemyStack: UInt = 10000u
    private var bank: UInt = 0u
    private var smallBlind: UInt = 0u
    private var bigBlind: UInt = 0u
    private var round: UInt = 0u
    private var isYourMove: Boolean = true
    private var cards = arrayOfNulls<Card>(9)
    private var starege: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        hideSystemUI(window, View(this))
        setContentView(R.layout.activity_bot)

        // server

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.69:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service : GameController = retrofit.create(GameController::class.java)
        val call : Call<Boolean> = service.add(this.intent.getStringExtra("nickname").toString(), 54)
        call.enqueue(object :Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                val bin : Boolean? = response.body()
                Log.d("SERVER", "Все вроде четко !!!! $bin")

            }

            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                Log.d("SERVER", "ПрОиЗоШеЛ троллинг")
            }
        })


        //

        returnButton = findViewById(R.id.returnButton)
        nicknameTextView = findViewById(R.id.nicknameTextView)
        foldButton = findViewById(R.id.foldButton)
        callButton = findViewById(R.id.callButton)
        betButton = findViewById(R.id.betButton)
        firstCard = findViewById(R.id.myCard1)
        secondCard = findViewById(R.id.myCard2)
        enemyFirstCard = findViewById(R.id.enemyCard1)
        enemySecondCard = findViewById(R.id.enemyCard2)
        flopCard1 = findViewById(R.id.flopCard1)
        flopCard2 = findViewById(R.id.flopCard2)
        flopCard3 = findViewById(R.id.flopCard3)
        turnCard = findViewById(R.id.turnCard)
        riverCard = findViewById(R.id.riverCard)
        nextButton = findViewById(R.id.nextButton)
        nicknameTextView.text = intent.getStringExtra("nickname").toString()

        startRound()
    }

    fun setImage(view: ImageView, card: Card?) {
        val id =
            resources.getIdentifier(
                "com.example.pokertrainer:drawable/${card?.getPic()}",
                null,
                null
            )
        view.setImageResource(id)
    }

    override fun onResume() {
        super.onResume()

        onTouchAnimated(callButton, foldButton, betButton, returnButton)

        foldButton.setOnClickListener {
            if (starege != -1) {
                MediaPlayer.create(this, R.raw.elkipalki).start()
                endRound()
            }
        }
        callButton.setOnClickListener {
            if (starege != -1) {
                MediaPlayer.create(this, R.raw.pudg).start()
                starege += 1
                nextStage(starege)
            }
        }
        betButton.setOnClickListener {
            if (starege != -1) {
                MediaPlayer.create(this, R.raw.shaverma).start()
            }
        }
        returnButton.setOnClickListener {
            MediaPlayer.create(this, R.raw.pudgety).start()
            this.finish()
        }
        nextButton.setOnClickListener {
            MediaPlayer.create(this, R.raw.oooda).start()
            starege += 1
            nextStage(starege)
        }

    }

    private fun nextStage(stage: Int) {
        when (stage) {
            0 -> startRound()
            1 -> startFlop()
            2 -> startTurn()
            3 -> startRiver()
            4 -> endRound()
        }
    }

    private fun addCard(): Card {
        var tempCard = generateCard()
        var i = 0

        while (i != 9 && cards[i] != null) {
            if (cards[i]?.equal(tempCard) == true) {
                tempCard = generateCard()
                i = 0
            }
            i += 1
        }
        return tempCard
    }

    private fun startRound() {
        flopCard1.setImageDrawable(null)
        flopCard2.setImageDrawable(null)
        flopCard3.setImageDrawable(null)
        turnCard.setImageDrawable(null)
        riverCard.setImageDrawable(null)
        val id =
            resources.getIdentifier(
                "com.example.pokertrainer:drawable/back",
                null,
                null
            )
        enemyFirstCard.setImageResource(id)
        enemySecondCard.setImageResource(id)
        for (i in 0..8) {
            cards[i] = null
        }
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
        for (i in 0..3) {
            cards[i] = addCard()
        }
        setImage(firstCard, cards[0])
        setImage(secondCard, cards[1])
    }

    private fun startFlop() {
        for (i in 4..6) {
            cards[i] = addCard()
        }
        setImage(flopCard1, cards[4])
        setImage(flopCard2, cards[5])
        setImage(flopCard3, cards[6])

    }

    private fun startTurn() {
        cards[7] = addCard()
        setImage(turnCard, cards[7])
    }

    private fun startRiver() {
        cards[8] = addCard()
        setImage(riverCard, cards[8])
    }

    private fun endRound() {
        starege = -1
        setImage(enemyFirstCard, cards[2])
        setImage(enemySecondCard, cards[3])
    }
}