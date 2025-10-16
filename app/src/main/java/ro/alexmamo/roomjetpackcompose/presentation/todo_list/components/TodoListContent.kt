package ro.alexmamo.roomjetpackcompose.presentation.todo_list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import ro.alexmamo.roomjetpackcompose.domain.model.Todo

const val NON_EXISTENT_TODO_ID = -1

@Composable
fun TodoListContent(
    innerPadding: PaddingValues,
    todoList: List<Todo>,
    onTodoCardClick: (Todo) -> Unit,
    onUpdateTodo: (Todo) -> Unit,
    onEmptyTodoField: (String) -> Unit,
    onDeleteTodo: (Todo) -> Unit,
    onNoTodoUpdates: () -> Unit
) {
    var editTodoId by remember { mutableIntStateOf(NON_EXISTENT_TODO_ID) }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(innerPadding)
    ) {
        items(
            items = todoList,
            key = { todo ->
                todo.id
            }
        ) { todo ->
            if (editTodoId != todo.id) {
                TodoCard(
                    todo = todo,
                    onTodoCardClick = {
                        onTodoCardClick(todo)
                    },
                    onEditTodo = {
                        editTodoId = todo.id
                    },
                    onDeleteTodo = {
                        onDeleteTodo(todo)
                        editTodoId = NON_EXISTENT_TODO_ID
                    }
                )
            } else {
                EditableTodoCard(
                    todo = todo,
                    onUpdateTodo = { updatedTodo ->
                        onUpdateTodo(updatedTodo)
                        editTodoId = NON_EXISTENT_TODO_ID
                    },
                    onEmptyTodoField = onEmptyTodoField,
                    onNoTodoUpdates = {
                        onNoTodoUpdates()
                        editTodoId = NON_EXISTENT_TODO_ID
                    },
                    onCancel = {
                        editTodoId = NON_EXISTENT_TODO_ID
                    }
                )
            }
        }
    }
}