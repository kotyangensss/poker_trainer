package com.example.pokertrainer

import android.app.Dialog
import android.widget.ImageView

fun chooseValDialog(dialog: Dialog, suit: String) {
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
    onTouchImage(two)
    onTouchImage(three)
    onTouchImage(four)
    onTouchImage(five)
    onTouchImage(six)
    onTouchImage(seven)
    onTouchImage(eight)
    onTouchImage(nine)
    onTouchImage(ten)
    onTouchImage(jack)
    onTouchImage(queen)
    onTouchImage(king)
    onTouchImage(ace)
    var resID: Int = two.context.resources
        .getIdentifier("x2$suit", "drawable", two.context.packageName)
    two.setImageResource(resID)
    resID = three.context.resources
        .getIdentifier("x3$suit", "drawable", three.context.packageName)
    three.setImageResource(resID)
    resID = four.context.resources
        .getIdentifier("x4$suit", "drawable", four.context.packageName)
    four.setImageResource(resID)
    resID = five.context.resources
        .getIdentifier("x5$suit", "drawable", five.context.packageName)
    five.setImageResource(resID)

    resID = six.context.resources
        .getIdentifier("x6$suit", "drawable", six.context.packageName)
    six.setImageResource(resID)
    resID = seven.context.resources
        .getIdentifier("x7$suit", "drawable", seven.context.packageName)
    seven.setImageResource(resID)
    resID = eight.context.resources
        .getIdentifier("x8$suit", "drawable", eight.context.packageName)
    eight.setImageResource(resID)
    resID = nine.context.resources
        .getIdentifier("x9$suit", "drawable", nine.context.packageName)
    nine.setImageResource(resID)
    resID = ten.context.resources
        .getIdentifier("x10$suit", "drawable", ten.context.packageName)
    ten.setImageResource(resID)

    resID = jack.context.resources
        .getIdentifier("j$suit", "drawable", jack.context.packageName)
    jack.setImageResource(resID)
    resID = queen.context.resources
        .getIdentifier("q$suit", "drawable", queen.context.packageName)
    queen.setImageResource(resID)
    resID = king.context.resources
        .getIdentifier("k$suit", "drawable", king.context.packageName)
    king.setImageResource(resID)
    resID = ace.context.resources
        .getIdentifier("a$suit", "drawable", ace.context.packageName)
    ace.setImageResource(resID)

    dialog.show()

    two.setOnClickListener {
        dialog.dismiss()
    }
    three.setOnClickListener {

        dialog.dismiss()
    }
    four.setOnClickListener {

        dialog.dismiss()
    }
    five.setOnClickListener {

        dialog.dismiss()
    }
    six.setOnClickListener {
        dialog.dismiss()
    }
    seven.setOnClickListener {

        dialog.dismiss()
    }
    eight.setOnClickListener {

        dialog.dismiss()
    }
    nine.setOnClickListener {

        dialog.dismiss()
    }
    ten.setOnClickListener {

        dialog.dismiss()
    }
    jack.setOnClickListener {

        dialog.dismiss()
    }
    queen.setOnClickListener {

        dialog.dismiss()
    }
    king.setOnClickListener {

        dialog.dismiss()
    }
    ace.setOnClickListener {

        dialog.dismiss()
    }
}

fun chooseSuitDialog(dialog: Dialog) {
    dialog.setContentView(R.layout.choose_suit)
    val peaks: ImageView = dialog.findViewById(R.id.imagePeaks)
    val hearts: ImageView = dialog.findViewById(R.id.imageHearts)
    val diamonds: ImageView = dialog.findViewById(R.id.imageDiamonds)
    val clubs: ImageView = dialog.findViewById(R.id.imageClubs)
    onTouchImage(peaks)
    onTouchImage(hearts)
    onTouchImage(diamonds)
    onTouchImage(clubs)

    dialog.show()

    peaks.setOnClickListener {
        dialog.dismiss()
        chooseValDialog(dialog, "_peaks")
    }
    hearts.setOnClickListener() {
        dialog.dismiss()
        chooseValDialog(dialog, "_hearts")
    }
    clubs.setOnClickListener {
        dialog.dismiss()
        chooseValDialog(dialog, "_clubs")
    }
    diamonds.setOnClickListener() {
        dialog.dismiss()
        chooseValDialog(dialog, "_diamonds")
    }
}