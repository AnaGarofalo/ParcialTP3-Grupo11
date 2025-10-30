package ro.alexmamo.roomjetpackcompose.navigation

import kotlinx.serialization.Serializable
import ro.alexmamo.roomjetpackcompose.domain.model.Todo


@Serializable
object TodoListScreen

@Serializable
object ProductsListScreen

@Serializable
data class TodoDetails(
    val id: Int,
    val name: String,
    val description: String
)

fun TodoDetails.toTodo() = Todo(
    id = this.id,
    name = this.name,
    description = this.description
)