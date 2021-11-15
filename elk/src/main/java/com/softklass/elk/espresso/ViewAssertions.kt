package com.softklass.elk.espresso

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matcher

/**
 *  Extension functions for [ViewMatchers.isDisplayed()] for [ViewAssertion.matches()]
 */
fun Matcher<View>.isDisplayed(): ViewInteraction =
    onView(this).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

fun ViewInteraction.isDisplayed(): ViewInteraction =
    check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

fun Int.isDisplayed(): ViewInteraction =
    onView(withId(this)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

val isDisplayed: Matcher<View> = ViewMatchers.isDisplayed()

/**
 *  Extension functions for [ViewMatchers.isCompletelyDisplayed()] for [ViewAssertion.matches()]
 */
fun Matcher<View>.isCompletelyDisplayed(): ViewInteraction =
    onView(this).check(ViewAssertions.matches(ViewMatchers.isCompletelyDisplayed()))

fun ViewInteraction.isCompletelyDisplayed(): ViewInteraction =
    check(ViewAssertions.matches(ViewMatchers.isCompletelyDisplayed()))

fun Int.isCompletelyDisplayed(): ViewInteraction =
    onView(withId(this)).check(ViewAssertions.matches(ViewMatchers.isCompletelyDisplayed()))

val isCompletelyDisplayed: Matcher<View> = isCompletelyDisplayed()

/**
 *  Extension functions for [ViewMatchers.isEnabled()] for [ViewAssertion.matches()]
 */
fun Matcher<View>.isEnabled(): ViewInteraction =
    onView(this).check(ViewAssertions.matches(ViewMatchers.isEnabled()))

fun ViewInteraction.isEnabled(): ViewInteraction =
    check(ViewAssertions.matches(ViewMatchers.isEnabled()))

fun Int.isEnabled(): ViewInteraction =
    onView(withId(this)).check(ViewAssertions.matches(ViewMatchers.isEnabled()))

val isEnabled: Matcher<View> = isEnabled()

/**
 *  Extension functions for [ViewMatchers.hasFocus()] for [ViewAssertion.matches()]
 */
fun Matcher<View>.hasFocus(): ViewInteraction =
    onView(this).check(ViewAssertions.matches(ViewMatchers.hasFocus()))

fun ViewInteraction.hasFocus(): ViewInteraction =
    check(ViewAssertions.matches(ViewMatchers.hasFocus()))

fun Int.hasFocus(): ViewInteraction =
    onView(withId(this)).check(ViewAssertions.matches(ViewMatchers.hasFocus()))

val hasFocus: Matcher<View> = hasFocus()

/**
 *  Extension functions for [ViewMatchers.isClickable()] for [ViewAssertion.matches()]
 */
fun Matcher<View>.isClickable(): ViewInteraction =
    onView(this).check(ViewAssertions.matches(ViewMatchers.isClickable()))

fun ViewInteraction.isClickable(): ViewInteraction =
    check(ViewAssertions.matches(ViewMatchers.isClickable()))

fun Int.isClickable(): ViewInteraction =
    onView(withId(this)).check(ViewAssertions.matches(ViewMatchers.isClickable()))

val isClickable: Matcher<View> = isClickable()

/**
 *  Extension functions for [ViewMatchers.isChecked()] for [ViewAssertion.matches()]
 */
fun Matcher<View>.isChecked(): ViewInteraction =
    onView(this).check(ViewAssertions.matches(ViewMatchers.isChecked()))

fun ViewInteraction.isChecked(): ViewInteraction =
    check(ViewAssertions.matches(ViewMatchers.isChecked()))

fun Int.isChecked(): ViewInteraction =
    onView(withId(this)).check(ViewAssertions.matches(ViewMatchers.isChecked()))

val isChecked: Matcher<View> = isChecked()

/**
 *  Extension functions for [ViewMatchers.withEffectiveVisibility(Visibility)] for [ViewAssertion.matches()]
 */
fun Matcher<View>.withEffectiveVisibility(visibility: Visibility): ViewInteraction =
    onView(this).check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(visibility)))

fun ViewInteraction.withEffectiveVisibility(visibility: Visibility): ViewInteraction =
    check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(visibility)))

fun withEffectiveVisibility(visibility: Visibility): ViewAssertion =
    ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(visibility))

/**
 *  Extension functions for [ViewMatchers.isSelected()] for [ViewAssertion.matches()]
 */
fun Matcher<View>.isSelected(): ViewInteraction =
    onView(this).check(ViewAssertions.matches(ViewMatchers.isSelected()))

fun ViewInteraction.isSelected(): ViewInteraction =
    check(ViewAssertions.matches(ViewMatchers.isSelected()))

fun Int.isSelected(): ViewInteraction =
    onView(withId(this)).check(ViewAssertions.matches(ViewMatchers.isSelected()))

val isSelected: Matcher<View> = isSelected()

/**
 *  Extension functions for [ViewMatchers.isSelected()] for [ViewAssertion.doesNotExist()]
 */
fun Matcher<View>.doesNotExist(): ViewInteraction =
    onView(this).check(ViewAssertions.doesNotExist())

fun ViewInteraction.doesNotExist(): ViewInteraction =
    check(ViewAssertions.doesNotExist())

fun Int.doesNotExist(): ViewInteraction =
    onView(withId(this)).check(ViewAssertions.doesNotExist())

val doesNotExist: ViewAssertion = ViewAssertions.doesNotExist()
