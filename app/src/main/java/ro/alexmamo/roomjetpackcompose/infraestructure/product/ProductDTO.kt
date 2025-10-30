package ro.alexmamo.roomjetpackcompose.infraestructure.product

import com.google.gson.annotations.SerializedName

data class ProductDTO(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("data") val data: ProductDataDTO
)

data class ProductDataDTO(
    @SerializedName("capacity") val capacity: String,
    @SerializedName("color") val color: String,
)