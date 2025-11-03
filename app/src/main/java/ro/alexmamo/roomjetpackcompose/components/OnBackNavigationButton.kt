package ro.alexmamo.roomjetpackcompose.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.ui.theme.Honeydew

@Composable
fun OnBackNavigationButton(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    ActionIconButton(
        onActionIconButtonClick = onNavigateBack,
        withCircle = false,
        content = { mod ->
            androidx.compose.material.Icon(
                painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = stringResource(id = R.string.navigate_back),
                tint = Honeydew,
                modifier = mod
            )
        }
    )
}

