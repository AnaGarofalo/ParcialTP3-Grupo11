package ro.alexmamo.roomjetpackcompose.infraestructure.auth

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import ro.alexmamo.roomjetpackcompose.infraestructure.user.UserResponse

interface AuthApi {
    @POST("auth/login")
    suspend fun login(@Body data: LoginRequest): Response<TokenResponse>

    @POST("auth/create")
    suspend fun createUser(@Body data: CreateUserRequest): Response<UserResponse>
}