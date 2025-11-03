package ro.alexmamo.roomjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import ro.alexmamo.roomjetpackcompose.domain.model.toTodoDetails
import ro.alexmamo.roomjetpackcompose.presentation.create_user.CreateUserScreen
import ro.alexmamo.roomjetpackcompose.presentation.create_user.CreateUserViewModel
import ro.alexmamo.roomjetpackcompose.presentation.forgot_password.ForgotPasswordScreen
import ro.alexmamo.roomjetpackcompose.presentation.home.HomeScreen
import ro.alexmamo.roomjetpackcompose.presentation.home.WalletViewModel
import ro.alexmamo.roomjetpackcompose.presentation.login.LoginScreen
import ro.alexmamo.roomjetpackcompose.presentation.login.LoginViewModel
import ro.alexmamo.roomjetpackcompose.presentation.notification.NotificationScreen
import ro.alexmamo.roomjetpackcompose.presentation.profile.ProfileScreen
import ro.alexmamo.roomjetpackcompose.presentation.profile.UserViewModel
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

        val loginViewModel = LoginViewModel()
        val userViewModel = UserViewModel()
        val createUserViewModel = CreateUserViewModel()
        val walletViewModel = WalletViewModel()

        composable<UserScreen> { // Profile
            ProfileScreen(userViewModel)
        }
        composable<HomeScreen> { // Homepage
            HomeScreen(
                walletViewModel = walletViewModel,
                onNavigateToNotifications = {
                    navController.navigate(NotificationScreen)
                }
            )
        }

        composable<NotificationScreen> { // Notifications
            NotificationScreen(onNavigateBack = navController::popBackStack)
        }

        composable<LoginScreen> { // Login
            LoginScreen(loginViewModel, navController)
        }
        composable<ForgotPasswordScreen> { // Forgot Password
            ForgotPasswordScreen(navController)
        }
        composable<CreateUserScreen> { // Sign up
            CreateUserScreen(createUserViewModel, navController)
        }





        // TO delete
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