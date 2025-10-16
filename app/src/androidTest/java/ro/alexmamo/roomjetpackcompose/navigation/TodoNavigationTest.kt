package ro.alexmamo.roomjetpackcompose.navigation

import android.content.Context
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.testing.TestNavHostController
import androidx.navigation.toRoute
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.domain.model.toTodoDetails
import ro.alexmamo.roomjetpackcompose.presentation.MainActivity
import ro.alexmamo.roomjetpackcompose.presentation.todo_list.TodoListScreen
import ro.alexmamo.roomjetpackcompose.presentation.todo_list.TodoListViewModel
import ro.alexmamo.roomjetpackcompose.presentation.todo_details.TodoDetailsScreen
import ro.alexmamo.roomjetpackcompose.utils.getTodoTest
import javax.inject.Inject

@HiltAndroidTest
class TodoNavigationTest {
    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Inject
    lateinit var fakeViewModel: TodoListViewModel

    val context = ApplicationProvider.getApplicationContext<Context>()
    private val todoTest = getTodoTest(context)

    lateinit var navController: TestNavHostController

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Before
    fun setupNavHost() {
        composeTestRule.activity.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            fakeViewModel.insertTodo(todoTest)

            NavHost(
                navController = navController,
                startDestination = TodoListScreen
            ) {
                composable<TodoListScreen> {
                    TodoListScreen(
                        viewModel = fakeViewModel,
                        navigateToTodoDetailsScreen = { todo ->
                            val todoDetails = todo.toTodoDetails()
                            navController.navigate(todoDetails)
                        }
                    )
                }
                composable<TodoDetails> { entry ->
                    val todoDetails = entry.toRoute<TodoDetails>()
                    val todo = todoDetails.toTodo()
                    TodoDetailsScreen(
                        todo = todo,
                        navigateBack = navController::navigateUp
                    )
                }
            }
        }
        composeTestRule.waitForIdle()
    }

    @Test
    fun testStartDestinationByRoute() {
        val startDestination = navController.graph.startDestinationRoute
        val currentDestination = navController.currentBackStackEntry?.destination?.route
        Truth.assertThat(currentDestination).isEqualTo(startDestination)
    }

    @Test
    fun testStartDestinationByText() {
        composeTestRule
            .onNodeWithText(getString(R.string.todo_list_screen_name))
            .assertIsDisplayed()
    }

    @Test
    fun testNavigationFromTodoListScreenToTodoDetailsScreen() {
        composeTestRule.apply {
            onNodeWithText(getString(R.string.todo_list_screen_name))
                .assertIsDisplayed()
            onNodeWithText(todoTest.title)
                .performClick()
            onNodeWithText(getString(R.string.todo_details_screen_name))
                .assertIsDisplayed()
        }
    }

    @Test
    fun testNavigationFromTodoListScreenToTodoDetailsScreenAndBack() {
        composeTestRule.apply {
            onNodeWithText(getString(R.string.todo_list_screen_name))
                .assertIsDisplayed()
            onNodeWithText(todoTest.title)
                .performClick()
            onNodeWithText(getString(R.string.todo_details_screen_name))
                .assertIsDisplayed()
            onNodeWithContentDescription(getString(R.string.navigate_back))
                .performClick()
            onNodeWithText(getString(R.string.todo_list_screen_name))
                .assertIsDisplayed()
        }
    }

    private fun getString(@StringRes resId: Int) = composeTestRule.activity.getString(resId)
}