package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ro.alexmamo.roomjetpackcompose.ui.theme.Dimens

@Composable
fun AppTopBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    leftAction: (@Composable () -> Unit)? = null,
    rightAction: (@Composable () -> Unit)? = null
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.paddingLarge, vertical = Dimens.paddingSmall)
    ) {
        if (leftAction != null) {
            Box(modifier = Modifier.align(Alignment.CenterStart)) {
                leftAction()
            }
        }

        if (title != null) {
            Box(modifier = Modifier.align(Alignment.Center)) {
                Text(text = title, style = MaterialTheme.typography.titleLarge)
            }
        }

        if (rightAction != null) {
            Box(modifier = Modifier.align(Alignment.CenterEnd)) {
                rightAction()
            }
        }
    }
}
