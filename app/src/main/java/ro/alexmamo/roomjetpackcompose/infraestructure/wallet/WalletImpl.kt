package ro.alexmamo.roomjetpackcompose.infraestructure.wallet

import ro.alexmamo.roomjetpackcompose.infraestructure.ApiResult
import ro.alexmamo.roomjetpackcompose.infraestructure.RetrofitUtils
import ro.alexmamo.roomjetpackcompose.infraestructure.safeApiCall

class WalletImpl : WalletInterface {
    private val api = RetrofitUtils.retrofit.create(WalletApi::class.java)

    override suspend fun get(): Wallet? {
        return when (val result = safeApiCall("get", {api.get()}) { res -> res.toModel()
        }) {
            is ApiResult.Success -> result.data
            is ApiResult.Error,
            is ApiResult.Exception -> null
        }
    }
}