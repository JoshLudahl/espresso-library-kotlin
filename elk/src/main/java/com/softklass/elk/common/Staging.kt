package com.softklass.elk.common

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import com.softklass.elk.espresso.verify
import com.softklass.elk.espresso.view
import com.google.android.material.bottomsheet.BottomSheetBehavior
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

/**
 * Generic function to check for if a set of items are checked, selected, etc. (customizeable)
 *
 * It takes a positive value (true) enum and a list of the enums available.  It will then remove the positive from the list
 * and check that all others in the list are of negative value (false)
 *
 * @param enum takes an enum of type K which you want to check for the positive value
 * @param enumMap takes a mutable map of enum of the type T
 * @param matcher takes in a [ViewAssertion] type
 */
inline fun <reified K: Enum<K> , reified T: Enum<T>> onlyOneIsSelected(enum: K, enumMap: MutableMap<Enum<T>, Int>, matcher: Matcher<View>) {
    view(enumMap[enumValues<T>()[enum.ordinal]] as Int) verify matcher
    enumMap.remove(enum as Enum<*>)

    enumMap.forEach { value ->
        onView(view(value.value)).check(matches(not(matcher)))
        // check value or other assertion
    }
}

/**
 * Intents stubbing
 */
//intending(not(isInternal())).respondWith(Instrumentation.ActivityResult(Activity.RESULT_OK, null))

/**
 *  Custom BottomSheet Behavior
 */

object DesignViewActions {
    /** Overwrites the constraints of the specified [ViewAction].  */
    fun withCustomConstraints(
        action: ViewAction, constraints: Matcher<View>
    ): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return constraints
            }

            override fun getDescription(): String {
                return action.description
            }

            override fun perform(uiController: UiController?, view: View?) {
                action.perform(uiController, view)
            }
        }
    }

    fun setVisibility(visibility: Int): ViewAction? {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return ViewMatchers.isEnabled()
            }

            override fun getDescription(): String {
                return "Set view visibility"
            }

            override fun perform(uiController: UiController, view: View) {
                uiController.loopMainThreadUntilIdle()
                view.visibility = visibility
                uiController.loopMainThreadForAtLeast(250)
            }
        }
    }
}

 fun setDrawerFullyExpanded(): ViewAction? {
    return object : ViewAction {

        override fun getConstraints(): Matcher<View> {
            return ViewMatchers.isDisplayed()
        }

        override fun getDescription(): String {
            return "set full height"
        }

        override fun perform(uiController: UiController, view: View) {
            val behavior: BottomSheetBehavior<*> = BottomSheetBehavior.from(view)
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
            while(behavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                uiController.loopMainThreadForAtLeast(10)
            }
        }
    }
}

private fun collapseDrawer(): ViewAction {
    return object : ViewAction {

        override fun getConstraints(): Matcher<View> {
            return ViewMatchers.isDisplayed()
        }

        override fun getDescription(): String {
            return "set tall peek height"
        }

        override fun perform(uiController: UiController, view: View) {
            val behavior: BottomSheetBehavior<*> = BottomSheetBehavior.from(view)
            behavior.halfExpandedRatio
        }
    }
}

private fun waitForIdler() {
    InstrumentationRegistry.getInstrumentation().waitForIdleSync()
}

/**
 * custom ViewAction Template
 */

fun customViewActionTemplate(): ViewAction {
    return object: ViewAction {
        override fun getConstraints(): Matcher<View> {
            TODO("Not yet implemented")
        }

        override fun getDescription(): String {
            TODO("Not yet implemented")
        }

        override fun perform(uiController: UiController?, view: View?) {
            TODO("Not yet implemented")
        }
    }
}

/**
 * Custom ViewAssertion template
 */
fun customViewAssertion(): ViewAssertion {
    return object : ViewAssertion {
        override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
            TODO("Not yet implemented")

//            if (noViewFoundException != null) {
//                throw noViewFoundException
//            }
//
//            if (view !is [desired view to compare]) {
//                throw IllegalStateException("The asserted view is not RecyclerView")
//            }
//
//            ViewMatchers.assertThat(Make assumption here, or not.  )
//        }

            //}
        }

        /**
         * Custom Matcher template
         */
        fun customViewMatcher(): Matcher<View> {
            return object : TypeSafeMatcher<View>() {
                override fun describeTo(description: Description?) {
                    TODO("Not yet implemented")
                }

                override fun matchesSafely(item: View?): Boolean {
                    TODO("Not yet implemented")
                }
            }
        }

        /**
         * Example of a BoundedMatcher matching the Bounds of the View and a TextView
         */
        fun customBoundedMatcher(): Matcher<View> {
            return object : BoundedMatcher<View, TextView>(TextView::class.java) {
                override fun describeTo(description: Description?) {
                    TODO("Not yet implemented")
                }

                override fun matchesSafely(item: TextView?): Boolean {
                    TODO("Not yet implemented")
                }
            }
        }
    }
}

fun disconnectAndReconnect(methods: () -> Unit) {
    // Disconnect
    try {
        methods()
    } finally {
        //Reconnnect
    }
}

// Use as
fun sadf() {
    disconnectAndReconnect {
        println("Print1")
        println("Print2")
        // Etc. Use this more for common steps
    }
}
