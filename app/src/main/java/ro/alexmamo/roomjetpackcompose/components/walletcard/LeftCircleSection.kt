package ro.alexmamo.roomjetpackcompose.components.walletcard

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.ui.theme.Honeydew
import ro.alexmamo.roomjetpackcompose.ui.theme.OceanBlue
import ro.alexmamo.roomjetpackcompose.ui.theme.Void

@Composable
fun LeftCircleSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier.size(70.dp),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawArc(
                    color = Honeydew,
                    startAngle = 0f,
                    sweepAngle = 360f,
                    useCenter = false,
                    style = Stroke(width = 3.dp.toPx(), cap = StrokeCap.Round)
                )
                drawArc(
                    color = OceanBlue,
                    startAngle = -90f,
                    sweepAngle = 180f,
                    useCenter = false,
                    style = Stroke(width = 5.dp.toPx(), cap = StrokeCap.Round)
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.car),
                contentDescription = "",
                tint = Void,
                modifier = Modifier.size(40.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.savings_on_goals),
            color = Void,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.labelMedium,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}