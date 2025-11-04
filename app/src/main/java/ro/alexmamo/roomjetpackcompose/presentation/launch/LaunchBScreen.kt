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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.ButtonsGreen
import ro.alexmamo.roomjetpackcompose.components.ButtonGreenType
import ro.alexmamo.roomjetpackcompose.ui.theme.Dimens
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.ui.theme.CaribbeanGreen

@Composable
fun LaunchBScreen(
    onLogIn: () -> Unit = {},
    onSignUp: () -> Unit = {},
    onForgotPassword: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBackground),
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
                color = CaribbeanGreen
            )
            Spacer(modifier = Modifier.height(2.dp))
            Box(
                modifier = Modifier
                    .width(240.dp)
                    .heightIn(min = 40.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.lorem_ipsum),
                    fontSize = 12.sp,
                    lineHeight = 12.sp,
                    letterSpacing = 0.em,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth(),
                    maxLines = 2,
                    overflow = TextOverflow.Clip,
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            ButtonsGreen(text = "Log In", type = ButtonGreenType.DARK, onClick = onLogIn)
            Spacer(modifier = Modifier.height(12.dp))
            ButtonsGreen(text = "Sign Up", type = ButtonGreenType.LIGHT, onClick = onSignUp)
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = stringResource(id = R.string.forgot_password),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onTertiary,
                modifier = Modifier.clickable { onForgotPassword() },
                textDecoration = TextDecoration.None
            )
        }
    }
}
