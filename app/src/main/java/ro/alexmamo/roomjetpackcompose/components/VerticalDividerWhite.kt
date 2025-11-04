package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun VerticalDividerWhite(height: Dp) {
    Box(
        modifier = Modifier
            .width(2.dp)
            .height(height)
            .background(MaterialTheme.colorScheme.tertiary)
    )
}