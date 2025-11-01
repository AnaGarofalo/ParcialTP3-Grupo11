package ro.alexmamo.roomjetpackcompose.presentation.login.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.BaseAlertDialog
import ro.alexmamo.roomjetpackcompose.components.ButtonsGreen
import ro.alexmamo.roomjetpackcompose.navigation.HomeScreen
import ro.alexmamo.roomjetpackcompose.presentation.login.LoginViewModel

@Composable
fun LogInButton(
    navController: NavHostController,
    viewModel: LoginViewModel = viewModel(),
    email: String,
    password: String
) {
    val uiState by viewModel.uiState.collectAsState()
    var errorMessage by remember { mutableStateOf("") }

    when (uiState) {
        is LoginViewModel.UiState.Success -> {
            val token = (uiState as LoginViewModel.UiState.Success).token
            LaunchedEffect(Unit) {
                navController.navigate(HomeScreen)
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

    ButtonsGreen (
        text = stringResource(R.string.log_in),
        onClick = {
            viewModel.login(email, password)
        }
    )

    BaseAlertDialog(
        message = errorMessage,
        title = stringResource(R.string.login_error),
        onDismiss = {errorMessage = ""}
    )
}