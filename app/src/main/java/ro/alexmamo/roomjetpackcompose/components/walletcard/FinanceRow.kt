package ro.alexmamo.roomjetpackcompose.components.walletcard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.ui.theme.Void

@Composable
fun FinanceRow(
    iconRes: Int,
    title: String,
    amount: String,
    titleColor: Color,
    amountColor: Color
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = title,
            tint = Void,
            modifier = Modifier
                .width(31.dp)
                .height(28.dp)
                .padding(end = 8.dp)
        )

        Column {
            Text(
                text = title,
                color = titleColor,
                style = MaterialTheme.typography.labelMedium.copy(fontSize = 12.sp),
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = amount,
                color = amountColor,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 17.sp)
            )
        }
    }
}