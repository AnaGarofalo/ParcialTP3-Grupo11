package ro.alexmamo.roomjetpackcompose.infraestructure.model

interface Products {
    suspend fun getAll(): List<Product>?
}