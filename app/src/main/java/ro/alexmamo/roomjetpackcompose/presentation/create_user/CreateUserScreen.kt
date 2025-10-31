package ro.alexmamo.roomjetpackcompose.presentation.create_user

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import ro.alexmamo.roomjetpackcompose.infraestructure.user.User

@Composable
fun CreateUserScreen(
    viewModel: CreateUserViewModel = viewModel(),
    onCreateUserSuccess: (User) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Button(onClick = { viewModel.createUser("email", "pass", "user") }) {
        Text("Crear usuario")
    }

    when (uiState) {
        is CreateUserViewModel.UiState.Loading -> Text("Cargando...")
        is CreateUserViewModel.UiState.Success -> {
            val user = (uiState as CreateUserViewModel.UiState.Success).user
            LaunchedEffect(Unit) {
                onCreateUserSuccess(user)
            }
        }
        is CreateUserViewModel.UiState.Error -> Text("Error: ${(uiState as CreateUserViewModel.UiState.Error).message}")
        else -> {}
    }
}