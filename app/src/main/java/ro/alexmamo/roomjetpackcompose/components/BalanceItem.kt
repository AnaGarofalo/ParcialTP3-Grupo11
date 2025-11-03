package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.ui.theme.Honeydew
import ro.alexmamo.roomjetpackcompose.ui.theme.VividBlue
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

@Composable
fun BalanceItem(
    label: String,
    amount: Double,
    isPositive: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = painterResource(
                    id = if (isPositive) R.drawable.income else R.drawable.expense
                ),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier.size(12.dp)
            )
            Text(
                text = label,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }

        // Formato con comas para miles
        val symbols = DecimalFormatSymbols(Locale.US).apply {
            groupingSeparator = ','
            decimalSeparator = '.'
        }
        val formatter = DecimalFormat("#,##0.00", symbols)
        val formattedAmount = formatter.format(kotlin.math.abs(amount))

        Text(
            text = "${if (isPositive) "" else "-"}\$$formattedAmount",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = if (isPositive) Honeydew else MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

