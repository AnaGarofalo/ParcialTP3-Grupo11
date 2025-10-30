package ro.alexmamo.roomjetpackcompose.infraestructure.auth

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/login")
    suspend fun login(@Body data: LoginRequest): Response<TokenResponse>
}