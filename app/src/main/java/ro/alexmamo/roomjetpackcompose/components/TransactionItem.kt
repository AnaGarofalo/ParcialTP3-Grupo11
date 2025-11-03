package ro.alexmamo.roomjetpackcompose.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.infraestructure.wallet.Transaction
import ro.alexmamo.roomjetpackcompose.ui.theme.CaribbeanGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.OceanBlue
import ro.alexmamo.roomjetpackcompose.ui.theme.VividBlue
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.text.NumberFormat

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
        // Contenedor principal
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // IZQUIERDA (icono + textos)
        Row(
            modifier = Modifier.weight(2.3f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Ícono del tipo
            ButtonCategoriesMenuPrimaryAndSecondary(
                iconRes = iconRes,
                selected = false,
                onClick = {}
            )

            Spacer(modifier = Modifier.width(14.dp))

            // Descripción y fecha
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = data.description,
                    color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2, // muestra una sola línea
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )
                Text(
                    text = formatDateToMonthDay(data.date),
                    color = VividBlue,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
            }
        }

        // DIVISOR 1 (LINEA VERDE)
        Spacer(modifier = Modifier.width(12.dp))
        VerticalGreenDivider(height = 36.dp)
        Spacer(modifier = Modifier.width(12.dp))

        // CENTRO (subtipo)
        Box(
            modifier = Modifier
                .weight(0.8f)
                .padding(horizontal = 2.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                // Formatear primera letra a mayúscula (porque lo trae en minuscula)
                text = data.subtype.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase() else it.toString()
                },
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.labelSmall
            )
        }

        // DIVISOR 2 (LINEA VERDE)
        Spacer(modifier = Modifier.width(12.dp))
        VerticalGreenDivider(height = 36.dp)
        Spacer(modifier = Modifier.width(12.dp))

        // DERECHA (monto)
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            // esto es para formatear el numero con comas y eso
            val numberFormat = NumberFormat.getNumberInstance(Locale("es", "AR"))
            val formattedAmount = "$${numberFormat.format(data.amount)}"
            val color = if (data.amount < 0) OceanBlue else MaterialTheme.colorScheme.secondary

            Text(
                text = formattedAmount,
                color = color,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun VerticalGreenDivider(height: Dp) {
    Box(
        modifier = Modifier
            .width(2.dp)
            .height(height)
            .background(CaribbeanGreen)
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun formatDateToMonthDay(dateString: String): String {
    return try {
        val date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        val formatter = DateTimeFormatter.ofPattern("MMMM d", Locale.ENGLISH)
        date.format(formatter) // → "October 15"
    } catch (e: Exception) {
        dateString // fallback si hay error
    }
}