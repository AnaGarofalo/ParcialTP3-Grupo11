package ro.alexmamo.roomjetpackcompose.presentation.password_changed.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.ui.theme.LightGreen

@Composable
fun StepCircleIcon(resourceId: Int) {
    Icon(
        painter = painterResource(resourceId),
        contentDescription = null,
        tint = LightGreen,
        modifier = Modifier.size(150.dp)
    )
}