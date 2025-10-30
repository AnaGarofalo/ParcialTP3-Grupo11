package ro.alexmamo.roomjetpackcompose.infraestructure.auth

import ro.alexmamo.roomjetpackcompose.infraestructure.ApiResult
import ro.alexmamo.roomjetpackcompose.infraestructure.RetrofitUtils
import ro.alexmamo.roomjetpackcompose.infraestructure.safeApiCall

class AuthImpl : Auth {
    private val api = RetrofitUtils.retrofit.create(AuthApi::class.java)

    override suspend fun login(data: LoginRequest): Token? {
        return when (val result = safeApiCall("login", {api.login(data)}) { res -> res.toModel()
        }) {
            is ApiResult.Success -> result.data
            is ApiResult.Error,
            is ApiResult.Exception -> null
        }
    }
}