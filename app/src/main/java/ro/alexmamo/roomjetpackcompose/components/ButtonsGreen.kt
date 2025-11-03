package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.ui.theme.CaribbeanGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.FenceGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.LightGreen

enum class ButtonGreenType {
    DARK, LIGHT
}

@Composable
fun ButtonsGreen(
    modifier: Modifier = Modifier,
    text: String,
    type: ButtonGreenType = ButtonGreenType.DARK,
    onClick: () -> Unit
) {
    val backgroundColor = when (type) {
        ButtonGreenType.DARK -> CaribbeanGreen
        ButtonGreenType.LIGHT -> LightGreen
    }

    val textColor = FenceGreen

    Box(
        modifier = modifier
            .defaultMinSize(minWidth = 207.dp, minHeight = 45.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(backgroundColor)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            style = MaterialTheme.typography.titleMedium
        )
    }
}