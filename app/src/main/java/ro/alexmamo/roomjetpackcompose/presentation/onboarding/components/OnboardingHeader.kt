package ro.alexmamo.roomjetpackcompose.presentation.onboarding.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.roomjetpackcompose.ui.theme.Dimens
import ro.alexmamo.roomjetpackcompose.ui.theme.Poppins

@Composable
fun OnboardingHeader(
    title: String,
    isFirstPage: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = Dimens.paddingLarge * 3.5f, bottom = 80.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier
                .size(width = 289.dp, height = 122.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 30.sp,
                    lineHeight = 39.sp,
                    letterSpacing = 0.sp
                ),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.inverseSurface,
                maxLines = if (isFirstPage) 2 else 3,
                overflow = TextOverflow.Clip,
                softWrap = true,
                modifier = Modifier
                    .width(320.dp)
                    .padding(horizontal = 0.dp)
            )
        }
    }
}
