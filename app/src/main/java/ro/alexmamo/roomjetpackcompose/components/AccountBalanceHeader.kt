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
import ro.alexmamo.roomjetpackcompose.ui.theme.Void

@Composable
fun AccountBalanceHeader(
    totalBalance: Double,
    totalExpense: Double,
    expenseLimit: Double,
    income: Double,
    expense: Double,
    incomeIcon: Int,
    expenseIcon: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        // Balance Card
        BalanceCard(
            totalBalance = totalBalance,
            totalExpense = totalExpense,
            expenseLimit = expenseLimit,
            customPercentage = 30,
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Income y Expense Cards
        IncomeExpenseCards(
            income = income,
            expense = expense,
            incomeIcon = incomeIcon,
            expenseIcon = expenseIcon,
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(16.dp))

        }
    }


