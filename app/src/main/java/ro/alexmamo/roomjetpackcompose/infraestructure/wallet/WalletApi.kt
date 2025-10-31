package ro.alexmamo.roomjetpackcompose.infraestructure.wallet

import retrofit2.Response
import retrofit2.http.GET
import ro.alexmamo.roomjetpackcompose.infraestructure.walletimport.WalletResponse

interface WalletApi {
    @GET("transactions")
    suspend fun get(): Response<WalletResponse>
}