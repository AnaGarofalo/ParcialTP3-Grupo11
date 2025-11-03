package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.R

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
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = stringResource(R.string.hi_welcome_back),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSecondary,
                    lineHeight = 4.sp,
                )

                Text(
                    text = stringResource(R.string.good_morning),
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSecondary,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 4.sp,
                )
            }

            // Campanita de notificaciones
            NotificationButton(
                onNotificationClick = onNotificationClick
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

