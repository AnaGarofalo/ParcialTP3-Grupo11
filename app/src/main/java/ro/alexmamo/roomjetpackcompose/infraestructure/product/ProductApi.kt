package ro.alexmamo.roomjetpackcompose.infraestructure.product

import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {
    @GET("objects?id=1")
    suspend fun getProducts(): Response<List<ProductResponse>>
}