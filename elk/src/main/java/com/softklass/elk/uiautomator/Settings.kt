package com.softklass.elk.uiautomator

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import androidx.test.uiautomator.v18.BuildConfig
import com.softklass.elk.common.device

fun toggleAirplaneMode(
    context: Context,
    enabled: Boolean = false
) {
    val airplaneModeStateSetting = Settings.Global.AIRPLANE_MODE_ON

    // if the current mode doesn't match the desired mode state, toggle the mode
    if (isSettingEnabled(context, airplaneModeStateSetting) != enabled) {

        // Start the settings intent directly into the airplane mode setting screen
        startSettingIntent(context, Settings.ACTION_AIRPLANE_MODE_SETTINGS)

        // Samsung and other devices are different
        val airplaneModeText = when (Build.BRAND) {
            "samsung" -> if (isSettingEnabled(context, airplaneModeStateSetting)) "On" else "Off"
            else -> "Airplane mode"

        }.let {
            device.findObject(By.text(it))
        }

        // With the target text, wait for it to appear on the screen, then click it
        with(airplaneModeText) {
            device.wait(Until.findObject(By.text(this.text)), 5000L)
            click()
        }

        // This could be different for devices. A function should be added for devices that have
        // additional dialogs or other screens. Most don't have other screens or dialogs.

        // Select the device back button once should return to the application
        device.pressBack()
    }
}

/**\
 * Generic start setting intent that takes an intent as a string.
 * @param Settings intent
 */
private fun startSettingIntent(context: Context, setting: String) {
    val intent = Intent(setting).apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    }
    context.startActivity(intent)
}

/**
 * Generic settings function  to see if a system setting is enabled.
 */
private fun isSettingEnabled(context: Context, setting: String): Boolean {
    return Settings.System.getInt(context.contentResolver, setting, 0) != 0
}

private fun grantPermissions(packageName: String = BuildConfig.APPLICATION_ID, vararg permissions: String) {
    permissions.forEach { permission ->
        when {
            Build.VERSION.SDK_INT > 27 -> grantLocationPermissions(packageName)
            else -> device.executeShellCommand("pm grant $packageName $permission")
        }
    }
}

fun grantLocationPermissions(packageName: String = BuildConfig.APPLICATION_ID) {
    grantPermissions(
        packageName = packageName,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION
    )
}
