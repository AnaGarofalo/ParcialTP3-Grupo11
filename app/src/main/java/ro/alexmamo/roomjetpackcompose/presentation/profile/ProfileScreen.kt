package ro.alexmamo.roomjetpackcompose.presentation.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProfileScreen(viewModel: UserViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchUser(1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (uiState) {
            is UserViewModel.UiState.Idle -> Text("Esperando acción…")
            is UserViewModel.UiState.Loading -> CircularProgressIndicator()
            is UserViewModel.UiState.Success -> {
                val user = (uiState as UserViewModel.UiState.Success).user
                Text("Usuario: ${user.name.firstname} ${user.name.lastname}")
                Spacer(Modifier.height(8.dp))
                Text("Email: ${user.email}")
                Text("Ciudad: ${user.address.city}")
            }
            is UserViewModel.UiState.Error -> Text(
                "Error: ${(uiState as UserViewModel.UiState.Error).message}",
            )
        }
    }
}