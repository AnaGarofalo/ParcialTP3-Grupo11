package ro.alexmamo.roomjetpackcompose.presentation.create_user.components

import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.BaseInput
import ro.alexmamo.roomjetpackcompose.presentation.create_user.CreateUserViewModel

@Composable
fun CreateUserForm(
    navController: NavHostController,
    viewModel: CreateUserViewModel = viewModel(),
) {
    val email = rememberTextFieldState(initialText = "")
    val password = rememberTextFieldState(initialText = "")
    val username = rememberTextFieldState(initialText = "")

    BaseInput(
        label = stringResource(R.string.full_name),
        placeholder = stringResource(R.string.example_example_com),
        externalState = username
    )

    BaseInput(
        label = stringResource(R.string.email),
        placeholder = stringResource(R.string.example_example_com),
        externalState = email
    )

    BaseInput(
        label = stringResource(R.string.mobile_number),
        placeholder = stringResource(R.string._123_456_789)
    )

    BaseInput(
        label = stringResource(R.string.date_of_birth),
        placeholder = stringResource(R.string.dd_mm_yyy)
    )

    BaseInput(
        label = stringResource(R.string.password),
        placeholder = stringResource(R.string.password_placeholder),
        externalState = password,
        isPassword = true
    )

    BaseInput(
        label = stringResource(R.string.confirm_password),
        placeholder = stringResource(R.string.password_placeholder),
        isPassword = true
    )

    SignUpButton(navController, viewModel, email.text as String, password.text as String, username.text as String)

    SignInMessage(navController)
}