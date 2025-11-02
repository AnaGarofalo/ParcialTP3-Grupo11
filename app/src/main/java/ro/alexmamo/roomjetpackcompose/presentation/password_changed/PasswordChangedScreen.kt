package ro.alexmamo.roomjetpackcompose.presentation.password_changed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.navigation.LoginScreen
import ro.alexmamo.roomjetpackcompose.presentation.password_changed.components.StepperAnimation
import ro.alexmamo.roomjetpackcompose.ui.theme.LightGreen

@Composable
fun PasswordChangedScreen(navController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(64.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            StepperAnimation()
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.password_has_been_changed_successfully),
                style = MaterialTheme.typography.titleMedium,
                color = LightGreen,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }

    LaunchedEffect (Unit) {
        delay(800 * 4)
        navController.navigate(LoginScreen)
    }
}