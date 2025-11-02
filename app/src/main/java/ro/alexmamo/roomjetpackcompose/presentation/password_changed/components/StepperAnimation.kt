package ro.alexmamo.roomjetpackcompose.presentation.password_changed.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun StepperAnimation() {
    var step by remember { mutableStateOf(StepState.ONE_DOT) }

    LaunchedEffect(Unit) {
        val sequence = listOf(
            StepState.ONE_DOT,
            StepState.TWO_DOTS,
            StepState.THREE_DOTS,
            StepState.CHECK
        )

        for (s in sequence) {
            step = s
            delay(800) // ajustá el tiempo entre pasos si querés
        }
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 32.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StepCircle(
            state = when (step) {
                StepState.ONE_DOT, StepState.TWO_DOTS, StepState.THREE_DOTS, StepState.CHECK -> step
            }
        )
    }
}
