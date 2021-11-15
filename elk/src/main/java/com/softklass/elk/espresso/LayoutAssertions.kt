package com.android.elk.espresso

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.LayoutMatchers
import org.hamcrest.Matcher

/**
 *   Extensions for [USER PROPERTIES]: LayoutMatchers.hasEllipsizedText()
 */
fun hasEllipsizedText(): Matcher<View> = LayoutMatchers.hasEllipsizedText()

fun viewHasEllipsizedText(): ViewInteraction = Espresso.onView(LayoutMatchers.hasEllipsizedText())

/**
 *   Extensions for [USER PROPERTIES]: LayoutMatchers.hasMultilineTest()
 */
fun hasMultilineText(): Matcher<View> = LayoutMatchers.hasMultilineText()

fun viewHasMultilineText(): ViewInteraction = Espresso.onView(LayoutMatchers.hasMultilineText())
