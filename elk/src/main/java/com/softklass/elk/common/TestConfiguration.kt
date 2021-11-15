package com.softklass.elk.common

import android.app.Instrumentation
import android.content.Context
import android.content.res.AssetManager
import android.content.res.Configuration
import android.content.res.Resources
import androidx.annotation.StringRes
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import java.util.*

/**
 *  Application context
 */
val targetContext: Context get() = InstrumentationRegistry.getInstrumentation().targetContext

/**
 *  Instrumentation context
 */
val testContext: Context get() = InstrumentationRegistry.getInstrumentation().context

/**
 *  AssetManager for androidTest environment
 */
val testAssets: AssetManager = testContext.assets

/**
 *  Test runner instrumentation
 */
val instrumentation: Instrumentation get() = InstrumentationRegistry.getInstrumentation()

/**
 *  Returns
 */
fun Context.getConfigurationResources(locale: Locale): Resources {
    val configuration = Configuration(resources.configuration)
    configuration.setLocale(locale)
    return createConfigurationContext(configuration).resources
}

infix fun Resources.nameOf(viewId: Int): String = getResourceName(viewId)

/**
 * Gets a application configuration with forced [Locale.ENGLISH]
 */
fun Context.getEnglishConfiguration() = getConfigurationResources(Locale.ENGLISH)

/**
 * Gets a application configuration with forced [Locale.FRENCH]
 */
fun Context.getFrenchConfiguration() = getConfigurationResources(Locale.FRENCH)

/**
 * Gets a application configuration with forced [Locale.GERMAN]
 */
fun Context.getGermanConfiguration() = getConfigurationResources(Locale.GERMAN)

/**
 * Gets a application configuration with forced [Locale.JAPANESE]
 */
fun Context.getJapaneseConfiguration() = getConfigurationResources(Locale.JAPANESE)

/**
 * Sugar syntax for getting a string value
 */
infix fun Context.stringValue(@StringRes id: Int) = getString(id)

val device: UiDevice = UiDevice.getInstance(instrumentation)