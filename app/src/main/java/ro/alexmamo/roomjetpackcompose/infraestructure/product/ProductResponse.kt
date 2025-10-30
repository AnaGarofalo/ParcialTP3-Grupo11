package ro.alexmamo.roomjetpackcompose.infraestructure.product

import com.google.gson.annotations.SerializedName
import ro.alexmamo.roomjetpackcompose.infraestructure.model.Product
import ro.alexmamo.roomjetpackcompose.infraestructure.model.ProductData

data class ProductDataResponse(
    @SerializedName("capacity") val capacity: String,
    @SerializedName("color") val color: String,
) {
    fun toModel(): ProductData =
        ProductData(
            capacity = capacity,
            color = color,
        )
}

data class ProductResponse(

    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("data") val data: ProductDataResponse,

) {
    fun toModel(): Product =
        Product(
            id = id,
            name = name,
            data = data.toModel(),
        )
}