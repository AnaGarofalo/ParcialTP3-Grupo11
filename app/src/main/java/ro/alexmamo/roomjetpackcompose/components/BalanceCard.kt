package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.R
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

@Composable
fun BalanceCard(
    totalBalance: Double,
    totalExpense: Double,
    expenseLimit: Double,
    modifier: Modifier = Modifier,
    customPercentage: Int? = null // Para forzar un porcentaje específico (como en el diseño: 30%)
) {
    val expensePercentage = customPercentage ?: if (expenseLimit > 0) {
        ((totalExpense / expenseLimit) * 100).toInt()
    } else {
        0
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .padding(20.dp)
    ) {
        Column {
            // Balance y Expense con separador vertical
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BalanceItem(
                    label = stringResource(R.string.total_balance),
                    amount = totalBalance,
                    isPositive = true,
                    modifier = Modifier.weight(1f)
                )

                // Separador vertical (línea divisoria)
                androidx.compose.foundation.layout.Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(60.dp)
                        .background(Color.White.copy(alpha = 0.3f))
                )

                BalanceItem(
                    label = stringResource(R.string.total_expense),
                    amount = totalExpense,
                    isPositive = false,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Barra de progreso
            Column {
                LinearProgressIndicator(
                    progress = { (expensePercentage / 100f).coerceIn(0f, 1f) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp),
                    color = Color(0xFF1A1A2E), // Azul oscuro/negro para el progreso
                    trackColor = Color.White, // Blanco para el fondo
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
                        color = Color.White
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
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Mensaje de porcentaje con ícono
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.check),
                    contentDescription = null,
                    tint = Color.Black, // NEGRO para verse en fondo verde claro
                    modifier = Modifier.size(14.dp)
                )
                Text(
                    text = stringResource(R.string.expense_percentage, expensePercentage),
                    fontSize = 12.sp,
                    color = Color.Black // NEGRO para verse en fondo verde claro
                )
            }
        }
    }
}

@Composable
private fun BalanceItem(
    label: String,
    amount: Double,
    isPositive: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = painterResource(
                    id = if (isPositive) R.drawable.arrow_up else R.drawable.arrow_down
                ),
                contentDescription = null,
                tint = Color.White.copy(alpha = 0.8f),
                modifier = Modifier.size(12.dp)
            )
            Text(
                text = label,
                fontSize = 12.sp,
                color = Color.White.copy(alpha = 0.8f)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))

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
            color = if (isPositive) Color.White else Color(0xFF4A90E2)
        )
    }
}

