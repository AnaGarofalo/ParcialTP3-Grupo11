package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import ro.alexmamo.roomjetpackcompose.ui.theme.CaribbeanGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.Dimens
import ro.alexmamo.roomjetpackcompose.ui.theme.Cyprus

@Composable
fun NotificationItem(
    iconRes: Int,
    titleRes: Int,
    messageRes: Int,
    timeRes: Int,
    chipMessageRes: Int? = null,
    modifier: Modifier = Modifier
) {
    val title = stringResource(id = titleRes)
    val message = stringResource(id = messageRes)
    val time = stringResource(id = timeRes)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = Dimens.paddingSmall),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(CaribbeanGreen),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                tint = Cyprus,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.width(Dimens.paddingMedium))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                ),
                color = MaterialTheme.colorScheme.onTertiary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = message,
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 14.sp),
                color = MaterialTheme.colorScheme.onTertiary,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            chipMessageRes?.let { resId ->
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = stringResource(id = resId),
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = MaterialTheme.colorScheme.surfaceBright,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = time,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onTertiaryContainer,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}
