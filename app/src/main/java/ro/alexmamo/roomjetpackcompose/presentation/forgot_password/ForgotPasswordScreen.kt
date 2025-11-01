package ro.alexmamo.roomjetpackcompose.presentation.forgot_password

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.LoginTitle
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen
import ro.alexmamo.roomjetpackcompose.presentation.login.LoginViewModel
import ro.alexmamo.roomjetpackcompose.presentation.login.components.LoginForm

@Composable
fun ForgotPasswordScreen (
    navController: NavHostController
) {
    BaseScreen(
        centerContent = true,
        header = { LoginTitle(text = stringResource(R.string.forgot_password_title)) },
        content = {

        }
    )
}