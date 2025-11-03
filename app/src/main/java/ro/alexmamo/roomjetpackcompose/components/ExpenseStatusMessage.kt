package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.ui.theme.Void

@Composable
fun ExpenseStatusMessage(
    percentage: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(start = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.check),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.size(14.dp)
        )
        Text(
            text = stringResource(R.string.expense_percentage, percentage),
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}

