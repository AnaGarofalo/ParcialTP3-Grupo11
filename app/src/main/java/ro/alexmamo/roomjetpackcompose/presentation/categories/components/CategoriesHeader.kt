package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ro.alexmamo.roomjetpackcompose.presentation.categories.components.CategoriesCard

@Composable
fun CategoriesHeader(
    totalBalance: Double,
    totalExpense: Double,
    expenseLimit: Double,
    income: Double,
    expense: Double,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        // Balance Card
        CategoriesCard(
            totalBalance = totalBalance,
            totalExpense = totalExpense,
            expenseLimit = expenseLimit,
            customPercentage = 30,
            modifier = Modifier,
            income = income,
            expense = expense
        )
    }
}


