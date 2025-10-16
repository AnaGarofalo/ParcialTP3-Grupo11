package ro.alexmamo.roomjetpackcompose.presentation.todo_list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.ActionButton
import ro.alexmamo.roomjetpackcompose.core.DESCRIPTION_FIELD
import ro.alexmamo.roomjetpackcompose.core.NAME_FIELD
import ro.alexmamo.roomjetpackcompose.domain.model.Todo

@Composable
fun EditableTodoCard(
    todo: Todo,
    onUpdateTodo: (Todo) -> Unit,
    onEmptyTodoField: (String) -> Unit,
    onNoTodoUpdates: () -> Unit,
    onCancel: () -> Unit
) {
    var updatedTodo by remember { mutableStateOf(todo) }

    Card(
        modifier = Modifier.fillMaxWidth().padding(
            start = 8.dp,
            top = 4.dp,
            end = 8.dp,
            bottom = 4.dp
        ),
        shape = MaterialTheme.shapes.small,
        elevation = 3.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            NameTextField(
                name = updatedTodo.name,
                onUpdateName = { newName ->
                    updatedTodo = updatedTodo.copy(
                        name = newName
                    )
                }
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            DescriptionTextField(
                description = updatedTodo.description,
                onUpdateDescription = { newDescription ->
                    updatedTodo = updatedTodo.copy(
                        description = newDescription
                    )
                }
            )
            Row {
                ActionButton(
                    onActionButtonClick = onCancel,
                    resourceId = R.string.cancel_button
                )
                Spacer(
                    modifier = Modifier.width(8.dp)
                )
                ActionButton(
                    onActionButtonClick = {
                        updatedTodo.apply {
                            if (name.isEmpty()) {
                                onEmptyTodoField(NAME_FIELD)
                            } else if (description.isEmpty()) {
                                onEmptyTodoField(DESCRIPTION_FIELD)
                            } else {
                                if (updatedTodo != todo) {
                                    onUpdateTodo(updatedTodo)
                                } else {
                                    onNoTodoUpdates()
                                }
                            }
                        }
                    },
                    resourceId = R.string.update_button
                )
            }
        }
    }
}