package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.ui.theme.DarkGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.Honeydew
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

@Composable
fun ExpenseProgressBar(
    expensePercentage: Int,
    expenseLimit: Double,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        LinearProgressIndicator(
            progress = { (expensePercentage / 100f).coerceIn(0f, 1f) },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp),
            color = DarkGreen,
            trackColor = Honeydew,
        )

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$expensePercentage%",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Honeydew
            )

            // Formato con comas para miles
            val symbols = DecimalFormatSymbols(Locale.US).apply {
                groupingSeparator = ','
                decimalSeparator = '.'
            }
            val formatter = DecimalFormat("#,##0.00", symbols)
            val formattedLimit = formatter.format(expenseLimit)

            Text(
                text = "\$$formattedLimit",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Honeydew
            )
        }
    }
}

