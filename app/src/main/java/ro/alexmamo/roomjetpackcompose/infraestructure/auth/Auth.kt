package ro.alexmamo.roomjetpackcompose.infraestructure.auth

import ro.alexmamo.roomjetpackcompose.infraestructure.user.User


interface Auth {
    suspend fun login(data: LoginRequest): Token?

    suspend fun createUser(data: CreateUserRequest): User?
}