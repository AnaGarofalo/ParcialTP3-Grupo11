package ro.alexmamo.roomjetpackcompose.presentation.account_balance

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.ActionIconButton
import ro.alexmamo.roomjetpackcompose.components.BalanceCard
import ro.alexmamo.roomjetpackcompose.components.IncomeExpenseCards
import ro.alexmamo.roomjetpackcompose.presentation.home.WalletViewModel
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen
import ro.alexmamo.roomjetpackcompose.components.TransactionList

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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Botón atrás
                ActionIconButton(
                    onActionIconButtonClick = onNavigateBack,
                    withCircle = false,
                    content = { mod ->
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_left),
                            contentDescription = "Back",
                            tint = Color.White,
                            modifier = mod
                        )
                    }
                )

                // Título con tamaño según imagen 10
                androidx.compose.material3.Text(
                    text = stringResource(R.string.account_balance),
                    fontSize = 22.sp, // Según imagen 10 (Hug 22px)
                    fontWeight = FontWeight.Bold,
                    color = Color.Black // NEGRO como en la imagen 11
                )

                // Campanita de notificaciones
                ActionIconButton(
                    onActionIconButtonClick = onNavigateToNotifications,
                    withCircle = true,
                    circleSize = 36.dp,
                    circleColor = Color.White,
                    content = { mod ->
                        Icon(
                            painter = painterResource(id = R.drawable.notification),
                            contentDescription = "Notifications",
                            tint = Color(0xFF00C9A7),
                            modifier = mod
                        )
                    }
                )
            }
        },
        header = {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                // Balance Card
                BalanceCard(
                    totalBalance = 7783.00,
                    totalExpense = 1187.40,
                    expenseLimit = 20000.00,
                    customPercentage = 30,
                    modifier = Modifier
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Income y Expense Cards
                IncomeExpenseCards(
                    income = 4000.00,
                    expense = 1187.40,
                    incomeIcon = R.drawable.income,
                    expenseIcon = R.drawable.expense,
                    modifier = Modifier
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Mensaje de porcentaje con ícono (como en imagen 11)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.check),
                        contentDescription = null,
                        tint = Color.Black, // Negro para verse en fondo verde claro
                        modifier = Modifier.size(16.dp)
                    )
                    androidx.compose.material3.Text(
                        text = stringResource(R.string.expense_percentage, 30),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black // Negro para verse bien
                    )
                }
            }
        },
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
