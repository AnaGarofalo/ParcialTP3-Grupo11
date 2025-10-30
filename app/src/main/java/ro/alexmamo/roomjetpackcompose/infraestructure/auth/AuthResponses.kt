package ro.alexmamo.roomjetpackcompose.infraestructure.auth

import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("token") val token: String,
) {
    fun toModel(): Token =
        Token(
            token = token,
        )
}