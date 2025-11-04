package ro.alexmamo.roomjetpackcompose.presentation.account_balance

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.BottomNavigationBar
import ro.alexmamo.roomjetpackcompose.components.AccountBalanceHeader
import ro.alexmamo.roomjetpackcompose.components.AppTopBar
import ro.alexmamo.roomjetpackcompose.components.NotificationButton
import ro.alexmamo.roomjetpackcompose.components.TransactionList
import ro.alexmamo.roomjetpackcompose.components.OnBackNavigationButton
import ro.alexmamo.roomjetpackcompose.presentation.home.WalletViewModel
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen

@Composable
fun AccountBalanceScreen(
    navController: NavHostController,
    walletViewModel: WalletViewModel = viewModel(),
    onNavigateBack: () -> Unit = {},
    onNavigateToNotifications: () -> Unit = {}
) {
    LaunchedEffect(Unit) {
        walletViewModel.get()
    }

    BaseScreen(
        topBar = {
            AppTopBar(
                title = stringResource(R.string.account_balance),
                leftAction = {
                    OnBackNavigationButton(onNavigateBack)
                },
                rightAction = {
                    NotificationButton(onNavigateToNotifications)
                }
            )
        },
        header = {
            AccountBalanceHeader(
                totalBalance = 7783.00,
                totalExpense = 1187.40,
                expenseLimit = 20000.00,
                income = 4000.00,
                expense = 1187.40
            )
        },
        bottomBar = { BottomNavigationBar(navController = navController) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = 8.dp, // más arriba la lista
                        start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
                        end = paddingValues.calculateEndPadding(LayoutDirection.Ltr),
                        bottom = 56.dp
                    )
            ) {
                // Lista de transacciones
                TransactionList(
                    title = stringResource(R.string.transactions),
                    showSeeAll = true,
                    showSummaryCard = false,
                    walletViewModel = walletViewModel,
                    topPadding = 0.dp
                )
            }
        }
    )
}

