package ro.alexmamo.roomjetpackcompose.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ro.alexmamo.roomjetpackcompose.components.BottomNavigationBar
import ro.alexmamo.roomjetpackcompose.components.HomeHeader
import ro.alexmamo.roomjetpackcompose.components.TransactionList
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    navController: NavHostController,
    onNavigateToNotifications: () -> Unit = {}
) {
    BaseScreen(
        bottomBar = { BottomNavigationBar(navController = navController) },
        header = {
            HomeHeader(
                totalBalance = 7783.00,
                totalExpense = 1187.40,
                expenseLimit = 20000.00,
                onNotificationClick = onNavigateToNotifications
            )
        },
        content = { paddingValues ->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .offset(y = (-20).dp) //
            ) {

                Spacer(modifier = Modifier.height(24.dp))

                TransactionList(
                    title = "", // Aca puede ir titulo o no
                    showSeeAll = false,
                    showSummaryCard = true,
                    showPeriodSwitch = true,
                    periodOptions = listOf( // Esto queda como String porque se puede cambiar segun lo que se quiera mostrar
                        "Daily",
                        "Weekly",
                        "Monthly"
                    ),
                    topPadding = 0.dp
                )
            }
        }
    )
}

