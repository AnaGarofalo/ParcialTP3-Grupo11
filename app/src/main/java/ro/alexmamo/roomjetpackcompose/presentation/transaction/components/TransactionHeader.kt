package ro.alexmamo.roomjetpackcompose.presentation.transaction.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.BalanceCard
import ro.alexmamo.roomjetpackcompose.ui.theme.Honeydew
import ro.alexmamo.roomjetpackcompose.ui.theme.Void

@Composable
fun TransactionHeader(
    totalBalance: Double,
    totalExpense: Double,
    expenseLimit: Double,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(Honeydew)
                .padding(vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.total_balance),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Void,
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "$${"%.2f".format(totalBalance)}",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                color = Void
            )
        }

        BalanceCard(
            totalBalance = totalBalance,
            totalExpense = totalExpense,
            expenseLimit = expenseLimit,
            customPercentage = 30,
            modifier = Modifier
        )
    }
}

