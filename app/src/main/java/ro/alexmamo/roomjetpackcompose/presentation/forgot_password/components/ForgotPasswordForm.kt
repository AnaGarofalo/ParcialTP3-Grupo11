package ro.alexmamo.roomjetpackcompose.presentation.forgot_password.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.BaseInput
import ro.alexmamo.roomjetpackcompose.components.ButtonsGreen
import ro.alexmamo.roomjetpackcompose.navigation.SecurityPinScreen

@Composable
fun ForgotPasswordForm(
    navController: NavHostController
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        BaseInput(
            label = stringResource(R.string.enter_email_address),
            placeholder = stringResource(R.string.example_example_com),
            modifier = Modifier.padding(horizontal = 0.dp)
        )

        ButtonsGreen(
            text = stringResource(R.string.next_step),
            modifier = Modifier.height(32.dp).width(160.dp),
            onClick = { navController.navigate(SecurityPinScreen) }
        )
    }
}