package ro.alexmamo.roomjetpackcompose.presentation.onboarding.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.presentation.onboarding.OnboardingPage

@Composable
fun rememberOnboardingPages(): List<OnboardingPage> {
    val titleA = stringResource(id = R.string.onboarding_title_a)
    val titleB = stringResource(id = R.string.onboarding_title_b)
    return remember(titleA, titleB) {
        listOf(
            OnboardingPage(
                title = titleA,
                imageRes = R.drawable.hand_coins
            ),
            OnboardingPage(
                title = titleB,
                imageRes = R.drawable.bank_card_mobile
            )
        )
    }
}
