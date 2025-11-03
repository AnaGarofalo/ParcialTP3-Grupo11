package ro.alexmamo.roomjetpackcompose.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.BorderStroke
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ro.alexmamo.roomjetpackcompose.presentation.onboarding.OnboardingPage as PageAlias
import ro.alexmamo.roomjetpackcompose.ui.theme.Dimens
import ro.alexmamo.roomjetpackcompose.ui.theme.LightGreen

@Composable
fun OnboardingSlider(
    pages: List<PageAlias>,
    modifier: Modifier = Modifier,
    onNext: (isLastPage: Boolean) -> Unit = {},
    onPageChanged: (index: Int) -> Unit = {}
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var currentPage by remember { mutableStateOf(0) }
    val finishJob = remember { mutableStateOf<Job?>(null) }
    val autoFinishDelay = 1500L // ms

    LaunchedEffect(listState) {
        var lastIndex = listState.firstVisibleItemIndex
        while (true) {
            val index = listState.firstVisibleItemIndex
            if (index != lastIndex) {
                lastIndex = index
                currentPage = index
                onPageChanged(index)
                if (index == pages.lastIndex) {
                    finishJob.value?.cancel()
                    finishJob.value = coroutineScope.launch {
                        delay(autoFinishDelay)
                        onNext(true)
                    }
                } else {
                    finishJob.value?.cancel()
                }
            }
            delay(100)
        }
    }
    val circleSize = 185.dp
    val imageSize = 287.dp

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(imageSize + 56.dp),
            contentAlignment = Alignment.Center
        ) {
            LazyRow(
                state = listState,
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                items(pages) { page ->
                    Box(
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .wrapContentSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(circleSize)
                                    .clip(CircleShape)
                                    .background(LightGreen),
                                contentAlignment = Alignment.Center
                            ) {}
                            Image(
                                painter = painterResource(id = page.imageRes),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .size(imageSize)
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(Dimens.paddingMedium))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Next",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.inverseSurface,
                modifier = Modifier.clickable {
                    coroutineScope.launch {
                        val next = (currentPage + 1).coerceAtMost(pages.lastIndex)
                        listState.animateScrollToItem(next)
                        if (next == pages.lastIndex) {
                            finishJob.value?.cancel()
                            finishJob.value = coroutineScope.launch {
                                delay(autoFinishDelay)
                                onNext(true)
                            }
                        } else {
                            onNext(false)
                        }
                    }
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                pages.forEachIndexed { index, _ ->
                    val isSelected = index == currentPage
                    if (isSelected) {
                        // Selected: filled dot with onSurface
                        Box(
                            modifier = Modifier
                                .padding(6.dp)
                                .size(13.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.onSurface)
                        ) {}
                    } else {
                        // Unselected: ring (border) with inverseSurface and inner fill surface
                        Box(
                            modifier = Modifier
                                .padding(6.dp)
                                .size(12.dp)
                                .clip(CircleShape)
                                .border(BorderStroke(1.dp, MaterialTheme.colorScheme.inverseSurface), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colorScheme.surface)
                            ) {}
                        }
                    }
                }
            }
        }
    }
}
