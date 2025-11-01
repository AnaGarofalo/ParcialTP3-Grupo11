package ro.alexmamo.roomjetpackcompose.presentation.launch

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.ButtonsGreen
import ro.alexmamo.roomjetpackcompose.components.ButtonGreenType
import ro.alexmamo.roomjetpackcompose.ui.theme.Dimens
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.em

@Composable
fun LaunchBScreen(
    onLogIn: () -> Unit = {},
    onSignUp: () -> Unit = {},
    onForgotPassword: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.paddingLarge)
        ) {
            Image(
                painter = painterResource(id = R.drawable.launch_2),
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = R.string.finwise),
                fontSize = 52.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.background
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = stringResource(id = R.string.lorem_ipsum),
                fontSize = 13.sp,
                letterSpacing = (-0.02).em,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = Dimens.paddingLarge),
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(24.dp))

            ButtonsGreen(text = "Log In", type = ButtonGreenType.DARK) {
                onLogIn()
            }
            Spacer(modifier = Modifier.height(12.dp))
            ButtonsGreen(text = "Sign Up", type = ButtonGreenType.LIGHT) {
                onSignUp()
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = stringResource(id = R.string.forgot_password),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.clickable { onForgotPassword() },
                textDecoration = TextDecoration.None
            )
        }
    }
}
