package ro.alexmamo.roomjetpackcompose.infraestructure.auth


interface Auth {
    suspend fun login(data: LoginRequest): Token?
}