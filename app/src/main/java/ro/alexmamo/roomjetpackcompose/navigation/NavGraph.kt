package ro.alexmamo.roomjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ro.alexmamo.roomjetpackcompose.presentation.account_balance.AccountBalanceScreen
import ro.alexmamo.roomjetpackcompose.presentation.create_user.CreateUserScreen
import ro.alexmamo.roomjetpackcompose.presentation.forgot_password.ForgotPasswordScreen
import ro.alexmamo.roomjetpackcompose.presentation.home.HomeScreen
import ro.alexmamo.roomjetpackcompose.presentation.home.WalletViewModel
import ro.alexmamo.roomjetpackcompose.presentation.login.LoginScreen
import ro.alexmamo.roomjetpackcompose.presentation.new_password.NewPasswordScreen
import ro.alexmamo.roomjetpackcompose.presentation.password_changed.PasswordChangedScreen
import ro.alexmamo.roomjetpackcompose.presentation.notification.NotificationScreen
import ro.alexmamo.roomjetpackcompose.presentation.profile.ProfileScreen
import ro.alexmamo.roomjetpackcompose.presentation.security_pin.SecurityPinScreen
import ro.alexmamo.roomjetpackcompose.presentation.launch.LaunchAScreen
import ro.alexmamo.roomjetpackcompose.presentation.launch.LaunchBScreen
import ro.alexmamo.roomjetpackcompose.presentation.onboarding.OnboardingScreen
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
        // Launch A: Launch screen
        composable<LaunchAScreen> {
            LaunchAScreen(onFinished = { navController.navigate(LaunchBScreen) })
        }

        // Launch B: Landing/Login screen
        composable<LaunchBScreen> {
            LaunchBScreen(
                onLogIn = { navController.navigate(LoginScreen) },
                onSignUp = { navController.navigate(OnboardingScreen) },
                onForgotPassword = { navController.navigate(ForgotPasswordScreen) }
            )
        }

        // Onboarding
        composable<OnboardingScreen> {
            OnboardingScreen(onFinished = { navController.navigate(CreateUserScreen) })
        }

        composable<ProfileScreen> { // Profile
            ProfileScreen(navController = navController)
        }
        composable<HomeScreen> { // Homepage
            HomeScreen(navController = navController, onNavigateToNotifications = {
                navController.navigate(NotificationScreen)
            })
        }

        composable<NotificationScreen> { // Notifications
            NotificationScreen(navController)
        }

        composable<LoginScreen> { // Login
            LoginScreen(navController)
        }
        composable<ForgotPasswordScreen> { // Forgot Password
            ForgotPasswordScreen(navController)
        }
        composable<CreateUserScreen> { // Sign up
            CreateUserScreen(navController)
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
            AccountBalanceScreen(
                navController, onNavigateBack = navController::navigateUp,
                onNavigateToNotifications = {
                    navController.navigate(NotificationScreen)
                }
            )
        }
        composable<TransactionScreen> {
            TransactionScreen(
                navController, onNavigateBack = navController::navigateUp,
                onNavigateToNotifications = {
                    navController.navigate(NotificationScreen)
                }
            )
        }
        composable<CategoriesScreen> {
            CategoriesScreen(
                navController, onNavigateBack = navController::navigateUp,
                onNavigateToNotifications = {
                    navController.navigate(NotificationScreen)
                }
            )
        }
    }
}