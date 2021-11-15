package com.android.elk.espresso

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.PositionAssertions
import org.hamcrest.Matcher


/**
 * Extension function for [POSITION ASSERTIONS] - [PositionAssertions.isBottomAlignedWith] for [View]
 */
fun Matcher<View>.isBottomAlignedWith(matcher: Matcher<View>): ViewInteraction =
    Espresso.onView(this).check(PositionAssertions.isBottomAlignedWith(matcher))

fun ViewInteraction.isBottomAlignedWith(matcher: Matcher<View>): ViewInteraction =
    check(PositionAssertions.isBottomAlignedWith(matcher))

/**
 * Extension function for [POSITION ASSERTIONS] - [PositionAssertions.isCompletelyAbove] for [View]
 */
fun Matcher<View>.isCompletelyAbove(matcher: Matcher<View>): ViewInteraction =
    Espresso.onView(this).check(PositionAssertions.isCompletelyAbove(matcher))

fun ViewInteraction.isCompletelyAbove(matcher: Matcher<View>): ViewInteraction =
    check(PositionAssertions.isCompletelyAbove(matcher))

/**
 * Extension function for [POSITION ASSERTIONS] - [PositionAssertions.isCompletelyBelow] for [View]
 */
fun Matcher<View>.isCompletelyBelow(matcher: Matcher<View>): ViewInteraction =
    Espresso.onView(this).check(PositionAssertions.isCompletelyBelow(matcher))

fun ViewInteraction.isCompletelyBelow(matcher: Matcher<View>): ViewInteraction =
    check(PositionAssertions.isCompletelyBelow(matcher))

/**
 * Extension function for [POSITION ASSERTIONS] - [PositionAssertions.isCompletelyLeftOf] for [View]
 */
fun Matcher<View>.isCompletelyLeftOf(matcher: Matcher<View>): ViewInteraction =
    Espresso.onView(this).check(PositionAssertions.isCompletelyLeftOf(matcher))

fun ViewInteraction.isCompletelyLeftOf(matcher: Matcher<View>): ViewInteraction =
    check(PositionAssertions.isCompletelyLeftOf(matcher))

/**
 * Extension function for [POSITION ASSERTIONS] - [PositionAssertions.isCompletelyRightOf] for [View]
 */
fun Matcher<View>.isCompletelyRightOf(matcher: Matcher<View>): ViewInteraction =
    Espresso.onView(this).check(PositionAssertions.isCompletelyRightOf(matcher))

fun ViewInteraction.isCompletelyRightOf(matcher: Matcher<View>): ViewInteraction =
    check(PositionAssertions.isCompletelyRightOf(matcher))

/**
 * Extension function for [POSITION ASSERTIONS] - [PositionAssertions.isPartiallyAbove] for [View]
 */
fun Matcher<View>.isPartiallyAbove(matcher: Matcher<View>): ViewInteraction =
    Espresso.onView(this).check(PositionAssertions.isPartiallyAbove(matcher))

fun ViewInteraction.isPartiallyAbove(matcher: Matcher<View>): ViewInteraction =
    check(PositionAssertions.isPartiallyAbove(matcher))

/**
 * Extension function for [POSITION ASSERTIONS] - [PositionAssertions.isPartiallyBelow] for [View]
 */
fun Matcher<View>.isPartiallyBelow(matcher: Matcher<View>): ViewInteraction =
    Espresso.onView(this).check(PositionAssertions.isPartiallyBelow(matcher))

fun ViewInteraction.isPartiallyBelow(matcher: Matcher<View>): ViewInteraction =
    check(PositionAssertions.isPartiallyBelow(matcher))

/**
 * Extension function for [POSITION ASSERTIONS] - [PositionAssertions.isPartiallyLeftOf] for [View]
 */
fun Matcher<View>.isPartiallyLeftOf(matcher: Matcher<View>): ViewInteraction =
    Espresso.onView(this).check(PositionAssertions.isPartiallyLeftOf(matcher))

fun ViewInteraction.isPartiallyLeftOf(matcher: Matcher<View>): ViewInteraction =
    check(PositionAssertions.isPartiallyLeftOf(matcher))

/**
 * Extension function for [POSITION ASSERTIONS] - [PositionAssertions.isPartiallyRightOf] for [View]
 */
fun Matcher<View>.isPartiallyRightOf(matcher: Matcher<View>): ViewInteraction =
    Espresso.onView(this).check(PositionAssertions.isPartiallyRightOf(matcher))

fun ViewInteraction.isPartiallyRightOf(matcher: Matcher<View>): ViewInteraction =
    check(PositionAssertions.isPartiallyRightOf(matcher))

/**
 * Extension function for [POSITION ASSERTIONS] - [PositionAssertions.isRightAlignedWith] for [View]
 */
fun Matcher<View>.isRightAlignedWith(matcher: Matcher<View>): ViewInteraction =
    Espresso.onView(this).check(PositionAssertions.isRightAlignedWith(matcher))

fun ViewInteraction.isRightAlignedWith(matcher: Matcher<View>): ViewInteraction =
    check(PositionAssertions.isRightAlignedWith(matcher))

/**
 * Extension function for [POSITION ASSERTIONS] - [PositionAssertions.isTopAlignedWith] for [View]
 */
fun Matcher<View>.isTopAlignedWith(matcher: Matcher<View>): ViewInteraction =
    Espresso.onView(this).check(PositionAssertions.isTopAlignedWith(matcher))

fun ViewInteraction.isTopAlignedWith(matcher: Matcher<View>): ViewInteraction =
    check(PositionAssertions.isTopAlignedWith(matcher))
