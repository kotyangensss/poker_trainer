package com.example.pokertrainer

class Card(_suit: Char, _value: Int) {
    private val suit: Char = _suit
    private val value: Int = _value

    fun getPic(): String {
        var name = ""
        when (value) {
            2 -> name += "x2_"
            3 -> name += "x3_"
            4 -> name += "x4_"
            5 -> name += "x5_"
            6 -> name += "x6_"
            7 -> name += "x7_"
            8 -> name += "x8_"
            9 -> name += "x9_"
            10 -> name += "x10_"
            11 -> name += "j_"
            12 -> name += "q_"
            13 -> name += "k_"
            14 -> name += "a_"
        }
        when (suit) {
            'c' -> name += "clubs"
            'd' -> name += "diamonds"
            'h' -> name += "hearts"
            'p' -> name += "peaks"
        }
        return name
    }

    fun getVal() = value

    fun getSuit() = suit

    override fun equals(other: Any?): Boolean {
        return if (other is Card){
            this.getVal()==other.getVal()
        }else{
            false
        }
    }

}