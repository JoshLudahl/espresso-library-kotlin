package com.softklass.elk.espresso

import android.annotation.SuppressLint
import android.util.NoSuchPropertyException
import android.view.View
import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import com.google.android.material.internal.ContextUtils.getActivity
import com.softklass.elk.common.targetContext
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.core.AllOf.allOf
import org.hamcrest.core.IsNot.not

enum class ResourceType {
    RESOURCE_ID, RESOURCE_STRING
}

val Int.resType: ResourceType
    get() = when (
        targetContext
            .resources
            .getResourceTypeName(this)
    ) {
        "id" -> ResourceType.RESOURCE_ID
        "string" -> ResourceType.RESOURCE_STRING
        else -> throw NoSuchPropertyException("No matching property for resource type (resType).")
    }

/**
 * Actions
 */
infix fun ViewAction.on(matcher: Matcher<View>) {
    onView(matcher).perform(this)
}

infix fun ViewAction.on(viewInteraction: ViewInteraction) {
    viewInteraction.perform(this)
}

infix fun ViewAction.onto(matcher: Matcher<View>) {
    onView(matcher).perform(this)
}

infix fun ViewAction.onto(viewInteraction: ViewInteraction) {
    viewInteraction.perform(this)
}

infix fun ViewAction.into(matcher: Matcher<View>) {
    onView(matcher).perform(this)
}

infix fun ViewAction.into(viewInteraction: ViewInteraction) {
    viewInteraction.perform(this)
}

/**
 * Assertions
 */
infix fun Matcher<View>.verify(matcher: Matcher<View>) {
    onView(this).check(ViewAssertions.matches(matcher))
}

infix fun ViewInteraction.verify(matcher: Matcher<View>) {
    this.check(ViewAssertions.matches(matcher))
}

infix fun Matcher<View>.verifyThat(matcher: Matcher<View>) {
    onView(this).check(ViewAssertions.matches(matcher))
}

infix fun ViewInteraction.verifyThat(matcher: Matcher<View>) {
    this.check(ViewAssertions.matches(matcher))
}

infix fun Matcher<View>.confirm(matcher: Matcher<View>) {
    onView(this).check(ViewAssertions.matches(matcher))
}

infix fun ViewInteraction.confirm(matcher: Matcher<View>) {
    this.check(ViewAssertions.matches(matcher))
}

infix fun Matcher<View>.confirmThat(matcher: Matcher<View>) {
    onView(this).check(ViewAssertions.matches(matcher))
}

infix fun ViewInteraction.confirmThat(matcher: Matcher<View>) {
    this.check(ViewAssertions.matches(matcher))
}

/**
 * Extension for reversing the matcher.
 * Example, `isDisplayed().not()` changes `isDisplayed()` to `not displayed`, etc.
 */
fun Matcher<View>.not(): Matcher<View> = not(this)

/**
 * Checks if many views are hidden
 *
 * @param viewIds
 */
fun checkViewsAreHidden(@IdRes vararg viewIds: Int) {
    viewIds.forEach { view ->
        view(view) verify isDisplayed.not()
    }
}

/**
 * Checks if a list of Matchers of is in the same View, great for allOf(...)
 *
 * @param viewIds
 * @return ViewInteraction
 */
fun bulkIsMatcherIsDisplayed(vararg viewIds: Matcher<View>): ViewInteraction =
    onView(Matchers.allOf(*viewIds))
        .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

/**
 * Takes in any type that is supported:
 * - @StringRes, @IdRes, String, or Matcher<View>
 * And verifies if the view is displayed.
 * @param views
 */
fun <T> viewsAreDisplayed(vararg views: T) {
    views.forEach { view ->
        view(view) verify isDisplayed
    }
}

/**
 * View matcher - matches a view of either string or id resource.
 *
 * @param element - id resource
 *
 * @return Matcher<View>
 */
fun <T> view(element: T): Matcher<View> = when (element) {
    is Int -> when (element.resType) {
        ResourceType.RESOURCE_ID -> withId(element)
        ResourceType.RESOURCE_STRING -> withText(element)
    }
    is String -> withText(element)
    else -> throw NoSuchElementException("No matching type.")
}

/**
 * View Matcher - matches a view with a class
 *
 * @param clazz
 * @return Matcher<View>
 */
fun view(clazz: Class<out View>): Matcher<View> = ViewMatchers.isAssignableFrom(clazz)

/**
 * Views Matcher - matches several compound views, shorthand for allOf(), but takes Matchers
 * @sample view(view(R.id.some_resource), view("A String"), withId(R.id.another_id))
 * @param matchers takes a list of matchers
 * @return Matcher<View> object
 */
fun view(vararg matchers: Matcher<View>): Matcher<View> = allOf(*matchers)

/**
 * Checks that a given toast is displayed
 * Takes either a String resource or a String literal as a parameter
 *
 * This does not currently work on API 30+
 *
 * @param message of generic type
 */
@SuppressLint("RestrictedApi")
fun <T> toastMatcher(message: T) {
    val context = InstrumentationRegistry.getInstrumentation().context
    onView(view(message))
        .inRoot(
            withDecorView(
                not(
                    Matchers.`is`(
                        getActivity(context)
                            ?.window
                            ?.decorView
                    )
                )
            )
        )
        .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
}
