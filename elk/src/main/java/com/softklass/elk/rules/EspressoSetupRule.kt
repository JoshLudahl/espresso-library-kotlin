package com.android.elk.rules

import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.android.elk.espresso.lib.DataBindingIdlingResource
import com.android.elk.espresso.lib.EspressoIdlingResource
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class EspressoSetupRule(activityScenarioRule: ActivityScenarioRule<*>) : TestWatcher() {
    private val dataBindingIdlingResource = DataBindingIdlingResource(activityScenarioRule)

    override fun starting(description: Description?) {
        Intents.init()
        IdlingRegistry
            .getInstance()
            .register(
                EspressoIdlingResource.countingIdlingResource,
                dataBindingIdlingResource
            )

        super.starting(description)
    }

    override fun finished(description: Description?) {
        Intents.release()
        IdlingRegistry
            .getInstance()
            .unregister(
                EspressoIdlingResource.countingIdlingResource,
                dataBindingIdlingResource
            )

        super.finished(description)
    }
}
