package ro.alexmamo.roomjetpackcompose.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material3.Text
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
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = stringResource(R.string.hi_welcome_back),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = stringResource(R.string.good_morning),
                            fontSize = 14.sp,
                            color = Color.Black.copy(alpha = 0.6f)
                        )
                    }

                    // Campanita de notificaciones
                    ActionIconButton(
                        onActionIconButtonClick = { /* TODO: Navigate to notifications */ },
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

                Spacer(modifier = Modifier.height(16.dp))

                // Balance Card
                BalanceCard(
                    totalBalance = 7783.00,
                    totalExpense = 1187.40,
                    expenseLimit = 20000.00,
                    customPercentage = 30,
                    modifier = Modifier
                )
            }
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
