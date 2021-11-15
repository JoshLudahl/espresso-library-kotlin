package com.softklass.elk.espresso

import android.graphics.Rect
import android.util.Log
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ScrollView
import androidx.core.widget.NestedScrollView
import androidx.test.espresso.PerformException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.util.HumanReadables
import org.hamcrest.Matcher
import org.hamcrest.Matchers

/**
 * This helper was created because the typical scrollTo does not work on NestedScrollView
 * So, use this when scrolling a NestedScrollView and scrollTo with the usual ScrollView
 */

class ScrollToAction : ViewAction {

    companion object {
        fun customScrollTo(): ViewAction {
            return ViewActions.actionWithAssertions(ScrollToAction())
        }
    }

    override fun getConstraints(): Matcher<View> {
        return Matchers.allOf(
            ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE),
            ViewMatchers.isDescendantOfA(
                Matchers.anyOf(
                    ViewMatchers.isAssignableFrom(HorizontalScrollView::class.java),
                    ViewMatchers.isAssignableFrom(NestedScrollView::class.java),
                    ViewMatchers.isAssignableFrom(ScrollView::class.java)
                )
            )
        )
    }

    override fun perform(uiController: UiController, view: View) {
        if (ViewMatchers.isDisplayingAtLeast(100).matches(view)) {
            Log.i("Success","View is already displayed. Returning.")
            return
        }
        val rect = Rect()
        view.getDrawingRect(rect)
        if (!view.requestRectangleOnScreen(rect, true /* immediate */)) {
            Log.i("Fail","Scrolling to view was requested, but none of the parents scrolled.")
        }
        uiController.loopMainThreadUntilIdle()
        if (!ViewMatchers.isDisplayingAtLeast(1).matches(view)) {
            throw PerformException.Builder()
                .withActionDescription(this.description)
                .withViewDescription(HumanReadables.describe(view))
                .withCause(
                    RuntimeException(
                        "Scrolling to view was attempted, but the view is not displayed"
                    )
                )
                .build()
        }
    }

    override fun getDescription(): String {
        return "scroll to"
    }
}
