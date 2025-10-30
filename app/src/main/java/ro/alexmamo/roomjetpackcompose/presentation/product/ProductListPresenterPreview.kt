package ro.alexmamo.roomjetpackcompose.presentation.product

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import ro.alexmamo.roomjetpackcompose.infraestructure.model.Product

class ProductListPresenterPreview(
    products: List<Product>? = null,
): ProductListPresenter {
    override val products: State<List<Product>?> = mutableStateOf(products)
    override fun setup() {
        TODO("Not yet implemented")
    }
}