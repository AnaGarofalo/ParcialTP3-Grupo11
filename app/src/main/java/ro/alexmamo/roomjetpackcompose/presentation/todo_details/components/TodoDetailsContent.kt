package ro.alexmamo.roomjetpackcompose.presentation.todo_details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.domain.model.Todo
import ro.alexmamo.roomjetpackcompose.presentation.todo_list.components.DescriptionText
import ro.alexmamo.roomjetpackcompose.presentation.todo_list.components.NameText

@Composable
fun TodoDetailsContent(
    innerPadding: PaddingValues,
    todo: Todo
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(innerPadding).padding(8.dp)
    ) {
        NameText(
            title = todo.name
        )
        DescriptionText(
            author = todo.description
        )
    }
}