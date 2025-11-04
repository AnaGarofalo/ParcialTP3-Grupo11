package ro.alexmamo.roomjetpackcompose.presentation.password_changed.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.ui.theme.LightGreen

enum class StepState {
    ONE_DOT, TWO_DOTS, THREE_DOTS, CHECK
}

@Composable
fun StepCircle(state: StepState) {
    val scale by animateFloatAsState(
        targetValue = if (state == StepState.CHECK) 1.2f else 1f,
        animationSpec = tween(300)
    )

    Box(
        modifier = Modifier
            .size(150.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .padding(4.dp),
        contentAlignment = Alignment.Center
    ) {
        AnimatedContent(
            targetState = state,
            transitionSpec = {
                fadeIn(tween(550)) togetherWith fadeOut(tween(550))
            }
        ) { step ->
            when (step) {
                StepState.ONE_DOT -> StepCircleIcon(R.drawable.step_1)
                StepState.TWO_DOTS -> StepCircleIcon(R.drawable.step_2)
                StepState.THREE_DOTS -> StepCircleIcon(R.drawable.step_3)
                StepState.CHECK -> StepCircleIcon(R.drawable.step_success)
            }
        }
    }
}