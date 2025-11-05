package ro.alexmamo.roomjetpackcompose.components.transaction

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.components.ButtonCategoriesMenuPrimaryAndSecondary
import ro.alexmamo.roomjetpackcompose.infraestructure.wallet.Transaction
import ro.alexmamo.roomjetpackcompose.ui.theme.VividBlue
import ro.alexmamo.roomjetpackcompose.ui.theme.OceanBlue
import java.text.NumberFormat
import java.util.*

@Composable
fun RowScope.TransactionItemLeftSection(data: Transaction, iconRes: Int) {
    Row(
        modifier = Modifier.weight(2.3f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ButtonCategoriesMenuPrimaryAndSecondary(
            iconRes = iconRes,
            selected = false,
            onClick = {  }
        )

        Spacer(modifier = Modifier.width(14.dp))

        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = data.description,
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                style = MaterialTheme.typography.labelMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
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
}

@Composable
fun RowScope.TransactionItemCenterSection(data: Transaction) {
    Row(
        modifier = Modifier
            .weight(0.8f)
            .padding(horizontal = 2.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = data.subtype.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase() else it.toString()
            },
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Composable
fun RowScope.TransactionItemRightSection(data: Transaction) {
    Row(
        modifier = Modifier
            .weight(1f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        val numberFormat = NumberFormat.getNumberInstance(Locale("es", "AR"))
        val formattedAmount = "$${numberFormat.format(data.amount)}"
        val color = if (data.amount < 0) OceanBlue else MaterialTheme.colorScheme.secondary

        Text(
            text = formattedAmount,
            color = color,
            style = MaterialTheme.typography.labelMedium
        )
    }
}