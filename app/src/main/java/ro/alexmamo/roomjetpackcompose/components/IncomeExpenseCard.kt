package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.ui.theme.Honeydew
import ro.alexmamo.roomjetpackcompose.ui.theme.Void
import java.util.Locale

@Composable
fun IncomeExpenseCard(
    title: String,
    amount: Double,
    icon: Int,
    iconColor: Color,
    amountColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(171.dp)
            .height(101.dp)
            .clip(RoundedCornerShape(14.89.dp))
            .background(Honeydew),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            // Ícono
            Icon(
                painter = painterResource(id = icon),
                contentDescription = title,
                tint = iconColor,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Título
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Void
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Monto
            val formattedAmount = String.format(Locale.US, "%,.2f", amount)

            Text(
                text = "$$formattedAmount",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = amountColor
            )
        }
    }
}

