package ro.alexmamo.roomjetpackcompose.presentation.security_pin.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.ButtonGreenType
import ro.alexmamo.roomjetpackcompose.components.ButtonsGreen

@Composable
fun SecurityPinForm(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.spacedBy(64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(R.string.enter_security_pin),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onTertiary
        )

        PinCodeInput(
            pinLength = 6,
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            ButtonsGreen(
                text = stringResource(R.string.accept),
                modifier = Modifier
                    .height(32.dp)
                    .width(160.dp),
                onClick = { }
            )

            ButtonsGreen(
                text = stringResource(R.string.send_again),
                modifier = Modifier
                    .height(32.dp)
                    .width(160.dp),
                type = ButtonGreenType.LIGHT,
                onClick = { }
            )
        }
    }
}