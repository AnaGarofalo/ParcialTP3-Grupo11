package ro.alexmamo.roomjetpackcompose.infraestructure.wallet

data class Wallet(
    val userId: Int,
    val balance: Double,
    val income: Double,
    val expense: Double,
    val transactions: List<Transaction>
)

data class Transaction(
    val transactionId: String,
    val date: String,
    val description: String,
    val amount: Double,
    val currency: String,
    val type: String,
    val subtype: String
)