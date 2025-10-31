package ro.alexmamo.roomjetpackcompose.infraestructure.auth

data class Token (
    val token: String,
)

data class LoginRequest(
    val email: String,
    val password: String
)

data class CreateUserRequest(
    val email: String,
    val password: String,
    val username: String
)