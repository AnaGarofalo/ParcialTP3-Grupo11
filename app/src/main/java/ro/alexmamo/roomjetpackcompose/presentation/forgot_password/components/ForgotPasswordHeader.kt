package ro.alexmamo.roomjetpackcompose.presentation.forgot_password.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.R

@Composable
fun ForgotPasswordHeader() {
    Column (
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = stringResource(R.string.reset_password),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.tertiaryFixed
        )

        Text(
            text = stringResource(R.string.lorem_ipsum_dolor),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onTertiary
        )
    }
}