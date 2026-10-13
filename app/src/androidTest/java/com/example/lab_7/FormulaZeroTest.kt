package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    // walkthrough test
    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

    // participation exercise test
    @Test
    fun navigate_to_drivers_add_clear_and_return_home() {
        // go from Home to Drivers screen
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()
        composeTestRule
            .onNodeWithTag("driversTitle")
            .assertExists()

        // add a driver and verify it's displayed
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Lando Norris")
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()
        composeTestRule
            .onNodeWithText("Lando Norris")
            .assertExists()

        // clear drivers and verify the list is empty
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()
        composeTestRule
            .onNodeWithText("Lando Norris")
            .assertDoesNotExist()

        // back button returns to Home
        composeTestRule
            .onNodeWithTag("driversBackButton")
            .performClick()
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}