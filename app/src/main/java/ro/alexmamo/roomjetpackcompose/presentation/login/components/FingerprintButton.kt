package ro.alexmamo.roomjetpackcompose.presentation.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun FingerprintButton() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Use ",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onTertiary)
        Text(
            "Fingerprint ",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.surfaceBright
        )
        Text("To Access ",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onTertiary)
    }
}