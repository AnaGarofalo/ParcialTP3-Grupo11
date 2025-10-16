package ro.alexmamo.roomjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import ro.alexmamo.roomjetpackcompose.domain.model.toTodoDetails
import ro.alexmamo.roomjetpackcompose.presentation.todo_details.TodoDetailsScreen
import ro.alexmamo.roomjetpackcompose.presentation.todo_list.TodoListScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = TodoListScreen
    ) {
        composable<TodoListScreen> {
            TodoListScreen(
                navigateToTodoDetailsScreen = { todo ->
                    val todoDetails = todo.toTodoDetails()
                    navController.navigate(todoDetails)
                }
            )
        }
        composable<TodoDetails> { entry ->
            val todoDetails = entry.toRoute<TodoDetails>()
            val todo = todoDetails.toTodo()
            TodoDetailsScreen (
                todo = todo,
                navigateBack = navController::navigateUp
            )
        }
    }
}