package ro.alexmamo.roomjetpackcompose.data.repository

import kotlinx.coroutines.flow.flow
import ro.alexmamo.roomjetpackcompose.domain.model.Todo
import ro.alexmamo.roomjetpackcompose.domain.repository.TodoRepository

class FakeTodoRepositoryImpl() : TodoRepository {
    private val todoList = mutableListOf<Todo>()

    override fun getTodoList() = flow {
        emit(todoList)
    }

    override suspend fun getTodoById(id: Int) = todoList.find { todo ->
        todo.id == id
    }

    override suspend fun insertTodo(todo: Todo) {
        todoList.add(todo)
    }

    override suspend fun updateTodo(todo: Todo) {
        val indexOfFirstTodo = todoList.indexOfFirst { firstTodo ->
            firstTodo.id == todo.id
        }
        if (indexOfFirstTodo != -1) {
            todoList[indexOfFirstTodo] = todo
        }
    }

    override suspend fun deleteTodo(todo: Todo) {
        todoList.remove(todo)
    }
}