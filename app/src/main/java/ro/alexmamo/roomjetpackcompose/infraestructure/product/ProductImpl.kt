package ro.alexmamo.roomjetpackcompose.infraestructure.product

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ro.alexmamo.roomjetpackcompose.infraestructure.model.Product
import ro.alexmamo.roomjetpackcompose.infraestructure.model.Products

class ProductImpl : Products {

    private val retrofit: Retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.restful-api.dev")
        .build()

    private val api = retrofit.create(ProductApi::class.java)

    override suspend fun getAll(): List<Product>? {
        try {
            val response = api.getProducts()

            // response.isSuccessful será 'true' si el código HTTP es 2xx (por ejemplo, 200 OK)
            if (response.isSuccessful) {
                val body = response.body()
                Log.d("API_SUCCESS", "Respuesta exitosa: ${body}") // Log para el éxito

                // Tu lógica actual
                return body?.map { it.toModel() } ?: listOf()

            } else {
                // La petición se hizo, pero el servidor respondió con un error (4xx o 5xx)
                val errorCode = response.code()
                val errorBody = response.errorBody()?.string() // .string() consume el cuerpo, úsalo con cuidado
                Log.e("API_ERROR", "Error en la respuesta: Código $errorCode - $errorBody") // Log para el error
                return null
            }
        } catch (e: Exception) {
            // Ocurrió un error en la propia petición (ej. no hay internet, DNS falló)
            Log.e("API_FAILURE", "Fallo en la petición: ${e.message}", e) // Log para una falla de conexión
            return null
        }
    }
}