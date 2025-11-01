package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color

@Composable
fun ActionIconButton(
    onActionIconButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    withCircle: Boolean = false,
    circleSize: Dp = 30.dp,
    circleColor: Color = MaterialTheme.colorScheme.surface,
    iconSizeWhenCircle: Dp = 18.dp,
    iconSizeDefault: Dp = 19.dp,
    content: @Composable (Modifier) -> Unit
) {
    IconButton(
        onClick = onActionIconButtonClick,
        modifier = modifier
    ) {
        val iconModifier = if (withCircle) Modifier.size(iconSizeWhenCircle) else Modifier.size(iconSizeDefault)
        if (withCircle) {
            Box(
                modifier = Modifier
                    .size(circleSize)
                    .background(color = circleColor, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                content(iconModifier)
            }
        } else {
            content(iconModifier)
        }
    }
}