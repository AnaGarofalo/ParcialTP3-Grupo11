package ro.alexmamo.roomjetpackcompose.presentation.create_user.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.BaseAlertDialog
import ro.alexmamo.roomjetpackcompose.components.ButtonsGreen
import ro.alexmamo.roomjetpackcompose.navigation.HomeScreen
import ro.alexmamo.roomjetpackcompose.presentation.create_user.CreateUserViewModel
import ro.alexmamo.roomjetpackcompose.presentation.login.LoginViewModel

@Composable
fun SignUpButton(
    navController: NavHostController,
    viewModel: CreateUserViewModel = viewModel(),
    email: String,
    password: String,
    username: String
) {
    val uiState by viewModel.uiState.collectAsState()
    var errorMessage by remember { mutableStateOf("") }


    when (uiState) {
        is CreateUserViewModel.UiState.Success -> {
            val user = (uiState as CreateUserViewModel.UiState.Success).user
            LaunchedEffect(Unit) {
               navController.navigate(HomeScreen)
            }
        }
        is CreateUserViewModel.UiState.Error -> {
            val message = (uiState as LoginViewModel.UiState.Error).message
            LaunchedEffect(message) {
                errorMessage = message
            }
        }
        else -> {}
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
                    append(stringResource(R.string.by_continuing_you_agree_to))
                }
                append("\n")
                append(stringResource(R.string.terms_of_use))
                withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
                    append(stringResource(R.string.and))
                }
                append(stringResource(R.string.privacy_policy))
            },
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onTertiary,
            textAlign = TextAlign.Center
        )

        ButtonsGreen(
            text = stringResource(R.string.sign_up),
            onClick = {
                viewModel.createUser(email, password, username)
            }
        )
    }

    BaseAlertDialog(
        message = errorMessage,
        title = stringResource(R.string.sign_up_error),
        onDismiss = {errorMessage = ""}
    )
}