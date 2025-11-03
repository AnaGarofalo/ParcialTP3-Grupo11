package ro.alexmamo.roomjetpackcompose.presentation.profile.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.LoadingIndicator
import ro.alexmamo.roomjetpackcompose.core.logMessage
import ro.alexmamo.roomjetpackcompose.domain.model.Response
import ro.alexmamo.roomjetpackcompose.presentation.profile.UserListViewModel

@Composable
fun DBUserSection(viewModel: UserListViewModel = hiltViewModel()) {
    val userListResponse by viewModel.userListState.collectAsStateWithLifecycle()

    when(val userListResponse = userListResponse) {
        is Response.Idle -> {}
        is Response.Loading -> LoadingIndicator()
        is Response.Success -> userListResponse.data.let { userList ->
            if (userList.isEmpty()) {
                Text(stringResource(R.string.no_hay_usuarios_agregados))
            } else {
                Column {
                    userList.forEach { user ->
                        Text(text = "👤 ${user.id} — ${user.username} — ${user.email}")
                    }
                }
            }
        }
        is Response.Failure -> userListResponse.e.message?.let { errorMessage ->
            LaunchedEffect(errorMessage) {
                logMessage(errorMessage)
            }
        }
    }
}