package ro.alexmamo.roomjetpackcompose.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import ro.alexmamo.roomjetpackcompose.data.dao.UserDao
import ro.alexmamo.roomjetpackcompose.domain.model.DBUser

@Database(
    entities = [DBUser::class],
    version = 4,
    exportSchema = false
)
abstract class UserDb : RoomDatabase() {
    abstract val userDao: UserDao
}