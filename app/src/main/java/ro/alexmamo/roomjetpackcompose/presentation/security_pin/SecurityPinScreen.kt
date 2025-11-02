package ro.alexmamo.roomjetpackcompose.presentation.security_pin

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.LoginTitle
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen

@Composable
fun SecurityPinScreen(navController: NavHostController,) {
    BaseScreen(
        centerContent = true,
        header = { LoginTitle(text = stringResource(R.string.security_pin)) },
        content = {

        }
    )
}