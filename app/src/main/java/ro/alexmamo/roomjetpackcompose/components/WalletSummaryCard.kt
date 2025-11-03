package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import ro.alexmamo.roomjetpackcompose.ui.theme.CaribbeanGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.OceanBlue
import ro.alexmamo.roomjetpackcompose.ui.theme.Void

@Composable
fun WalletSummaryCard(
    modifier: Modifier = Modifier
) {
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
            // IZQUIERDA: icono dentro de pastilla + título debajo
            Column(
                modifier = Modifier
                    .weight(0.6f)
                    .wrapContentHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(68.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(CaribbeanGreen),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.car),
                        contentDescription = "Savings",
                        tint = Void,
                        modifier = Modifier
                            .height(22.dp)
                            .width(38.dp)
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Savings \nOn Goals",
                    color = Void,
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 12.sp,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // DIVISOR VERTICAL ENTRE IZQUIERDA Y CONTENIDO
            Box(
                modifier = Modifier
                    .width(2.dp)
                    .height(108.dp)
                    .background(Color.White)
            )

            Spacer(modifier = Modifier.width(16.dp))

            // DERECHA: UNA SOLA COLUMNA
            Column(
                modifier = Modifier
                    .weight(1f),

                verticalArrangement = Arrangement.Center
            ) {
                // FILA SUPERIOR: REVENUE

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // icono a la izquierda
                    Icon(
                        painter = painterResource(id = R.drawable.salary),
                        contentDescription = "Revenue",
                        tint = Color.Black,
                        modifier = Modifier
                            .width(31.dp)
                            .height(28.dp)
                            .padding(end = 8.dp)
                    )

                    // texto y monto a la derecha del ícono
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(R.string.revenue_last_week),
                            color = Color.Black,
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = stringResource(R.string._4_000_00),
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // SEPARADOR HORIZONTAL
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(Color.White)

                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // icono a la izquierda
                    Icon(
                        painter = painterResource(id = R.drawable.food),
                        contentDescription = "Revenue",
                        tint = Color.Black,
                        modifier = Modifier
                            .width(31.dp)
                            .height(28.dp)
                            .padding(end = 8.dp)
                    )

                    // texto y monto a la derecha del ícono
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(R.string.food_last_week),
                            color = Void,
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = stringResource(R.string._100_00),
                            color = OceanBlue,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }

            }
        }
    }
}
