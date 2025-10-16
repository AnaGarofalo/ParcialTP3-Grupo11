package ro.alexmamo.roomjetpackcompose.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ro.alexmamo.roomjetpackcompose.core.TODO_TABLE
import ro.alexmamo.roomjetpackcompose.navigation.TodoDetails

@Entity(tableName = TODO_TABLE)
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val description: String
)

fun Todo.toTodoDetails() = TodoDetails(
    id = this.id,
    name = this.name,
    description = this.description
)