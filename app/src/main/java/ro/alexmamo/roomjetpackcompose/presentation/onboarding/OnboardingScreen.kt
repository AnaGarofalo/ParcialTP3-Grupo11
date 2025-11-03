package ro.alexmamo.roomjetpackcompose.presentation.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen
import ro.alexmamo.roomjetpackcompose.presentation.onboarding.components.OnboardingSlider
import ro.alexmamo.roomjetpackcompose.ui.theme.Dimens
import ro.alexmamo.roomjetpackcompose.ui.theme.Poppins

@Composable
fun OnboardingScreen(
    onFinished: () -> Unit = {}
) {
    val titleA = stringResource(id = R.string.onboarding_title_a)
    val titleB = stringResource(id = R.string.onboarding_title_b)

    val pages = listOf(
        OnboardingPage(
            title = titleA,
            imageRes = R.drawable.hand_coins
        ),
        OnboardingPage(
            title = titleB,
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
                    .padding(top = Dimens.paddingLarge * 3.5f, bottom = 80.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Box(
                    modifier = Modifier
                        .size(width = 289.dp, height = 122.dp),
                    contentAlignment = Alignment.Center
                ) {
                    val currentIndex = currentPageState.value
                    Text(
                        text = pages.getOrNull(currentIndex)?.title ?: "",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontFamily = Poppins,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 30.sp,
                            lineHeight = 39.sp,
                            letterSpacing = 0.sp
                        ),
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.inverseSurface,
                        maxLines = if (currentIndex == 0) 2 else 3,
                        overflow = TextOverflow.Clip,
                        softWrap = true,
                        modifier = Modifier
                            .width(320.dp)
                            .padding(horizontal = 0.dp)
                    )
                }
            }
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.TopCenter
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(460.dp)
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
