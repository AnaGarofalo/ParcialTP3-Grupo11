package ro.alexmamo.roomjetpackcompose.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.BottomNavigationBar
import ro.alexmamo.roomjetpackcompose.components.TransactionList
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen

@Composable
fun HomeScreen(
    walletViewModel: WalletViewModel = viewModel()
) {

    LaunchedEffect(Unit) {
        walletViewModel.get()
    }


    var selectedPeriod by remember { mutableStateOf(2) } // 0=Daily, 1=Weekly, 2=Monthly

    BaseScreen(
        title = stringResource(R.string.hi_welcome_back),
        bottomBar = { BottomNavigationBar() },
        content = { paddingValues ->
            Column(
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
                    periodOptions = listOf("Daily", "Weekly", "Monthly"), // Aca poner lo qu uno quiera mostrar
                    walletViewModel = walletViewModel,
                    topPadding = 0.dp
                )
            }
        }
    )
}
