package ro.alexmamo.roomjetpackcompose.presentation.transaction

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.AppTopBar
import ro.alexmamo.roomjetpackcompose.components.BottomNavigationBar
import ro.alexmamo.roomjetpackcompose.components.NotificationButton
import ro.alexmamo.roomjetpackcompose.components.OnBackNavigationButton
import ro.alexmamo.roomjetpackcompose.components.transaction.TransactionList
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen
import ro.alexmamo.roomjetpackcompose.presentation.transaction.components.TransactionHeader

@Composable
fun TransactionScreen(
    navController: NavHostController,
    onNavigateBack: () -> Unit = {},
    onNavigateToNotifications: () -> Unit = {},
) {
    BaseScreen(
        topBar = {
            AppTopBar(
                title = stringResource(R.string.transactions),
                leftAction = {
                    OnBackNavigationButton(onNavigateBack)
                },
                rightAction = {
                    NotificationButton(onNavigateToNotifications)
                }
            )
        },
        header = {
            TransactionHeader(
                totalBalance = 7783.00,
                totalExpense = 1187.40,
                expenseLimit = 20000.00,
            )
        },
        bottomBar = { BottomNavigationBar(navController = navController) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = 8.dp,
                        start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
                        end = paddingValues.calculateEndPadding(LayoutDirection.Ltr),
                        bottom = 56.dp
                    )
            ) {

                // Lista de transacciones (usa los datos del ViewModel)
                TransactionList(
                    title = stringResource(R.string.october),
                    showSeeAll = false,
                    showSummaryCard = false,
                    topPadding = 0.dp
                )
            }
        }
    )
}
