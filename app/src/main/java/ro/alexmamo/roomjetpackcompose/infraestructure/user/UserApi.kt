package ro.alexmamo.roomjetpackcompose.infraestructure.user

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserApi {
    @GET("users/{id}")
    suspend fun getById(@Path("id") id: Int): Response<UserResponse>
}