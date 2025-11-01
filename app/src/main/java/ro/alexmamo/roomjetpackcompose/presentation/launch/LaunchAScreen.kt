package ro.alexmamo.roomjetpackcompose.presentation.launch

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.ui.theme.CaribbeanGreen
import ro.alexmamo.roomjetpackcompose.ui.theme.Dimens
import ro.alexmamo.roomjetpackcompose.ui.theme.Cyprus
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.ui.theme.Honeydew

@Composable
fun LaunchAScreen(
    onFinished: () -> Unit = {}
) {
    // animación de tint para el logo (flecha) — de background -> CaribbeanGreen -> background (loop)
    val transition = rememberInfiniteTransition()
    // animamos el tint de la flecha: desde el fondo (CaribbeanGreen) hasta el color final (Cyprus)
    val color by transition.animateColor(
        initialValue = CaribbeanGreen,
        targetValue = Cyprus,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    // Layout independiente: full-bleed background y contenido centrado
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(CaribbeanGreen)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(Dimens.paddingLarge),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // logo (vector) tintado con la animación de color usando Image + ColorFilter
            Image(
                painter = painterResource(id = R.drawable.launch_1),
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .size(120.dp)
                    .scale(1f),
                colorFilter = ColorFilter.tint(color)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.finwise),
                fontSize = 52.sp,
                fontWeight = FontWeight.SemiBold,
                color = Honeydew
            )
        }
    }

    // cuando la animación haya corrido un ciclo, avanzamos a la siguiente pantalla
    LaunchedEffect(Unit) {
        // esperar 1400ms para que la animación de tint corra y luego continuar
        delay(3400)
        onFinished()
    }
}
