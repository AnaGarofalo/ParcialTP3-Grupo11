package ro.alexmamo.roomjetpackcompose.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import ro.alexmamo.roomjetpackcompose.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.ui.theme.Void


@Composable
fun EyesPassButton(
    passwordVisible: Boolean,
    onToggleVisibility: () -> Unit
) {
    val iconRes = if (passwordVisible) R.drawable.eye_on else R.drawable.eye_off

    Box(
        modifier = Modifier
            .size(48.dp)
            .clip(RoundedCornerShape(50.dp))
            .clickable { onToggleVisibility() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = if (passwordVisible) "Ocultar contraseña" else "Mostrar contraseña",
            tint = Void,
            modifier = Modifier.size(28.dp)
        )
    }
}