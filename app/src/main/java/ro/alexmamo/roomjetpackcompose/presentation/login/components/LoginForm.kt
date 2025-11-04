package ro.alexmamo.roomjetpackcompose.presentation.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.AlternativeSignUpMethods
import ro.alexmamo.roomjetpackcompose.components.BaseInput
import ro.alexmamo.roomjetpackcompose.components.ButtonGreenType
import ro.alexmamo.roomjetpackcompose.components.ButtonsGreen
import ro.alexmamo.roomjetpackcompose.navigation.CreateUserScreen
import ro.alexmamo.roomjetpackcompose.navigation.ForgotPasswordScreen

@Composable
fun LoginForm(
    navController: NavHostController
) {
    val email = rememberTextFieldState(initialText = "")
    val password = rememberTextFieldState(initialText = "")

    BaseInput(
        label = stringResource(R.string.username_or_email),
        placeholder = stringResource(R.string.example_example_com),
        externalState = email,
        modifier = Modifier.padding(16.dp)
    )

    BaseInput(
        label = stringResource(R.string.password),
        placeholder = stringResource(R.string.password_placeholder),
        externalState = password,
        isPassword = true,
        modifier = Modifier.padding(16.dp)
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        LogInButton(
            navController,
            email.text as String,
            password.text as String
        )

        ClickableText (
            text = AnnotatedString(stringResource(R.string.forgot_password)),
            style = MaterialTheme.typography.titleSmall.copy(
                color = MaterialTheme.colorScheme.onTertiary,
            ),
            onClick = {
                navController.navigate(ForgotPasswordScreen)
            }
        )

        ButtonsGreen(
            text = stringResource(R.string.sign_up),
            onClick = {navController.navigate(CreateUserScreen)},
            type = ButtonGreenType.LIGHT
        )

        FingerprintButton()

        AlternativeSignUpMethods(navController)
    }
}