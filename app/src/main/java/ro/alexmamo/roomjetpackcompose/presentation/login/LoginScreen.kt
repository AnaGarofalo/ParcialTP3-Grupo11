package ro.alexmamo.roomjetpackcompose.presentation.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.BaseAlertDialog
import ro.alexmamo.roomjetpackcompose.components.LoginTitle
import ro.alexmamo.roomjetpackcompose.infraestructure.auth.Token
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen
import ro.alexmamo.roomjetpackcompose.presentation.login.components.LoginForm

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel(),
    onLoginSuccess: (Token) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    var errorMessage by remember { mutableStateOf("") }

    when (uiState) {
        is LoginViewModel.UiState.Success -> {
            val token = (uiState as LoginViewModel.UiState.Success).token
            LaunchedEffect(Unit) {
                onLoginSuccess(token)
            }
        }
        is LoginViewModel.UiState.Error -> {
            val message = (uiState as LoginViewModel.UiState.Error).message
            LaunchedEffect(message) {
                errorMessage = message
            }
        }
        else -> Unit
    }

    BaseScreen(
        centerContent = true,
        header = { LoginTitle(text = stringResource(R.string.welcome)) },
        content = {
            LoginForm()
        }
    )

    BaseAlertDialog(
        message = errorMessage,
        title = stringResource(R.string.login_error),
        onDismiss = {errorMessage = ""}
    )
}