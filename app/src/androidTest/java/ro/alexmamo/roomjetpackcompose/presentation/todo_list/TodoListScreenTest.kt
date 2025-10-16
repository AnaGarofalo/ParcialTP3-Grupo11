package ro.alexmamo.roomjetpackcompose.presentation.todo_list

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.core.app.ApplicationProvider
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.presentation.MainActivity
import ro.alexmamo.roomjetpackcompose.utils.getTodoTest

@HiltAndroidTest
class TodoListScreenTest {
    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    val context = ApplicationProvider.getApplicationContext<Context>()
    private val todoTest = getTodoTest(context)

    @Test
    fun testTodoClickAndNavigationToTodoDetailsScreenAndBackToTodoListScreen() {
        composeTestRule.apply {
            onNodeWithContentDescription(getString(R.string.open_insert_todo_dialog))
                .performClick()
            onNodeWithText(getString(R.string.todo_name))
                .performTextInput(todoTest.name)
            onNodeWithText(getString(R.string.todo_description))
                .performTextInput(todoTest.description)
            onNodeWithText(getString(R.string.insert_button))
                .performClick()
            onNodeWithText(todoTest.name)
                .performClick()
            onNodeWithText(getString(R.string.todo_details_screen_name))
                .assertIsDisplayed()
            onNodeWithText(todoTest.name)
                .assertIsDisplayed()
            onNodeWithText("by ${todoTest.description}")
                .assertIsDisplayed()
            onNodeWithContentDescription(getString(R.string.navigate_back))
                .performClick()
            onNodeWithText(getString(R.string.todo_list_screen_name))
                .assertIsDisplayed()
        }
    }

    private fun getString(@StringRes resId: Int) = composeTestRule.activity.getString(resId)
}