package com.softklass.elk.espresso

import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers

fun atPosition(position: Int, itemMatcher: Matcher<View?>): Matcher<View?>? =
    object : BoundedMatcher<View?, RecyclerView>(RecyclerView::class.java) {
        override fun describeTo(description: Description) {
            description.appendText("has item at position $position: ")
            itemMatcher.describeTo(description)
        }

        override fun matchesSafely(view: RecyclerView): Boolean {
            val viewHolder =
                view.findViewHolderForAdapterPosition(position)
                    ?: return false
            return itemMatcher.matches(viewHolder.itemView)
        }
    }

/**
 * Perform a provided ViewAction on the index of a child element of a RecyclerView
 *
 * @param action
 * @param childId
 * @return ViewAction object
 */
fun actionOnChild(action: ViewAction, childId: Int): ViewAction {
    return object : ViewAction {
        override fun getConstraints(): Matcher<View> {
            return Matchers.allOf(
                ViewMatchers.isDisplayed(),
                ViewMatchers.isAssignableFrom(View::class.java)
            )
        }

        override fun getDescription(): String {
            return "Performing $action on child element with $childId"
        }

        override fun perform(uiController: UiController?, view: View?) {
            view?.let {
                val child: View = it.findViewById(childId)
                action.perform(uiController, child)
            }
        }
    }
}

fun <VH : RecyclerView.ViewHolder> Matcher<View>.clickOnPosition(position: Int) {
    Espresso.onView(this)
        .perform(RecyclerViewActions.actionOnItemAtPosition<VH>(
            position,
            ViewActions.click()
        ))
}

fun <VH : RecyclerView.ViewHolder> Matcher<View>.scrollToPosition(position: Int) {
    Espresso.onView(this).perform(RecyclerViewActions.scrollToPosition<VH>(position))
}

fun <VH: RecyclerView.ViewHolder> Matcher<View>.typeTextAtPosition(position: Int, text: String) {
    Espresso.onView(this).perform(
        RecyclerViewActions.actionOnItemAtPosition<VH>(
            position,
            ViewActions.typeText(text)
        ).also {
            Espresso.closeSoftKeyboard()
        }
    )
}

fun getRecyclerViewCount(activityRule: ActivityScenarioRule<*>, @IdRes id: Int): Int {
    var count = 0
    activityRule.scenario.onActivity {
        count = it.findViewById<RecyclerView>(id).adapter!!.itemCount
    }
    return count
}

fun getRecyclerViewChildCount(matcher: Int): Int {
    val count = intArrayOf(0)
    Espresso.onView(ViewMatchers.withId(matcher)).perform(
        object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return ViewMatchers.isAssignableFrom(RecyclerView::class.java)
            }

            override fun getDescription(): String {
                return "getting child count"
            }

            override fun perform(uiController: UiController, view: View) {
                val rv = view as RecyclerView
                count[0] = rv.childCount
            }
        }
    )
    return count[0]
}

fun recyclerViewSafeSizeMatcher(rvSize: Int): Matcher<View> =
    object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
        override fun describeTo(description: Description?) {
            description?.appendText("RecyclerView size didn't matcher expected size $rvSize")
        }

        override fun matchesSafely(item: RecyclerView?): Boolean {
            return rvSize == item?.adapter?.itemCount
        }
    }
