package ro.alexmamo.roomjetpackcompose.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import ro.alexmamo.roomjetpackcompose.data.dao.TodoDao
import ro.alexmamo.roomjetpackcompose.domain.model.Todo

@Database(
    entities = [Todo::class],
    version = 3,
    exportSchema = false
)
abstract class TodoDb : RoomDatabase() {
    abstract val todoDao: TodoDao
}