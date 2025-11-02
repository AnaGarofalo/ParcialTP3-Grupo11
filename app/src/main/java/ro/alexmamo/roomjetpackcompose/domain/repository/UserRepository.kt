package ro.alexmamo.roomjetpackcompose.domain.repository

import kotlinx.coroutines.flow.Flow
import ro.alexmamo.roomjetpackcompose.domain.model.DBUser

interface UserRepository {
    fun getUserList(): Flow<List<DBUser>>

    suspend fun getUserById(id: Int): DBUser?

    suspend fun insertUser(dbUser: DBUser)

    suspend fun updateUser(dbUser: DBUser)

    suspend fun deleteUser(dbUser: DBUser)
}