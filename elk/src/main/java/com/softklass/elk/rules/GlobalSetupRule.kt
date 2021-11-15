package com.softklass.elk.rules

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class GlobalSetupRule : TestRule {

    override fun apply(base: Statement, description: Description): Statement? {
        logInfo("Before test", description)
        return try {
            object : Statement() {
                @Throws(Throwable::class)
                override fun evaluate() {
                    base.evaluate()
                }
            }
        } finally {
            logInfo("After test", description)
        }
    }

    private fun logInfo(msg: String, description: Description) {
        //Log the message
    }
}
