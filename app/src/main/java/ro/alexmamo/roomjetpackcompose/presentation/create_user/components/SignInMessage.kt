package ro.alexmamo.roomjetpackcompose.presentation.create_user.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.navigation.LoginScreen

@Composable
fun SignInMessage(navController: NavHostController) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(2.dp),
//        modifier = Modifier.padding(bottom = 64.dp)
    ) {
        Text(text = stringResource(R.string.already_have_an_account),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onTertiary)

        ClickableText (
            text = AnnotatedString(stringResource(R.string.log_in_2)),
            style = MaterialTheme.typography.labelSmall.copy(
                color = MaterialTheme.colorScheme.surfaceBright
            ),
            onClick = {
                navController.navigate(LoginScreen)
            }
        )
    }
}