package ro.alexmamo.roomjetpackcompose.data.repository

import ro.alexmamo.roomjetpackcompose.data.dao.TodoDao
import ro.alexmamo.roomjetpackcompose.domain.model.Todo
import ro.alexmamo.roomjetpackcompose.domain.repository.TodoRepository

class TodoRepositoryImpl(
    private val todoDao: TodoDao
) : TodoRepository {
    override fun getTodoList() = todoDao.getTodoList()

    override suspend fun getTodoById(id: Int) = todoDao.getTodoById(id)

    override suspend fun insertTodo(todo: Todo) = todoDao.insertTodo(todo)

    override suspend fun updateTodo(todo: Todo) = todoDao.updateTodo(todo)

    override suspend fun deleteTodo(todo: Todo) = todoDao.deleteTodo(todo)
}