package ro.alexmamo.roomjetpackcompose.presentation.account_balance

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.AccountBalanceHeader
import ro.alexmamo.roomjetpackcompose.components.AppTopBar
import ro.alexmamo.roomjetpackcompose.components.NotificationButton
import ro.alexmamo.roomjetpackcompose.components.TransactionList
import ro.alexmamo.roomjetpackcompose.components.ActionIconButton
import ro.alexmamo.roomjetpackcompose.presentation.home.WalletViewModel
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen
import ro.alexmamo.roomjetpackcompose.ui.theme.Honeydew

@Composable
fun AccountBalanceScreen(
    walletViewModel: WalletViewModel = viewModel(),
    onNavigateBack: () -> Unit = {},
    onNavigateToNotifications: () -> Unit = {}
) {
    LaunchedEffect(Unit) {
        walletViewModel.get()
    }

    BaseScreen(
        topBar = {
            AppTopBar (
                title = stringResource(R.string.account_balance),
                leftAction = {
                    ActionIconButton(
                        onActionIconButtonClick = { /* para atras */ },
                        withCircle = false,
                        content = { mod ->
                            androidx.compose.material.Icon(
                                painter = painterResource(id = R.drawable.arrow_left),
                                contentDescription = stringResource(id = R.string.navigate_back),
                                tint = Honeydew,
                                modifier = mod
                            )
                        }
                    )
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
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
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

