package ro.alexmamo.roomjetpackcompose.presentation.todo_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.ActionIconButton
import ro.alexmamo.roomjetpackcompose.domain.model.Todo

@Composable
fun TodoCard(
    todo: Todo,
    onTodoCardClick: () -> Unit,
    onEditTodo: () -> Unit,
    onDeleteTodo: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(
            start = 8.dp,
            top = 4.dp,
            end = 8.dp,
            bottom = 4.dp
        ).clickable {
            onTodoCardClick()
        },
        shape = MaterialTheme.shapes.small,
        elevation = 3.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Column {
                NameText(
                    title = todo.name
                )
                DescriptionText(
                    author = todo.description
                )
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            ActionIconButton(
                onActionIconButtonClick = onEditTodo,
                withCircle = false,
                content = { mod ->
                    androidx.compose.material.Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = stringResource(id = R.string.edit_icon),
                        modifier = mod
                    )
                }
            )
            ActionIconButton(
                onActionIconButtonClick = onDeleteTodo,
                withCircle = false,
                content = { mod ->
                    androidx.compose.material.Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = stringResource(id = R.string.delete_icon),
                        modifier = mod
                    )
                }
            )
        }
    }
}