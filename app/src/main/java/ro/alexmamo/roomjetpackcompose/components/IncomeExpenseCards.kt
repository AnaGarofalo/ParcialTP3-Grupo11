package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.ui.theme.CaribbeanGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.Void
import ro.alexmamo.roomjetpackcompose.ui.theme.VividBlue

@Composable
fun IncomeExpenseCards(
    income: Double,
    expense: Double,
    incomeIcon: Int,
    expenseIcon: Int,
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
            icon = incomeIcon,
            iconColor = CaribbeanGreen,
            amountColor = Void,
            modifier = Modifier.weight(1f)
        )

        // Expense Card
        IncomeExpenseCard(
            title = "Expense",
            amount = expense,
            icon = expenseIcon,
            iconColor = VividBlue,
            amountColor = VividBlue,
            modifier = Modifier.weight(1f)
        )
    }
}

