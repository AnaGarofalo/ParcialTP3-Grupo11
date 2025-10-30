package ro.alexmamo.roomjetpackcompose.infraestructure.model


data class Product(
    val id: String,
    val name: String,
    val data: ProductData
)

data class ProductData(
    val capacity: String,
    val color: String,
)