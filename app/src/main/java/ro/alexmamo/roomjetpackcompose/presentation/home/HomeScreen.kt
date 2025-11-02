package ro.alexmamo.roomjetpackcompose.presentation.home

import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ro.alexmamo.roomjetpackcompose.components.HomeHeader
import ro.alexmamo.roomjetpackcompose.components.TransactionList
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen

@Composable
fun HomeScreen(
    walletViewModel: WalletViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        walletViewModel.get()
    }

    BaseScreen(
        header = {
            HomeHeader(
                totalBalance = 7783.00,
                totalExpense = 1187.40,
                expenseLimit = 20000.00,
                onNotificationClick = { /* TODO: Navigate to notifications */ }
            )
        },
        content = { paddingValues ->
            TransactionList(
                title = "",
                showSeeAll = false,
                showSummaryCard = true,
                showPeriodSwitch = true,
                periodOptions = listOf("Daily", "Weekly", "Monthly"),
                walletViewModel = walletViewModel,
                topPadding = 0.dp
            )
        }
    )
}

