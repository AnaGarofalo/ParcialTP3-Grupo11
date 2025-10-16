package ro.alexmamo.roomjetpackcompose.presentation.todo_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ro.alexmamo.roomjetpackcompose.domain.model.Todo
import ro.alexmamo.roomjetpackcompose.domain.model.Response
import ro.alexmamo.roomjetpackcompose.domain.repository.TodoRepository
import javax.inject.Inject

typealias InsertTodoResponse = Response<Unit>
typealias UpdateTodoResponse = Response<Unit>
typealias DeleteTodoResponse = Response<Unit>

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val repo: TodoRepository
) : ViewModel() {
    val todoListState = repo.getTodoList().map { todoList ->
        try {
            Response.Success(todoList)
        } catch (e: Exception) {
            Response.Failure(e)
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = Response.Loading
    )

    private val _insertTodoState = MutableStateFlow<InsertTodoResponse>(Response.Idle)
    val insertTodoState: StateFlow<InsertTodoResponse> = _insertTodoState.asStateFlow()

    private val _updateTodoState = MutableStateFlow<UpdateTodoResponse>(Response.Idle)
    val updateTodoState: StateFlow<UpdateTodoResponse> = _updateTodoState.asStateFlow()

    private val _deleteTodoState = MutableStateFlow<DeleteTodoResponse>(Response.Idle)
    val deleteTodoState: StateFlow<DeleteTodoResponse> = _deleteTodoState.asStateFlow()

    fun insertTodo(todo: Todo) = viewModelScope.launch {
        try {
            _insertTodoState.value = Response.Loading
            _insertTodoState.value = Response.Success(repo.insertTodo(todo))
        } catch (e: Exception) {
            Response.Failure(e)
        }
    }

    fun resetInsertTodoState() {
        _insertTodoState.value = Response.Idle
    }

    fun updateTodo(todo: Todo) = viewModelScope.launch {
        try {
            _updateTodoState.value = Response.Loading
            _updateTodoState.value = Response.Success(repo.updateTodo(todo))
        } catch (e: Exception) {
            Response.Failure(e)
        }
    }

    fun resetUpdateTodoState() {
        _updateTodoState.value = Response.Idle
    }

    fun deleteTodo(todo: Todo) = viewModelScope.launch {
        try {
            _deleteTodoState.value = Response.Loading
            _deleteTodoState.value = Response.Success(repo.deleteTodo(todo))
        } catch (e: Exception) {
            Response.Failure(e)
        }
    }

    fun resetDeleteTodoState() {
        _deleteTodoState.value = Response.Idle
    }
}