package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
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
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

@Composable
fun IncomeExpenseCards(
    income: Double,
    expense: Double,
    incomeIcon: Int,
    expenseIcon: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Income Card
        IncomeExpenseCard(
            title = "Income",
            amount = income,
            icon = incomeIcon,
            iconColor = Color(0xFF00C9A7), // Verde para el ícono
            amountColor = Color.Black, // Negro para que se vea en fondo blanco
            modifier = Modifier.weight(1f)
        )

        // Expense Card
        IncomeExpenseCard(
            title = "Expense",
            amount = expense,
            icon = expenseIcon,
            iconColor = Color(0xFF4A90E2), // Azul para el ícono
            amountColor = Color(0xFF4A90E2), // Azul para el monto
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun IncomeExpenseCard(
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
            .background(Color.White),
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
            androidx.compose.material3.Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Monto - SIMPLIFICADO para que se vea
            val formattedAmount = String.format(Locale.US, "%,.2f", amount)

            androidx.compose.material3.Text(
                text = "$$formattedAmount",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = amountColor
            )
        }
    }
}

