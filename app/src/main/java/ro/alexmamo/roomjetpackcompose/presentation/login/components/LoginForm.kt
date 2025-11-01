package ro.alexmamo.roomjetpackcompose.presentation.login.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.BaseInput

@Composable
fun LoginForm() {
    BaseInput(
        label = stringResource(R.string.username_or_email),
        placeholder = stringResource(R.string.example_example_com)
    )

    BaseInput(
        label = stringResource(R.string.password),
        placeholder = stringResource(R.string.password_placeholder),
        isPassword = true
    )
}