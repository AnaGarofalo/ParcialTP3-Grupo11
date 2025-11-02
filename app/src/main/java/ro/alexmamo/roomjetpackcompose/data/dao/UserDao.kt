package ro.alexmamo.roomjetpackcompose.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ro.alexmamo.roomjetpackcompose.core.USER_TABLE
import ro.alexmamo.roomjetpackcompose.domain.model.DBUser

@Dao
interface UserDao {
    @Query("SELECT * FROM $USER_TABLE ORDER BY id ASC")
    fun getUserList(): Flow<List<DBUser>>

    @Query("SELECT * FROM $USER_TABLE WHERE id = :id")
    suspend fun getUserById(id: Int): DBUser

    @Insert(onConflict = IGNORE)
    suspend fun insertUser(dbUser: DBUser)

    @Update
    suspend fun updateUser(dbUser: DBUser)

    @Delete
    suspend fun deleteUser(dbUser: DBUser)
}