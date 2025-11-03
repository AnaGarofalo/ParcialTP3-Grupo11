package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.ui.theme.CaribbeanGreen

@Composable
fun WalletSummaryCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .widthIn(max = 357.dp)
            .clip(RoundedCornerShape(31.dp))
            .background(CaribbeanGreen)
            .height(152.dp)
            .padding(horizontal = 22.dp, vertical = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LeftCircleSection(
                modifier = Modifier.weight(0.6f)
            )

            Spacer(modifier = Modifier.width(16.dp))
            VerticalDividerWhite(height = 108.dp)
            Spacer(modifier = Modifier.width(16.dp))

            FinanceInfoColumn(
                modifier = Modifier.weight(1f)
            )
        }
    }
}
