package ro.alexmamo.roomjetpackcompose.presentation.profile.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.presentation.profile.UserViewModel

@Composable
fun ApiUserSection(viewModel: UserViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchUser(1)
    }

    when (uiState) {
        is UserViewModel.UiState.Idle -> {}
        is UserViewModel.UiState.Loading -> {
            CircularProgressIndicator()
        }
        is UserViewModel.UiState.Success -> {
            val user = (uiState as UserViewModel.UiState.Success).user
            Text(
                stringResource(R.string.usuario, user.name.firstname, user.name.lastname),
                color = MaterialTheme.colorScheme.onTertiary
            )

            Text(stringResource(R.string.email, user.email), color = MaterialTheme.colorScheme.onTertiary)
            Text(stringResource(R.string.ciudad, user.address.city), color = MaterialTheme.colorScheme.onTertiary)
        }
        is UserViewModel.UiState.Error -> {
            Text(
                stringResource(R.string.error, (uiState as UserViewModel.UiState.Error).message),
                color = MaterialTheme.colorScheme.onTertiary
            )
        }
    }
}