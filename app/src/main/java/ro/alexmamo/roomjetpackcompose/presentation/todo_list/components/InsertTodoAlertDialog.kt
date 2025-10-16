package ro.alexmamo.roomjetpackcompose.presentation.todo_list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.ActionButton
import ro.alexmamo.roomjetpackcompose.core.DESCRIPTION_FIELD
import ro.alexmamo.roomjetpackcompose.core.NAME_FIELD
import ro.alexmamo.roomjetpackcompose.domain.model.Todo

const val EMPTY_STRING = ""

@Composable
fun InsertTodoAlertDialog(
    onInsertTodo: (todo: Todo) -> Unit,
    onEmptyTodoField: (String) -> Unit,
    onInsertTodoDialogCancel: () -> Unit,
) {
    var name by remember { mutableStateOf(EMPTY_STRING) }
    var description by remember { mutableStateOf(EMPTY_STRING) }

    AlertDialog(
        onDismissRequest = onInsertTodoDialogCancel,
        title = {
            Text(
                text = stringResource(
                    id = R.string.insert_todo
                )
            )
        },
        text = {
            Column {
                NameTextField(
                    name = name,
                    onUpdateName = { newName ->
                        name = newName
                    }
                )
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
                DescriptionTextField(
                    description = description,
                    onUpdateDescription = { newDescription ->
                        description = newDescription
                    }
                )
            }
        },
        confirmButton = {
            ActionButton(
                onActionButtonClick = {
                    if (name.isEmpty()) {
                        onEmptyTodoField(NAME_FIELD)
                        return@ActionButton
                    }
                    if (description.isEmpty()) {
                        onEmptyTodoField(DESCRIPTION_FIELD)
                        return@ActionButton
                    }
                    onInsertTodo(Todo(
                        id = 0,
                        name = name,
                        description = description
                    ))
                    onInsertTodoDialogCancel()
                },
                resourceId = R.string.insert_button
            )
        },
        dismissButton = {
            ActionButton(
                onActionButtonClick = onInsertTodoDialogCancel,
                resourceId = R.string.cancel_button
            )
        },
    )
}