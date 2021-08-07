package com.example.pokertrainer

import kotlin.random.Random

fun generateCard(): Card = Card(
    when (Random.nextInt(1, 5)) {
        1 -> 'c'
        2 -> 'p'
        3 -> 'h'
        else -> 'd'
    }, Random.nextInt(2, 15)
)



fun isFlush(
    first: Card,
    second: Card,
    third: Card,
    fourth: Card,
    fifth: Card,
): Boolean {
    return first.getSuit() == second.getSuit() && third.getSuit() == fourth.getSuit()
            && first.getSuit() == fifth.getSuit() && first.getSuit() == third.getSuit()
}

fun isFour(
    first: Card,
    second: Card,
    third: Card,
    fourth: Card,
    fifth: Card,
): Boolean {
    return first.getVal() == second.getVal() && third.getVal() == fourth.getVal() && first.getVal() == third.getVal()
            || first.getVal() == second.getVal() && third.getVal() == fifth.getVal() && first.getVal() == third.getVal()
            || first.getVal() == second.getVal() && fourth.getVal() == fifth.getVal() && first.getVal() == fourth.getVal()
            || first.getVal() == third.getVal() && fourth.getVal() == fifth.getVal() && first.getVal() == fourth.getVal()
            || second.getVal() == third.getVal() && fourth.getVal() == fifth.getVal() && first.getVal() == fourth.getVal()
}

fun isSet(
    first: Card,
    second: Card,
    third: Card,
    fourth: Card,
    fifth: Card,
): Boolean {
    return first.getVal() == second.getVal() && first.getVal() == third.getVal()
            || first.getVal() == second.getVal() && first.getVal() == fourth.getVal()
            || first.getVal() == second.getVal() && first.getVal() == fifth.getVal()
            || second.getVal() == third.getVal() && second.getVal() == fourth.getVal()
            || second.getVal() == third.getVal() && second.getVal() == fifth.getVal()
            || third.getVal() == fourth.getVal() && third.getVal() == fifth.getVal()
}

fun isPair(
    first: Card,
    second: Card,
    third: Card,
    fourth: Card,
    fifth: Card,
): Boolean {
    return first.getVal() == second.getVal() || first.getVal() == third.getVal()
            || first.getVal() == fourth.getVal() || first.getVal() == fifth.getVal()
            || second.getVal() == third.getVal() || second.getVal() == fourth.getVal()
            || second.getVal() == fifth.getVal() || third.getVal() == fourth.getVal()
            || third.getVal() == fifth.getVal() || fourth.getVal() == fifth.getVal()

}
/*fun isStraight(
    first: Card,
    second: Card,
    third: Card,
    fourth: Card,
    fifth: Card,
): Boolean {}

fun isTwoPairs (
    first: Card,
    second: Card,
    third: Card,
    fourth: Card,
    fifth: Card,
): Boolean {}
fun isFlushStraight(
    first: Card,
    second: Card,
    third: Card,
    fourth: Card,
    fifth: Card,
): Boolean {}*/