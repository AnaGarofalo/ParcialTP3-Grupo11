package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.ui.theme.DarkGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.Honeydew

@Composable
fun NotificationButton(
    onNotificationClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ActionIconButton(
        onActionIconButtonClick = onNotificationClick,
        withCircle = true,
        circleSize = 36.dp,
        circleColor = Honeydew,
        modifier = modifier,
        content = { mod ->
            Icon(
                painter = painterResource(id = R.drawable.notification),
                contentDescription = "Notifications",
                tint = DarkGreen,
                modifier = mod
            )
        }
    )
}

