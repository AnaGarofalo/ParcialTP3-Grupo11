package ro.alexmamo.roomjetpackcompose.components.transaction

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.infraestructure.wallet.Transaction

@Composable
fun TransactionItem(data: Transaction) {
    val iconRes = when (data.subtype.lowercase()) {
        "food" -> R.drawable.food
        "clothes" -> R.drawable.clothes
        "services" -> R.drawable.dollar
        "savings" -> R.drawable.savings
        else -> R.drawable.transactions
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // IZQUIERDA (ícono + descripción + fecha)
        TransactionItemLeftSection(data, iconRes)

        // DIVISOR 1
        Spacer(modifier = Modifier.width(12.dp))
        VerticalGreenDivider(height = 36.dp)
        Spacer(modifier = Modifier.width(12.dp))

        // CENTRO (subtipo)
        TransactionItemCenterSection(data)

        // DIVISOR 2
        Spacer(modifier = Modifier.width(12.dp))
        VerticalGreenDivider(height = 36.dp)
        Spacer(modifier = Modifier.width(12.dp))

        // DERECHA (monto)
        TransactionItemRightSection(data)
    }
}