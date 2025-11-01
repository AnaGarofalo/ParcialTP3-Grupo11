package ro.alexmamo.roomjetpackcompose.presentation.todo_details.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ro.alexmamo.roomjetpackcompose.R
import androidx.compose.material3.Icon
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.size
import ro.alexmamo.roomjetpackcompose.components.ActionIconButton

@Composable
fun TodoDetailsTopBar(
    onArrowBackIconClick: () -> Unit
) {
    TopAppBar (
        title = {
            Text(
                text = stringResource(
                    id = R.string.todo_details_screen_name
                )
            )
        },
        navigationIcon = {
            ActionIconButton(
                onActionIconButtonClick = onArrowBackIconClick,
                withCircle = false,
                content = { mod ->
                    Icon(
                        Icons.AutoMirrored.Outlined.ArrowBack,
                        contentDescription = stringResource(id = R.string.navigate_back),
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier = mod
                    )
                }
            )
        }
    )
}