package ro.alexmamo.roomjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import ro.alexmamo.roomjetpackcompose.domain.model.toTodoDetails
import ro.alexmamo.roomjetpackcompose.presentation.account_balance.AccountBalanceScreen
import ro.alexmamo.roomjetpackcompose.presentation.create_user.CreateUserScreen
import ro.alexmamo.roomjetpackcompose.presentation.create_user.CreateUserViewModel
import ro.alexmamo.roomjetpackcompose.presentation.forgot_password.ForgotPasswordScreen
import ro.alexmamo.roomjetpackcompose.presentation.home.HomeScreen
import ro.alexmamo.roomjetpackcompose.presentation.home.WalletViewModel
import ro.alexmamo.roomjetpackcompose.presentation.login.LoginScreen
import ro.alexmamo.roomjetpackcompose.presentation.login.LoginViewModel
import ro.alexmamo.roomjetpackcompose.presentation.new_password.NewPasswordScreen
import ro.alexmamo.roomjetpackcompose.presentation.password_changed.PasswordChangedScreen
import ro.alexmamo.roomjetpackcompose.presentation.profile.ProfileScreen
import ro.alexmamo.roomjetpackcompose.presentation.profile.UserViewModel
import ro.alexmamo.roomjetpackcompose.presentation.security_pin.SecurityPinScreen
import ro.alexmamo.roomjetpackcompose.presentation.todo_details.TodoDetailsScreen
import ro.alexmamo.roomjetpackcompose.presentation.todo_list.TodoListScreen
import ro.alexmamo.roomjetpackcompose.presentation.launch.LaunchAScreen
import ro.alexmamo.roomjetpackcompose.presentation.launch.LaunchBScreen
import ro.alexmamo.roomjetpackcompose.presentation.categories.CategoriesScreen
import ro.alexmamo.roomjetpackcompose.presentation.transaction.TransactionScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = LaunchAScreen
    ) {

        val loginViewModel = LoginViewModel()
        val userViewModel = UserViewModel()
        val createUserViewModel = CreateUserViewModel()
        val walletViewModel = WalletViewModel()

        // Launch A: Launch screen
        composable<LaunchAScreen> {
            LaunchAScreen(onFinished = { navController.navigate(LaunchBScreen) })
        }

        // Launch B: Landing/Login screen
        composable<LaunchBScreen> {
            LaunchBScreen(
                onLogIn = { navController.navigate(LoginScreen) },
                onSignUp = { navController.navigate(CreateUserScreen) },
                onForgotPassword = { navController.navigate(ForgotPasswordScreen) }
            )
        }

        composable<ProfileScreen> { // Profile
            ProfileScreen(navController = navController, viewModel = userViewModel)
        }
        composable<HomeScreen> { // Homepage
            HomeScreen(navController = navController, walletViewModel = walletViewModel)
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
        composable<SecurityPinScreen> { // Enter Security Pin
            SecurityPinScreen(navController)
        }
        composable<NewPasswordScreen> { // New Password Screen
            NewPasswordScreen(navController)
        }
        composable<PasswordChangedScreen> {
            PasswordChangedScreen(navController)
        }
        composable<AccountBalanceScreen> {
            AccountBalanceScreen(navController)
        }
        composable<TransactionScreen> {
            TransactionScreen(navController)
        }
        composable<CategoriesScreen> {
            CategoriesScreen(navController)
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
            TodoDetailsScreen(
                todo = todo,
                navigateBack = navController::navigateUp
            )
        }
    }
}