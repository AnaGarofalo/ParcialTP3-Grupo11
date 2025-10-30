package ro.alexmamo.roomjetpackcompose.infraestructure.walletimport

import com.google.gson.annotations.SerializedName
import ro.alexmamo.roomjetpackcompose.infraestructure.wallet.Transaction
import ro.alexmamo.roomjetpackcompose.infraestructure.wallet.Wallet

data class WalletResponse(
    @SerializedName("user_id") val userId: Int,
    @SerializedName("balance") val balance: Double,
    @SerializedName("income") val income: Double,
    @SerializedName("expense") val expense: Double,
    @SerializedName("transactions") val transactions: List<TransactionResponse>
) {
    fun toModel(): Wallet =
        Wallet(
            userId = userId,
            balance = balance,
            income = income,
            expense = expense,
            transactions = transactions.map { it.toModel() }
        )
}

data class TransactionResponse(
    @SerializedName("transaction_id") val transactionId: String,
    @SerializedName("date") val date: String,
    @SerializedName("description") val description: String,
    @SerializedName("amount") val amount: Double,
    @SerializedName("currency") val currency: String,
    @SerializedName("type") val type: String,
    @SerializedName("subtype") val subtype: String
) {
    fun toModel(): Transaction =
        Transaction(
            transactionId = transactionId,
            date = date,
            description = description,
            amount = amount,
            currency = currency,
            type = type,
            subtype = subtype
        )
}