package com.softklass.elk

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import org.hamcrest.Matcher

// Generic Screen
inline fun <reified T: Any> screen(init: T.() -> Unit): T? =
    T::class.java.newInstance().apply { init() }

// Generic Action
inline fun <reified T: Any> operation(init: T.() -> Unit): T? =
    T::class.java.newInstance().apply { init() }

// Generic Confirm
inline fun <reified T: Any> verify(init: T.() -> Unit): T? =
    T::class.java.newInstance().apply { init() }

// Espresso generic centric
inline fun <reified T: Any> perform(init: T.() -> Unit): T? =
    T::class.java.newInstance().apply { init() }
inline fun <reified T: Any> check(init: T.() -> Unit): T? =
    T::class.java.newInstance().apply { init() }

/**
 * Generic check with infix. Use as ```view(resource) check isDisplayed```
 */
infix fun Matcher<View>.check(assertion: Matcher<View>): ViewInteraction =
    onView(this).check(ViewAssertions.matches(assertion))

/**
 * Generic perform with infix. Use as ```view(resource) perform click```
 */
infix fun Matcher<View>.perform(action: ViewAction): ViewInteraction =
    onView(this).perform(action)

class SampleObject {
    fun sampleFunction() {
        /* No Op */
    }
}
