package ro.alexmamo.roomjetpackcompose.infraestructure.wallet

interface WalletInterface {
    suspend fun get(): Wallet?
}