package ro.alexmamo.roomjetpackcompose.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ro.alexmamo.roomjetpackcompose.core.TODO_TABLE
import ro.alexmamo.roomjetpackcompose.domain.model.Todo

@Dao
interface TodoDao {
    @Query("SELECT * FROM $TODO_TABLE ORDER BY id ASC")
    fun getTodoList(): Flow<List<Todo>>

    @Query("SELECT * FROM $TODO_TABLE WHERE id = :id")
    suspend fun getTodoById(id: Int): Todo

    @Insert(onConflict = IGNORE)
    suspend fun insertTodo(todo: Todo)

    @Update
    suspend fun updateTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)
}