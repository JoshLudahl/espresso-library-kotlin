package com.android.elk.espresso

import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers
import com.softklass.elk.common.stringValue
import com.softklass.elk.common.targetContext
import org.hamcrest.Matcher

/**
 *   Extensions for [USER PROPERTIES]: ViewMatcher.withId(Int)
 */
fun withId(@IdRes id: Int): Matcher<View> = ViewMatchers.withId(id)

fun viewWithId(@IdRes id: Int): ViewInteraction = onView(ViewMatchers.withId(id))

/**
 *   Extensions for [USER PROPERTIES]: ViewMatcher.withText()
 */

fun withText(text: String): Matcher<View> = ViewMatchers.withText(text)

fun withText(@StringRes id: Int): Matcher<View> = ViewMatchers.withText(id)

fun viewWithText(text: String): ViewInteraction = onView(ViewMatchers.withText(text))

fun viewWithText(@StringRes id: Int): ViewInteraction = onView(ViewMatchers.withText(id))

/**
 *   Extensions for [USER PROPERTIES]: ViewMatcher.withTagKey()
 */
fun withTagKey(key: Int): Matcher<View> = ViewMatchers.withTagKey(key)

fun withTagKey(key: Int, matcher: Matcher<Any>): Matcher<View> =
    ViewMatchers.withTagKey(key, matcher)

fun viewWithTagKey(key: Int): ViewInteraction = onView(ViewMatchers.withTagKey(key))

fun viewWithTagKey(key: Int, matcher: Matcher<Any>): ViewInteraction =
    onView(ViewMatchers.withTagKey(key, matcher))

/**
 *   Extensions for [USER PROPERTIES]: ViewMatcher.withTagValue()
 */
fun withTagValue(value: Matcher<Any>): Matcher<View> = ViewMatchers.withTagValue(value)

fun viewWithTagValue(value: Matcher<Any>): ViewInteraction = onView(ViewMatchers.withTagValue(value))

/**
 *   Extensions for [USER PROPERTIES]: ViewMatcher.hasContentDescription()
 */
fun hasContentDescription(): Matcher<View> = ViewMatchers.hasContentDescription()

fun viewHasContentDescription(): ViewInteraction = onView(ViewMatchers.hasContentDescription())

/**
 *   Extensions for [USER PROPERTIES]: ViewMatcher.withContentDescription()
 */
fun withContentDescription(text: String): Matcher<View> = ViewMatchers.withContentDescription(text)

fun withContentDescription(@StringRes id: Int): Matcher<View> =
    ViewMatchers.withContentDescription(id)

fun viewWithContentDescription(text: String): ViewInteraction =
    onView(ViewMatchers.withContentDescription(text))

fun viewWithContentDescription(@StringRes id: Int): ViewInteraction =
    onView(ViewMatchers.withContentDescription(id))

/**
 *   Extensions for [USER PROPERTIES]: ViewMatcher.withHint()
 */
fun withHint(text: String): Matcher<View> = ViewMatchers.withHint(text)

fun withHint(@StringRes id: Int): Matcher<View> = ViewMatchers.withHint(id)

fun withHint(matcher: Matcher<String>): Matcher<View> = ViewMatchers.withHint(matcher)

fun viewWithHint(text: String): ViewInteraction = onView(ViewMatchers.withHint(text))

fun viewWithHint(@StringRes id: Int): ViewInteraction = onView(ViewMatchers.withHint(id))

fun viewWithHint(matcher: Matcher<String>): ViewInteraction = onView(ViewMatchers.withHint(matcher))

/**
 *   Extensions for [USER PROPERTIES]: ViewMatcher.withSpinnerText()
 */
fun withSpinnerText(text: String): Matcher<View> = ViewMatchers.withSpinnerText(text)

fun withSpinnerText(@StringRes id: Int): Matcher<View> =
    ViewMatchers.withSpinnerText(targetContext stringValue id)

fun withSpinnerText(matcher: Matcher<String>): Matcher<View> = ViewMatchers.withSpinnerText(matcher)

fun viewWithSpinnerText(text: String): ViewInteraction = onView(ViewMatchers.withSpinnerText(text))

fun viewWithSpinnerText(@StringRes id: Int): ViewInteraction =
    onView(ViewMatchers.withSpinnerText(targetContext stringValue id))

fun viewWithSpinnerText(matcher: Matcher<String>): ViewInteraction =
    onView(ViewMatchers.withSpinnerText(matcher))

/**
 *   Extensions for [USER PROPERTIES]: ViewMatcher.hasLinks()
 */
val hasLinks: Matcher<View> = ViewMatchers.hasLinks()

val viewHasLinks: ViewInteraction = onView(ViewMatchers.hasLinks())
