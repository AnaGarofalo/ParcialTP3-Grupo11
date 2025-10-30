package ro.alexmamo.roomjetpackcompose.infraestructure.user


interface Users {
    suspend fun getById(id: Int): User?
}