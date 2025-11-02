package ro.alexmamo.roomjetpackcompose.presentation.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen
import ro.alexmamo.roomjetpackcompose.presentation.onboarding.components.OnboardingSlider
import ro.alexmamo.roomjetpackcompose.ui.theme.Dimens

@Composable
fun OnboardingScreen(
    onFinished: () -> Unit = {}
) {
    val pages = listOf(
        OnboardingPage(
            title = stringResource(id = R.string.onboarding_title_a),
            imageRes = R.drawable.hand_coins
        ),
        OnboardingPage(
            title = stringResource(id = R.string.onboarding_title_b),
            imageRes = R.drawable.bank_card_mobile
        )
    )

    val currentPageState = remember { mutableStateOf(0) }

    BaseScreen(
        centerContent = false,
        topBar = null,
        header = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = Dimens.paddingLarge * 3.5f, bottom = 80.dp), // aumentar espacio abajo del header
                contentAlignment = Alignment.TopCenter
            ) {
                Box(
                    modifier = Modifier
                        .size(width = 289.dp, height = 122.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = pages.getOrNull(currentPageState.value)?.title ?: "",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 30.sp,
                        lineHeight = 39.sp,
                        letterSpacing = 0.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.inverseSurface,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = Dimens.paddingLarge)
                    )
                }
            }
        },
        content = { paddingValues ->
            // Usar paddingValues que pasa BaseScreen (status bar top) y limitar la altura del area blanca
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.TopCenter
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(460.dp) // aumentar la altura del content blanco para alojar la imagen grande y texto
                        .padding(horizontal = Dimens.paddingLarge),
                    contentAlignment = Alignment.Center
                ) {
                    OnboardingSlider(
                        pages = pages,
                        modifier = Modifier.fillMaxWidth(),
                        onNext = { if (it) onFinished() },
                        onPageChanged = { currentPageState.value = it }
                    )
                }
            }
        }
    )
}

data class OnboardingPage(
    val title: String,
    val imageRes: Int
)
