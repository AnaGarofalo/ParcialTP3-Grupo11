package ro.alexmamo.roomjetpackcompose.infraestructure.user

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ro.alexmamo.roomjetpackcompose.infraestructure.ApiResult
import ro.alexmamo.roomjetpackcompose.infraestructure.RetrofitUtils
import ro.alexmamo.roomjetpackcompose.infraestructure.auth.AuthApi
import ro.alexmamo.roomjetpackcompose.infraestructure.safeApiCall

class UsersImpl : Users {
    private val api = RetrofitUtils.retrofit.create(UserApi::class.java)

    override suspend fun getById(id: Int): User? {
        return when (val result = safeApiCall("login", {api.getById(id)}) { res -> res.toModel()
        }) {
            is ApiResult.Success -> result.data
            is ApiResult.Error,
            is ApiResult.Exception -> null
        }
    }
}