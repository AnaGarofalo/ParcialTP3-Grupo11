package ro.alexmamo.roomjetpackcompose.presentation.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ro.alexmamo.roomjetpackcompose.presentation.layouts.BaseScreen
import ro.alexmamo.roomjetpackcompose.presentation.onboarding.components.OnboardingContent
import ro.alexmamo.roomjetpackcompose.presentation.onboarding.components.OnboardingHeader
import ro.alexmamo.roomjetpackcompose.presentation.onboarding.components.rememberOnboardingPages

@Composable
fun OnboardingScreen(
    onFinished: () -> Unit = {}
) {
    val pages = rememberOnboardingPages()

    val currentPageState = remember { mutableStateOf(0) }

    BaseScreen(
        centerContent = false,
        topBar = null,
        header = {
            val currentIndex = currentPageState.value
            val title = if (currentIndex in pages.indices) pages[currentIndex].title else ""
            OnboardingHeader(
                title = title,
                isFirstPage = currentIndex == 0
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.TopCenter
            ) {
                OnboardingContent(
                    pages = pages,
                    onNext = { if (it) onFinished() },
                    onPageChanged = { currentPageState.value = it }
                )
            }
        }
    )
}
