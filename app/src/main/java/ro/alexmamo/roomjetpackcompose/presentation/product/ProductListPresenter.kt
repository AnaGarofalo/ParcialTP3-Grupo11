package ro.alexmamo.roomjetpackcompose.presentation.product

import androidx.compose.runtime.State
import ro.alexmamo.roomjetpackcompose.infraestructure.model.Product

interface ProductListPresenter {
    val products: State<List<Product>?>
    fun setup()
}