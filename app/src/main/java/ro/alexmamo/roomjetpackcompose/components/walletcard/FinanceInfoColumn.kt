package ro.alexmamo.roomjetpackcompose.components.walletcard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.ui.theme.Honeydew
import ro.alexmamo.roomjetpackcompose.ui.theme.OceanBlue
import ro.alexmamo.roomjetpackcompose.ui.theme.Void

@Composable
// Esto es la parte que tiene el revenue y el food last week
fun FinanceInfoColumn(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        FinanceRow(
            iconRes = R.drawable.salary,
            title = stringResource(R.string.revenue_last_week),
            amount = stringResource(R.string._4_000_00),
            titleColor = Void,
            amountColor = Void
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Honeydew)
        )

        Spacer(modifier = Modifier.height(8.dp))

        FinanceRow(
            iconRes = R.drawable.food,
            title = stringResource(R.string.food_last_week),
            amount = stringResource(R.string._100_00),
            titleColor = Void,
            amountColor = OceanBlue
        )
    }
}