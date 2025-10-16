package ro.alexmamo.roomjetpackcompose.presentation.todo_list.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ro.alexmamo.roomjetpackcompose.R

@Composable
fun TodoListTopBar() {
    TopAppBar (
        title = {
            Text(
                text = stringResource(
                    id = R.string.todo_list_screen_name
                )
            )
        }
    )
}