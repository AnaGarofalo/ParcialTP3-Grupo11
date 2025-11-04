package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.navigation.CreateUserScreen

@Composable
fun AlternativeSignUpMethods(
    navController: NavHostController,
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = stringResource(R.string.or_sign_up_with),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(top = 16.dp),
            color = MaterialTheme.colorScheme.onTertiary
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.facebook),
                contentDescription = stringResource(R.string.facebook),
                tint = MaterialTheme.colorScheme.onTertiary
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.google),
                contentDescription = stringResource(R.string.google),
                tint = MaterialTheme.colorScheme.onTertiary
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = stringResource(R.string.don_t_have_an_account),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onTertiary
            )

            ClickableText(
                text = AnnotatedString(stringResource(R.string.sign_up_caps)),
                style = MaterialTheme.typography.labelSmall.copy(
                    color = MaterialTheme.colorScheme.inverseOnSurface
                ),
                onClick = {
                    navController.navigate(CreateUserScreen)
                }
            )
        }
    }
}