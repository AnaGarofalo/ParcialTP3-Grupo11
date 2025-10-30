import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ro.alexmamo.roomjetpackcompose.infraestructure.model.Product
import ro.alexmamo.roomjetpackcompose.presentation.product.ProductListPresenter
import ro.alexmamo.roomjetpackcompose.ui.theme.CustomTheme

@Composable
fun ProductsListScreen(
    presenter: ProductListPresenter,
    modifier: Modifier = Modifier,
) {
    // LaunchedEffect llamará a setup() solo una vez cuando la pantalla aparezca
    LaunchedEffect(true) {
        presenter.setup()
    }

    LazyColumn(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        val products = presenter.products.value

        if (products == null) {
            // Muestra el estado de carga mientras los datos llegan
            repeat(3) {
                item { LoadingCard() }
            }
        } else {
            // Muestra los productos una vez que han sido cargados
            items(products) {
                CharacterCard(it)
            }
        }
    }
}
@Composable
private fun LoadingCard() = Card (
    modifier = Modifier.fillMaxWidth(),
    elevation = CardDefaults.cardElevation(4.dp),
) {
    Column(
        modifier = Modifier.padding(8.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            LoadingBox()
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Box(Modifier
                    .fillMaxWidth()
                    .height(16.dp))
                Box(Modifier
                    .fillMaxWidth(0.8f)
                    .height(16.dp))
            }
        }
    }
}

@Composable
private fun CharacterCard(product: Product) = Card(
    modifier = Modifier.fillMaxWidth(),
    elevation = CardDefaults.cardElevation(4.dp),
) {
    Column(
        modifier = Modifier.padding(8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model ="https://placekitten.com/400/300",
                contentDescription = null,
            )
            Column {
                Text(product.id)
                Text(product.name)
            }
        }
    }
}

@Composable
private fun LoadingBox() = Box(Modifier.size(120.dp))

@Composable
private fun ImageError() = Box(Modifier.size(120.dp))
