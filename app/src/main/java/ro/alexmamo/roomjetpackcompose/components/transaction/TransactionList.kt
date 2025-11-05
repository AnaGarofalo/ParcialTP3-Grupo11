package ro.alexmamo.roomjetpackcompose.components.transaction

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.MenuSwitchOnOff
import ro.alexmamo.roomjetpackcompose.components.walletcard.WalletSummaryCard
import ro.alexmamo.roomjetpackcompose.presentation.home.WalletViewModel
import ro.alexmamo.roomjetpackcompose.presentation.home.WalletViewModel.UiState
import ro.alexmamo.roomjetpackcompose.ui.theme.CaribbeanGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.Void

@Composable
fun TransactionList(
    title: String,
    showSeeAll: Boolean,
    showSummaryCard: Boolean = false,
    showPeriodSwitch: Boolean = false,
    periodOptions: List<String> = emptyList(),
    topPadding: Dp = 24.dp,
    topBar: (@Composable () -> Unit)? = null,
    walletViewModel: WalletViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        walletViewModel.get()
    }

    val uiState = walletViewModel.uiState.collectAsState().value
    var selectedPeriod by remember { mutableStateOf(2) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 5.dp, vertical = topPadding)
    ) {
        // tarjeta resumen opcional
        if (showSummaryCard) {
            WalletSummaryCard()
            Spacer(modifier = Modifier.height(20.dp))
        }

        // selector de período opcional
        if (showPeriodSwitch && periodOptions.isNotEmpty()) {
            MenuSwitchOnOff(
                options = periodOptions,
                selectedIndex = selectedPeriod,
                onOptionSelected = { selectedPeriod = it }
            )
        }

        // título + See all
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.secondary
            )
            if (showSeeAll) {
                Text(
                    text = stringResource(R.string.see_all),
                    style = MaterialTheme.typography.labelLarge,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        // render según estado
        when (uiState) {
            is UiState.Idle -> Text(stringResource(R.string.no_hay_datos_disponibles), color = Void)
            is UiState.Loading -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = CaribbeanGreen)
            }

            is UiState.Success -> {
                val transactions = uiState.wallet.transactions
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(
                        top = 0.dp,
                        bottom = 30.dp
                    )
                ) {
                    items(transactions) { tx ->
                        TransactionItem(data = tx)
                    }
                }
            }

            is UiState.Error -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(uiState.message, color = CaribbeanGreen)
            }
        }
    }
}
