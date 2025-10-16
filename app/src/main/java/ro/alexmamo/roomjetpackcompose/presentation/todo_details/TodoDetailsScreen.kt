package ro.alexmamo.roomjetpackcompose.presentation.todo_details

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import ro.alexmamo.roomjetpackcompose.domain.model.Todo
import ro.alexmamo.roomjetpackcompose.presentation.todo_details.components.TodoDetailsContent
import ro.alexmamo.roomjetpackcompose.presentation.todo_details.components.TodoDetailsTopBar

@Composable
fun TodoDetailsScreen(
    todo: Todo,
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TodoDetailsTopBar(
                onArrowBackIconClick = navigateBack
            )
        },
        content = { innerPadding ->
            TodoDetailsContent(
                innerPadding = innerPadding,
                todo = todo
            )
        }
    )
}