package ro.alexmamo.roomjetpackcompose.presentation.profile.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.presentation.profile.UserViewModel

@Composable
fun ApiUserSection(viewModel: UserViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchUser(1)
    }

    when (uiState) {
        is UserViewModel.UiState.Idle -> {
            Text("Esperando acción…")
        }
        is UserViewModel.UiState.Loading -> {
            CircularProgressIndicator()
        }
        is UserViewModel.UiState.Success -> {
            val user = (uiState as UserViewModel.UiState.Success).user
            Text(stringResource(R.string.usuario, user.name.firstname, user.name.lastname))

            Text(stringResource(R.string.email, user.email))
            Text(stringResource(R.string.ciudad, user.address.city))
        }
        is UserViewModel.UiState.Error -> {
            Text(
                stringResource(R.string.error, (uiState as UserViewModel.UiState.Error).message),
            )
        }
    }
}