package ro.alexmamo.roomjetpackcompose.navigation

import ProductsListScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import ro.alexmamo.roomjetpackcompose.domain.model.toTodoDetails
import ro.alexmamo.roomjetpackcompose.infraestructure.auth.AuthImpl
import ro.alexmamo.roomjetpackcompose.infraestructure.product.ProductImpl
import ro.alexmamo.roomjetpackcompose.presentation.login.LoginScreen
import ro.alexmamo.roomjetpackcompose.presentation.login.LoginViewModel
import ro.alexmamo.roomjetpackcompose.presentation.product.GetProductsUseCase
import ro.alexmamo.roomjetpackcompose.presentation.product.ProductListViewModel
import ro.alexmamo.roomjetpackcompose.presentation.todo_details.TodoDetailsScreen
import ro.alexmamo.roomjetpackcompose.presentation.todo_list.TodoListScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = LoginScreen
    ) {

        val presenter = ProductListViewModel(GetProductsUseCase(ProductImpl()))
        val loginViewModel = LoginViewModel(AuthImpl())

        composable<TodoListScreen> {
            TodoListScreen(
                navigateToTodoDetailsScreen = { todo ->
                    val todoDetails = todo.toTodoDetails()
                    navController.navigate(todoDetails)
                }
            )
        }
        composable<ProductsListScreen> {
            ProductsListScreen(presenter)
        }
        composable<LoginScreen> {
            LoginScreen(loginViewModel, onLoginSuccess = { token ->
                navController.navigate(TodoListScreen)
            })
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