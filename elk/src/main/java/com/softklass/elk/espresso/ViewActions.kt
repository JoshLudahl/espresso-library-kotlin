package com.softklass.elk.espresso

import android.net.Uri
import android.util.NoSuchPropertyException
import android.view.View
import androidx.annotation.StringRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import com.softklass.elk.common.stringValue
import com.softklass.elk.common.targetContext
import org.hamcrest.Matcher

/**
 *   The following extension functions will generally apply to the .perform(action) actions
 *   Will have two options plus a value to use for syntax improvement.
 *
 *   Matcher<View>.* will be used in withId(id)
 *
 *   ViewInteraction.* will be used as onView(withId())
 *
 *   Syntax values can be used with infix functions for easier readability
 */

/**
 *   Extensions for [CLICK/PRESS]: ViewAction.click() on
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.click(): ViewInteraction = onView(this).perform(ViewActions.click())

fun ViewInteraction.click(): ViewInteraction = perform(ViewActions.click())

val click: ViewAction get() = ViewActions.click()

/**
 *   Extensions for [CLICK/PRESS]: ViewAction.doubleClick() on
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.doubleClick(): ViewInteraction =
    onView(this).perform(ViewActions.doubleClick())

fun ViewInteraction.doubleClick(): ViewInteraction = perform(ViewActions.doubleClick())

val doubleClick: ViewAction get() = ViewActions.doubleClick()

/**
 *   Extensions for [CLICK/PRESS]: ViewAction.longClick() on
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.longClick(): ViewInteraction =
    onView(this).perform(ViewActions.longClick())

fun ViewInteraction.longClick(): ViewInteraction = perform(ViewActions.longClick())

val longClick: ViewAction get() = ViewActions.longClick()

/**
 *   Extensions for [CLICK/PRESS]: ViewAction.pressBack() on
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.pressBack(): ViewInteraction =
    onView(this).perform(ViewActions.pressBack())

fun ViewInteraction.pressback(): ViewInteraction = perform(ViewActions.pressBack())

val pressBack: ViewAction get() = ViewActions.pressBack()

fun <T> T.pressB() : ViewInteraction =
    when (this) {
        is ViewInteraction -> this
        is Matcher<*> -> onView(this as? Matcher<View>)
        else -> throw NoSuchPropertyException("Unable to determine the type of property.")
    }.perform(ViewActions.pressBack())

/**
 *   Extensions for [CLICK/PRESS]: ViewAction.pressBackUnconditionally() on
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.pressBackUnconditionally(): ViewInteraction =
    onView(this).perform(ViewActions.pressBackUnconditionally())

fun ViewInteraction.pressBackUnconditionally(): ViewInteraction =
    perform(ViewActions.pressBackUnconditionally())

val pressBackUnconditionally: ViewAction get() = ViewActions.pressBackUnconditionally()

/**
 *   Extensions for [CLICK/PRESS]: ViewAction.pressImeActionButton() on
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.pressImeActionButton(): ViewInteraction =
    onView(this).perform(ViewActions.pressImeActionButton())

fun ViewInteraction.pressImeActionButton(): ViewInteraction =
    perform(ViewActions.pressImeActionButton())

val pressImeActionButton: ViewAction get() = ViewActions.pressImeActionButton()

/**
 *   Extensions for [CLICK/PRESS]: ViewAction.pressKey([int/EspressoKey) on
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.pressKey(key: Int): ViewInteraction =
    onView(this).perform(ViewActions.pressKey(key))

fun ViewInteraction.pressKey(key: Int): ViewInteraction = perform(ViewActions.pressKey(key))

fun pressKey(key: Int): ViewAction = ViewActions.pressKey(key)

/**
 *   Extensions for [CLICK/PRESS]: ViewAction.pressMenuKey() on
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.pressMenuKey(): ViewInteraction =
    onView(this).perform(ViewActions.pressMenuKey())

fun ViewInteraction.pressMenuKey(): ViewInteraction = perform(ViewActions.pressMenuKey())

val pressMenuKey: ViewAction get() = ViewActions.pressMenuKey()

/**
 *   Extensions for [CLICK/PRESS]: ViewAction.closeSoftKeyboard() on
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.closeSoftKeyboard(): ViewInteraction =
    onView(this).perform(ViewActions.closeSoftKeyboard())

fun ViewInteraction.closeSoftKeyboard(): ViewInteraction = perform(ViewActions.closeSoftKeyboard())

val closeSoftKeyboard: ViewAction get() = ViewActions.closeSoftKeyboard()

/**
 *   Extensions for [CLICK/PRESS]: ViewAction.openLink() on
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.openLink(text: Matcher<String>, uri: Matcher<Uri>): ViewInteraction =
    onView(this).perform(ViewActions.openLink(text, uri))

fun ViewInteraction.openLink(text: Matcher<String>, uri: Matcher<Uri>): ViewInteraction =
    perform(ViewActions.openLink(text, uri))

fun openLink(text: Matcher<String>, uri: Matcher<Uri>): ViewAction = ViewActions.openLink(text, uri)

/**
 *   Extensions for [CLICK/PRESS]: ViewAction.openLinkWithText() on
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.openLinkWithText(uri: String): ViewInteraction =
    onView(this).perform(ViewActions.openLinkWithText(uri))

fun Matcher<View>.openLinkWithText(@StringRes id: Int): ViewInteraction =
    onView(this)
        .perform(ViewActions.openLinkWithText(targetContext stringValue id))

fun Matcher<View>.openLinkWithText(uri: Matcher<String>): ViewInteraction =
    onView(this).perform(ViewActions.openLinkWithText(uri))

fun ViewInteraction.openLinkWithText(uri: String): ViewInteraction =
    perform(ViewActions.openLinkWithText(uri))

fun ViewInteraction.openLinkWithText(@StringRes id: Int): ViewInteraction =
    perform(ViewActions.openLinkWithText(targetContext stringValue id))

fun ViewInteraction.openLinkWithText(uri: Matcher<String>): ViewInteraction =
    perform(ViewActions.openLinkWithText(uri))

fun openLinkWithText(uri: String): ViewAction = ViewActions.openLinkWithText(uri)

fun openLinkWithText(@StringRes id: Int): ViewAction =
    ViewActions.openLinkWithText(targetContext stringValue id)

fun openLinkWithText(uri: Matcher<String>): ViewAction = ViewActions.openLinkWithText(uri)

/**
 *   Extensions for [CLICK/PRESS]: ViewAction.openLinkWithUri() for
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.openLinkWithUri(uri: String): ViewInteraction =
    onView(this).perform(ViewActions.openLinkWithUri(uri))

fun Matcher<View>.openLinkWithUri(@StringRes id: Int): ViewInteraction =
    onView(this)
        .perform(ViewActions.openLinkWithUri(targetContext stringValue id))

fun Matcher<View>.openLinkWithUri(uri: Matcher<Uri>): ViewInteraction =
    onView(this).perform(ViewActions.openLinkWithUri(uri))

fun ViewInteraction.openLinkWithUri(uri: String): ViewInteraction =
    perform(ViewActions.openLinkWithUri(uri))

fun ViewInteraction.openLinkWithUri(@StringRes id: Int): ViewInteraction =
    perform(ViewActions.openLinkWithUri(targetContext stringValue id))

fun ViewInteraction.openLinkWithUri(uri: Matcher<Uri>): ViewInteraction =
    perform(ViewActions.openLinkWithUri(uri))

fun openLinkWithUri(uri: String): ViewAction = ViewActions.openLinkWithUri(uri)

fun openLinkWithUri(@StringRes id: Int): ViewAction =
    ViewActions.openLinkWithUri(targetContext stringValue id)

fun openLinkWithUri(uri: Matcher<Uri>): ViewAction = ViewActions.openLinkWithUri(uri)

/**
 *   Extensions for [GESTURES]: ViewAction.scrollTo() for
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.scrollTo(): ViewInteraction =
    onView(this).perform(ViewActions.scrollTo())

fun ViewInteraction.scrollTo(): ViewInteraction = perform(ViewActions.scrollTo())

val scrollTo: ViewAction get() = ViewActions.scrollTo()

/**
 *   Extensions for [GESTURES]: ViewAction.swipeLeft() for
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.swipeLeft(): ViewInteraction =
    onView(this).perform(ViewActions.swipeLeft())

fun ViewInteraction.swipeLeft(): ViewInteraction = perform(ViewActions.swipeLeft())

val swipeLeft: ViewAction get() = ViewActions.swipeLeft()

/**
 *   Extensions for [GESTURES]: ViewAction.swipeRight() for
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.swipeRight(): ViewInteraction =
    onView(this).perform(ViewActions.swipeRight())

fun ViewInteraction.swipeRight(): ViewInteraction = perform(ViewActions.swipeRight())

val swipeRight: ViewAction get() = ViewActions.swipeRight()

/**
 *   Extensions for [GESTURES]: ViewAction.swipeUp() for
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.swipeUp(): ViewInteraction =
    onView(this).perform(ViewActions.swipeUp())

fun ViewInteraction.swipeUp(): ViewInteraction = perform(ViewActions.swipeUp())

val swipeUp: ViewAction get() = ViewActions.swipeUp()

/**
 *   Extensions for [GESTURES]: ViewAction.swipeDown() for
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.swipeDown(): ViewInteraction =
    onView(this).perform(ViewActions.swipeDown())

fun ViewInteraction.swipeDown(): ViewInteraction = perform(ViewActions.swipeDown())

val swipeDown: ViewAction get() = ViewActions.swipeDown()

/**
 *   Extensions for [TEXT]: ViewAction.clearText() for
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.clearText(): ViewInteraction =
    onView(this).perform(ViewActions.clearText())

fun ViewInteraction.clearText(): ViewInteraction = perform(ViewActions.clearText())

val clearText: ViewAction get() = ViewActions.clearText()

/**
 *   Extensions for [TEXT]: ViewAction.typeText(String) for
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.typeText(text: String): ViewInteraction =
    onView(this).perform(ViewActions.typeText(text))

fun Matcher<View>.typeText(@StringRes id: Int): ViewInteraction =
    onView(this)
        .perform(ViewActions.typeText(targetContext stringValue id))

fun ViewInteraction.typeText(text: String): ViewInteraction = perform(ViewActions.typeText(text))

fun ViewInteraction.typeText(@StringRes id: Int): ViewInteraction =
    perform(ViewActions.typeText(targetContext stringValue id))

fun typeText(text: String): ViewAction = ViewActions.typeText(text)

fun typeText(@StringRes id: Int): ViewAction =
    ViewActions.typeText(targetContext stringValue id)

/**
 *   Extensions for [TEXT]: ViewAction.typeTextIntoFocusedView(String) for
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.typeTextIntoFocusedView(text: String): ViewInteraction =
    onView(this).perform(ViewActions.typeTextIntoFocusedView(text))

fun Matcher<View>.typeTextIntoFocusedView(@StringRes id: Int): ViewInteraction =
    onView(this)
        .perform(ViewActions.typeTextIntoFocusedView(targetContext stringValue id))

fun ViewInteraction.typeTextIntoFocusedView(text: String): ViewInteraction =
    perform(ViewActions.typeTextIntoFocusedView(text))

fun ViewInteraction.typeTextIntoFocusedView(@StringRes id: Int): ViewInteraction =
    perform(ViewActions.typeTextIntoFocusedView(targetContext stringValue id))

fun typeTextIntoFocusedView(text: String): ViewAction = ViewActions.typeTextIntoFocusedView(text)

fun typeTextIntoFocusedView(@StringRes id: Int): ViewAction =
    ViewActions.typeTextIntoFocusedView(targetContext stringValue id)

/**
 *   Extensions for [TEXT]: ViewAction.replaceText(String) for
 *   current [Matcher] or [ViewInteraction] object
 */
fun Matcher<View>.replaceText(text: String): ViewInteraction =
    onView(this).perform(ViewActions.replaceText(text))

fun Matcher<View>.replaceText(@StringRes id: Int): ViewInteraction =
    onView(this)
        .perform(ViewActions.replaceText(targetContext stringValue id))

fun ViewInteraction.replaceText(text: String): ViewInteraction =
    perform(ViewActions.replaceText(text))

fun ViewInteraction.replaceText(@StringRes id: Int): ViewInteraction =
    perform(ViewActions.replaceText(targetContext stringValue id))

fun replaceText(text: String): ViewAction = ViewActions.replaceText(text)

fun replaceText(@StringRes id: Int): ViewAction =
    ViewActions.replaceText(targetContext stringValue id)
