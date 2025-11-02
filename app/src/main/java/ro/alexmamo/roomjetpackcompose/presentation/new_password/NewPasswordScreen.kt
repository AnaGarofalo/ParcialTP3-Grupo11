package ro.alexmamo.roomjetpackcompose.presentation.new_password

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.BaseInput
import ro.alexmamo.roomjetpackcompose.components.ButtonsGreen
import ro.alexmamo.roomjetpackcompose.components.LoginTitle
import ro.alexmamo.roomjetpackcompose.navigation.SecurityPinScreen
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen

@Composable
fun NewPasswordScreen (
    navController: NavHostController
) {
    BaseScreen(
        centerContent = true,
        header = { LoginTitle(text = stringResource(R.string.new_password)) },
        content = {
            BaseInput(
                label = stringResource(R.string.new_password),
                placeholder = stringResource(R.string.password),
                isPassword = true
            )

            Spacer(modifier = Modifier.height(24.dp))

            BaseInput(
                label = stringResource(R.string.confirm_new_password),
                placeholder = stringResource(R.string.password),
                isPassword = true
            )

            Spacer(modifier = Modifier.height(120.dp))

            ButtonsGreen(
                text = stringResource(R.string.change_password),
                modifier = Modifier
                    .height(45.dp)
                    .fillMaxWidth(),
                onClick = { navController.navigate(SecurityPinScreen) }
            )
            Spacer(modifier = Modifier.height(160.dp))
        }
    )
}