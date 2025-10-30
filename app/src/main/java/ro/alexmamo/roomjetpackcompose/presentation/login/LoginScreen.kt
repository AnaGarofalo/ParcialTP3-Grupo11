package ro.alexmamo.roomjetpackcompose.presentation.login

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import ro.alexmamo.roomjetpackcompose.infraestructure.auth.Token

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel(),
    onLoginSuccess: (Token) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Button(onClick = { viewModel.login("user", "pass") }) {
        Text("Iniciar sesión")
    }

    when (uiState) {
        is LoginViewModel.UiState.Loading -> Text("Cargando...")
        is LoginViewModel.UiState.Success -> {
            val token = (uiState as LoginViewModel.UiState.Success).token
            LaunchedEffect(Unit) {
                onLoginSuccess(token) // redirigís acá
            }
        }
        is LoginViewModel.UiState.Error -> Text("Error: ${(uiState as LoginViewModel.UiState.Error).message}")
        else -> {}
    }
}