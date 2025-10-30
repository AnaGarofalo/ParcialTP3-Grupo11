package ro.alexmamo.roomjetpackcompose.presentation.todo_list

import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import ro.alexmamo.roomjetpackcompose.R
import ro.alexmamo.roomjetpackcompose.components.LoadingIndicator
import ro.alexmamo.roomjetpackcompose.core.logMessage
import ro.alexmamo.roomjetpackcompose.core.showSnackbarMessage
import ro.alexmamo.roomjetpackcompose.core.showToastMessage
import ro.alexmamo.roomjetpackcompose.domain.model.Todo
import ro.alexmamo.roomjetpackcompose.domain.model.Response
import ro.alexmamo.roomjetpackcompose.presentation.todo_list.components.TodoListContent
import ro.alexmamo.roomjetpackcompose.presentation.todo_list.components.TodoListTopBar
import ro.alexmamo.roomjetpackcompose.presentation.todo_list.components.EmptyTodoListContent
import ro.alexmamo.roomjetpackcompose.presentation.todo_list.components.InsertTodoAlertDialog
import ro.alexmamo.roomjetpackcompose.presentation.todo_list.components.InsertFloatingActionButton

@Composable
fun TodoListScreen(
    viewModel: TodoListViewModel = hiltViewModel(),
    navigateToTodoDetailsScreen: (Todo) -> Unit
) {
    val context = LocalContext.current
    val resources = context.resources
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    var openInsertTodoDialog by remember { mutableStateOf(false) }
    val todoListResponse by viewModel.todoListState.collectAsStateWithLifecycle()
    val insertTodoResponse by viewModel.insertTodoState.collectAsStateWithLifecycle()
    val updateTodoResponse by viewModel.updateTodoState.collectAsStateWithLifecycle()
    val deleteTodoResponse by viewModel.deleteTodoState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TodoListTopBar()
        },
        floatingActionButton = {
            InsertFloatingActionButton(
                onInsertFloatingActionButtonClick = {
                    openInsertTodoDialog = true
                }
            )
        },
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState
            )
        }
    ) { innerPadding ->
        when(val todoListResponse = todoListResponse) {
            is Response.Idle -> {}
            is Response.Loading -> LoadingIndicator()
            is Response.Success -> todoListResponse.data.let { todoList ->
                if (todoList.isEmpty()) {
                    EmptyTodoListContent(
                        innerPadding = innerPadding
                    )
                } else {
                    TodoListContent(
                        innerPadding = innerPadding,
                        todoList = todoList,
                        onTodoCardClick = navigateToTodoDetailsScreen,
                        onUpdateTodo = { todo ->
                            viewModel.updateTodo(todo)
                        },
                        onEmptyTodoField = { todoField ->
                            showSnackbarMessage(
                                coroutineScope = coroutineScope,
                                snackbarHostState = snackbarHostState,
                                message = resources.getString(R.string.empty_todo_field_message, todoField)
                            )
                        },
                        onDeleteTodo = { todoId ->
                            viewModel.deleteTodo(todoId)
                        },
                        onNoTodoUpdates = {
                            showSnackbarMessage(
                                coroutineScope = coroutineScope,
                                snackbarHostState = snackbarHostState,
                                message = resources.getString(R.string.no_todo_updates_message)
                            )
                        }
                    )
                }
            }
            is Response.Failure -> todoListResponse.e.message?.let { errorMessage ->
                LaunchedEffect(errorMessage) {
                    logMessage(errorMessage)
                    showToastMessage(context, errorMessage)
                }
            }
        }
    }

    if (openInsertTodoDialog) {
        InsertTodoAlertDialog(
            onInsertTodo = { todo ->
                viewModel.insertTodo(todo)
            },
            onEmptyTodoField = { emptyField ->
                showSnackbarMessage(
                    coroutineScope = coroutineScope,
                    snackbarHostState = snackbarHostState,
                    message = resources.getString(R.string.empty_todo_field_message, emptyField)
                )
            },
            onInsertTodoDialogCancel = {
                openInsertTodoDialog = false
            }
        )
    }

    when(val insertTodoResponse = insertTodoResponse) {
        is Response.Idle -> {}
        is Response.Loading -> LoadingIndicator()
        is Response.Success -> LaunchedEffect(Unit) {
            showSnackbarMessage(
                coroutineScope = coroutineScope,
                snackbarHostState = snackbarHostState,
                message = resources.getString(R.string.todo_action_message, TodoAction.ADDED)
            )
            viewModel.resetInsertTodoState()
        }
        is Response.Failure -> insertTodoResponse.e.message?.let { errorMessage ->
            LaunchedEffect(errorMessage) {
                logMessage(errorMessage)
                showToastMessage(context, errorMessage)
            }
        }
    }

    when(val updateTodoResponse = updateTodoResponse) {
        is Response.Idle -> {}
        is Response.Loading -> LoadingIndicator()
        is Response.Success -> LaunchedEffect(Unit) {
            showSnackbarMessage(
                coroutineScope = coroutineScope,
                snackbarHostState = snackbarHostState,
                message = resources.getString(R.string.todo_action_message, TodoAction.UPDATED)
            )
            viewModel.resetUpdateTodoState()
        }
        is Response.Failure -> updateTodoResponse.e.message?.let { errorMessage ->
            LaunchedEffect(errorMessage) {
                logMessage(errorMessage)
                showToastMessage(context, errorMessage)
            }
        }
    }

    when(val deleteTodoResponse = deleteTodoResponse) {
        is Response.Idle -> {}
        is Response.Loading -> LoadingIndicator()
        is Response.Success -> LaunchedEffect(Unit) {
            showSnackbarMessage(
                coroutineScope = coroutineScope,
                snackbarHostState = snackbarHostState,
                message = resources.getString(R.string.todo_action_message, TodoAction.DELETED)
            )
            viewModel.resetDeleteTodoState()
        }
        is Response.Failure -> deleteTodoResponse.e.message?.let { errorMessage ->
            LaunchedEffect(errorMessage) {
                logMessage(errorMessage)
                showToastMessage(context, errorMessage)
            }
        }
    }
}

enum class TodoAction() {
    ADDED,
    UPDATED,
    DELETED
}