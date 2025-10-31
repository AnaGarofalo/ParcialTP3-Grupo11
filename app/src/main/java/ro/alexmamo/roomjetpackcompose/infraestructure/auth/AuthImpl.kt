package ro.alexmamo.roomjetpackcompose.infraestructure.auth

import ro.alexmamo.roomjetpackcompose.infraestructure.ApiResult
import ro.alexmamo.roomjetpackcompose.infraestructure.RetrofitUtils
import ro.alexmamo.roomjetpackcompose.infraestructure.safeApiCall
import ro.alexmamo.roomjetpackcompose.infraestructure.user.User

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

    override suspend fun createUser(data: CreateUserRequest): User? {
        return when (val result = safeApiCall("createUser", {api.createUser(data)}) { res -> res.toModel()
        }) {
            is ApiResult.Success -> result.data
            is ApiResult.Error,
            is ApiResult.Exception -> null
        }
    }
}