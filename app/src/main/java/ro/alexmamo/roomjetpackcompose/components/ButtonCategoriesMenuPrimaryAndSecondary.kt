package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.ui.theme.LightBlue
import ro.alexmamo.roomjetpackcompose.ui.theme.OceanBlue

@Composable
fun ButtonCategoriesMenuPrimaryAndSecondary(
    iconRes: Int,
    selected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (selected) OceanBlue else LightBlue
    val iconTint = Color.White

    Box(
        modifier = Modifier
            .width(105.dp)
            .height(98.dp)
            .clip(RoundedCornerShape(26.dp))
            .background(backgroundColor)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(45.dp)
        )
    }
}