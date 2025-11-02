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
fun HomeHeader(
    totalBalance: Double,
    totalExpense: Double,
    expenseLimit: Double,
    onNotificationClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        // Saludo y notificaciones
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = stringResource(R.string.hi_welcome_back),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Void
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stringResource(R.string.good_morning),
                    fontSize = 14.sp,
                    color = Void.copy(alpha = 0.6f)
                )
            }

            // Campanita de notificaciones
            ActionIconButton(
                onActionIconButtonClick = onNotificationClick,
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

        Spacer(modifier = Modifier.height(16.dp))

        // Balance Card
        BalanceCard(
            totalBalance = totalBalance,
            totalExpense = totalExpense,
            expenseLimit = expenseLimit,
            customPercentage = 30,
            modifier = Modifier
        )
    }
}

