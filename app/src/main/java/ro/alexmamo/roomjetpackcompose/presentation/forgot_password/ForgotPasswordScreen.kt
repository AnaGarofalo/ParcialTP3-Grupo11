package ro.alexmamo.roomjetpackcompose.presentation.forgot_password

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.presentation.forgot_password.components.ForgotPasswordBottomButtons
import ro.alexmamo.roomjetpackcompose.presentation.forgot_password.components.ForgotPasswordForm
import ro.alexmamo.roomjetpackcompose.presentation.forgot_password.components.ForgotPasswordHeader
import ro.alexmamo.roomjetpackcompose.components.LoginTitle
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen

@Composable
fun ForgotPasswordScreen (
    navController: NavHostController
) {
    BaseScreen(
        centerContent = true,
        header = { LoginTitle(text = stringResource(R.string.forgot_password_title)) },
        content = {
            ForgotPasswordHeader()

            Spacer(modifier = Modifier.height(64.dp))

            ForgotPasswordForm(navController)

            Spacer(modifier = Modifier.height(80.dp))

            ForgotPasswordBottomButtons(navController)
        }
    )
}
