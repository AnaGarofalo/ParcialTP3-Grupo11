package ro.alexmamo.roomjetpackcompose.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ro.alexmamo.roomjetpackcompose.infraestructure.wallet.Transaction

@Composable
fun HomeScreen(viewModel: WalletViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.get()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        when (uiState) {
            is WalletViewModel.UiState.Idle -> Text("Esperando acción…")

            is WalletViewModel.UiState.Loading -> Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }

            is WalletViewModel.UiState.Success -> {
                val wallet = (uiState as WalletViewModel.UiState.Success).wallet

                Text(text = "💰 Balance: ${wallet.balance}")
                Text(text = "Ingresos: ${wallet.income}")
                Text(text = "Gastos: ${wallet.expense}")

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Transacciones"
                )

                Spacer(modifier = Modifier.height(8.dp))

                LazyColumn {
                    items(wallet.transactions) { tx ->
                        TransactionRow(tx)
                    }
                }
            }

            is WalletViewModel.UiState.Error -> Text(
                text = "Error: ${(uiState as WalletViewModel.UiState.Error).message}"
            )
        }
    }
}

@Composable
fun TransactionRow(tx: Transaction) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text("📄 ${tx.description}")
        Text("Fecha: ${tx.date}")
        Text("Monto: ${tx.amount} ${tx.currency}")
        Text("Tipo: ${tx.type} - ${tx.subtype}")
        Divider(modifier = Modifier.padding(top = 8.dp))
    }
}