package com.softklass.elk

import com.softklass.elk.common.Given
import com.softklass.elk.common.Then
import com.softklass.elk.common.When
import com.softklass.elk.espresso.click
import com.softklass.elk.espresso.isDisplayed
import com.softklass.elk.espresso.not
import com.softklass.elk.espresso.view
import org.junit.Test

class SampleTest {

    @Test
    fun sampleTestFunction() {
        screen<SampleObject> {
            sampleFunction()
        }

        @Given("I am on the main screen")
        @When("I do simpleFunction")
        (operation<SampleObject> {
            sampleFunction()
        })

        @Then("the simpleFunction is displayed")
        (verify<SampleObject> {
            sampleFunction()
        })
        view("some link") perform click
        view("some text1") check isDisplayed
        view("some text2") check isDisplayed.not()
    }
}
