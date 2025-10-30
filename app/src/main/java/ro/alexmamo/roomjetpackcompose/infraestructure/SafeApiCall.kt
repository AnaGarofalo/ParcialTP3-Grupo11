package ro.alexmamo.roomjetpackcompose.infraestructure

import android.util.Log
import retrofit2.Response

suspend fun <T, R> safeApiCall(
    tag: String = "API_CALL",
    apiCall: suspend () -> Response<T>,
    map: (T) -> R
): ApiResult<R> {
    return try {
        val response = apiCall()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                Log.d(tag, "✅ Éxito: ${response.code()} -> ${body.toString().take(500)}")
                ApiResult.Success(map(body))
            } else {
                Log.e(tag, "⚠️ Cuerpo nulo en respuesta exitosa (${response.code()})")
                ApiResult.Error(response.code(), "Cuerpo de respuesta nulo")
            }
        } else {
            val errorBody = response.errorBody()?.string()
            Log.e(tag, "❌ Error HTTP ${response.code()} -> ${errorBody ?: "Sin cuerpo de error"}")
            ApiResult.Error(response.code(), errorBody)
        }
    } catch (e: Exception) {
        Log.e(tag, "💥 Excepción: ${e.message}", e)
        ApiResult.Exception(e)
    }
}