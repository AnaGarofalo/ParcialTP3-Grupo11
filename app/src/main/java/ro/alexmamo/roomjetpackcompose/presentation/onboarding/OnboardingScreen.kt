package ro.alexmamo.roomjetpackcompose.presentation.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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

    BaseScreen(
        centerContent = true,
        topBar = null,
        header = {
            // Title lives in the green/top area (outside the rounded white card)
            Text(
                text = pages.getOrNull(0)?.title ?: "",
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp,
                lineHeight = 39.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.paddingLarge)
            )
        },
        content = { _ ->
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                OnboardingSlider(
                    pages = pages,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Dimens.paddingLarge)
                ) { isLastPage ->
                    if (isLastPage) onFinished() else Unit
                }
            }
        }
    )
}

data class OnboardingPage(
    val title: String,
    val imageRes: Int
)
