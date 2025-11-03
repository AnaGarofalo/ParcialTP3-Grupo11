package ro.alexmamo.roomjetpackcompose.presentation.onboarding.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.presentation.onboarding.OnboardingPage
import ro.alexmamo.roomjetpackcompose.ui.theme.Dimens

@Composable
fun OnboardingContent(
    pages: List<OnboardingPage>,
    modifier: Modifier = Modifier,
    onNext: (Boolean) -> Unit,
    onPageChanged: (Int) -> Unit,
) {
    Box(
        modifier = modifier.fillMaxSize(),
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
                onNext = onNext,
                onPageChanged = onPageChanged
            )
        }
    }
}

