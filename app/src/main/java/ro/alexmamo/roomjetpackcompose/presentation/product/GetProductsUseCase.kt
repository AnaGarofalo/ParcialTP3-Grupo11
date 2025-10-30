package ro.alexmamo.roomjetpackcompose.presentation.product

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ro.alexmamo.roomjetpackcompose.infraestructure.model.Product
import ro.alexmamo.roomjetpackcompose.infraestructure.model.Products

class GetProductsUseCase(
    private val products: Products,
) {
    suspend fun execute(): List<Product>? = withContext(Dispatchers.IO) {
        products.getAll()
    }
}