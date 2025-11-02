package ro.alexmamo.roomjetpackcompose.presentation.account_balance

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.BottomNavigationBar
import ro.alexmamo.roomjetpackcompose.components.TransactionList
import ro.alexmamo.roomjetpackcompose.presentation.home.WalletViewModel
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen

@Composable
fun AccountBalanceScreen(
    navController: NavHostController,
    walletViewModel: WalletViewModel = viewModel()
) {
    // Llama solo una vez cuando entra a la pantalla
    LaunchedEffect(Unit) {
        walletViewModel.get()
    }

    BaseScreen(
        title = stringResource(R.string.account_balance),
        bottomBar = { BottomNavigationBar(navController = navController) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                // Lista de transacciones (usa los datos del ViewModel)
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
