package ro.alexmamo.roomjetpackcompose.presentation.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.R

@Composable
fun AlternativeSignUpMethods() {
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
            tint  = MaterialTheme.colorScheme.onTertiary
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.google),
            contentDescription = stringResource(R.string.google),
            tint  = MaterialTheme.colorScheme.onTertiary
        )
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(text = stringResource(R.string.don_t_have_an_account),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onTertiary)
        Text(text = stringResource(R.string.sign_up_caps),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.surfaceBright)
    }
}