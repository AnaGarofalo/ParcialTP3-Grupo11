package ro.alexmamo.roomjetpackcompose.infraestructure.auth

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ro.alexmamo.roomjetpackcompose.infraestructure.ApiResult
import ro.alexmamo.roomjetpackcompose.infraestructure.safeApiCall

class AuthImpl : Auth {
    private val retrofit: Retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://d9811bf4-5e67-4a8c-bdcf-603cbbfc0275.mock.pstmn.io/auth/")
        .build()

    private val api = retrofit.create(AuthApi::class.java)


    override suspend fun login(data: LoginRequest): Token? {
        return when (val result = safeApiCall("login", {api.login(data)}) { res -> res.toModel()
        }) {
            is ApiResult.Success -> result.data
            is ApiResult.Error,
            is ApiResult.Exception -> null
        }
    }
}