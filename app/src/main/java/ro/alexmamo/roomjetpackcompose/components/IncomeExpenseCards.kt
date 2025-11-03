package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.ui.theme.CaribbeanGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.Void
import ro.alexmamo.roomjetpackcompose.ui.theme.VividBlue
import ro.alexmamo.roomjetpackcompose.R

@Composable
fun IncomeExpenseCards(
    income: Double,
    expense: Double,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Income Card
        IncomeExpenseCard(
            title = "Income",
            amount = income,
            icon = R.drawable.income,
            iconColor = CaribbeanGreen,
            amountColor = Void,
            modifier = Modifier.weight(1f)
        )

        // Expense Card
        IncomeExpenseCard(
            title = "Expense",
            amount = expense,
            icon = R.drawable.expense,
            iconColor = VividBlue,
            amountColor = VividBlue,
            modifier = Modifier.weight(1f)
        )
    }
}

