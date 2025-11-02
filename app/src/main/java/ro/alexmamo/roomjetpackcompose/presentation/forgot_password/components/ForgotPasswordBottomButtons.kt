package ro.alexmamo.roomjetpackcompose.presentation.forgot_password.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.AlternativeSignUpMethods
import ro.alexmamo.roomjetpackcompose.components.ButtonGreenType
import ro.alexmamo.roomjetpackcompose.components.ButtonsGreen
import ro.alexmamo.roomjetpackcompose.navigation.CreateUserScreen

@Composable
fun ForgotPasswordBottomButtons(
    navController: NavHostController
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ButtonsGreen(
            text = stringResource(R.string.sign_up),
            modifier = Modifier.height(32.dp).width(160.dp),
            type = ButtonGreenType.LIGHT,
            onClick = {
                navController.navigate(CreateUserScreen)
            }
        )

        AlternativeSignUpMethods(navController)
    }
}