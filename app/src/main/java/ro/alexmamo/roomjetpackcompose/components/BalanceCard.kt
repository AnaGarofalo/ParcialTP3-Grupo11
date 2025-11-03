package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.presentation.account_balance.components.IncomeExpenseCards
import ro.alexmamo.roomjetpackcompose.ui.theme.Honeydew

@Composable
fun BalanceCard(
    totalBalance: Double,
    totalExpense: Double,
    expenseLimit: Double,
    modifier: Modifier = Modifier,
    customPercentage: Int? = null,
    income: Double? = null,
    expense: Double? = null
) {
    val expensePercentage = customPercentage ?: if (expenseLimit > 0) {
        ((totalExpense / expenseLimit) * 100).toInt()
    } else {
        0
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .padding(20.dp)
    ) {
        Column {
            // Balance y Expense con separador vertical
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BalanceItem(
                    label = stringResource(R.string.total_balance),
                    amount = totalBalance,
                    isPositive = true,
                    modifier = Modifier.weight(1f)
                        .padding(end = 24.dp)
                )

                // Separador vertical
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(60.dp)
                        .background(Honeydew)
                )

                BalanceItem(
                    label = stringResource(R.string.total_expense),
                    amount = totalExpense,
                    isPositive = false,
                    modifier = Modifier.weight(1f)
                        .padding(start = 24.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Barra de progreso (componente separado)
            ExpenseProgressBar(
                expensePercentage = expensePercentage,
                expenseLimit = expenseLimit
            )

            if (income != null && expense != null) {
                Spacer(modifier = Modifier.height(16.dp))

                IncomeExpenseCards(
                    income = income,
                    expense = expense
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))

            // Mensaje de estado (componente separado)
            ExpenseStatusMessage(percentage = expensePercentage)
        }
    }
}

