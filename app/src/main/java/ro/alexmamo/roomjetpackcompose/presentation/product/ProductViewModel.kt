package ro.alexmamo.roomjetpackcompose.presentation.product

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ro.alexmamo.roomjetpackcompose.infraestructure.model.Product

class ProductListViewModel(
    private val getProductsUseCase: GetProductsUseCase,
): ViewModel(), ProductListPresenter {
    private val _products = mutableStateOf<List<Product>?>(null)
    override val products: State<List<Product>?> = _products

    override fun setup() {
        viewModelScope.launch {
            _products.value = getProductsUseCase.execute()
        }
    }
}