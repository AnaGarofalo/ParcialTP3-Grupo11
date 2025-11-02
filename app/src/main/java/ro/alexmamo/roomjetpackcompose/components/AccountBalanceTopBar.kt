package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.ui.theme.CaribbeanGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.Honeydew
import ro.alexmamo.roomjetpackcompose.ui.theme.Void

@Composable
fun AccountBalanceTopBar(
    onNavigateBack: () -> Unit,
    onNavigateToNotifications: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Botón atrás
        ActionIconButton(
            onActionIconButtonClick = onNavigateBack,
            withCircle = false,
            content = { mod ->
                Icon(
                    painter = painterResource(id = R.drawable.arrow_left),
                    contentDescription = "Back",
                    tint = Honeydew,
                    modifier = mod
                )
            }
        )

        // Título
        Text(
            text = stringResource(R.string.account_balance),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Void
        )

        // Campanita de notificaciones
        ActionIconButton(
            onActionIconButtonClick = onNavigateToNotifications,
            withCircle = true,
            circleSize = 36.dp,
            circleColor = Honeydew,
            content = { mod ->
                Icon(
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = "Notifications",
                    tint = CaribbeanGreen,
                    modifier = mod
                )
            }
        )
    }
}

