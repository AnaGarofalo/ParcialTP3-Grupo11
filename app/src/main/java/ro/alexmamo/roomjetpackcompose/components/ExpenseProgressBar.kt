package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.ui.theme.Honeydew
import ro.alexmamo.roomjetpackcompose.ui.theme.Void
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

@Composable
fun ExpenseProgressBar(
    expensePercentage: Int,
    expenseLimit: Double,
    modifier: Modifier = Modifier
) {
    // Formato con comas para miles
    val symbols = DecimalFormatSymbols(Locale.US).apply {
        groupingSeparator = ','
        decimalSeparator = '.'
    }
    val formatter = DecimalFormat("#,##0.00", symbols)
    val formattedLimit = formatter.format(expenseLimit)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(32.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Void)
    ) {
        // Barra de progreso blanca
        Box(
            modifier = Modifier
                .fillMaxWidth((1 - expensePercentage / 100f).coerceIn(0f, 1f))
                .fillMaxHeight()
                .align(Alignment.CenterEnd)
                .clip(RoundedCornerShape(20.dp))
                .background(Honeydew)
        )

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$expensePercentage%",
                fontSize = 14.sp,
                fontWeight = FontWeight.Thin,
                color = Honeydew
            )

            Text(
                text = "\$$formattedLimit",
                fontSize = 14.sp,
                fontWeight = FontWeight.Thin,
                fontStyle = FontStyle.Italic,
                color = Void
            )
        }
    }
}

