package ro.alexmamo.roomjetpackcompose.data.repository

import ro.alexmamo.roomjetpackcompose.data.dao.UserDao
import ro.alexmamo.roomjetpackcompose.domain.model.DBUser
import ro.alexmamo.roomjetpackcompose.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userDao: UserDao
) : UserRepository {
    override fun getUserList() = userDao.getUserList()

    override suspend fun getUserById(id: Int) = userDao.getUserById(id)

    override suspend fun insertUser(dbUser: DBUser) = userDao.insertUser(dbUser)

    override suspend fun updateUser(dbUser: DBUser) = userDao.updateUser(dbUser)

    override suspend fun deleteUser(dbUser: DBUser) = userDao.deleteUser(dbUser)
}