package ro.alexmamo.roomjetpackcompose.infraestructure.user

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("email") val email: String,
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String,
    @SerializedName("name") val name: NameResponse,
    @SerializedName("address") val address: AddressResponse,
    @SerializedName("phone") val phone: String,
    @SerializedName("__v") val v: Int
) {
    fun toModel(): User =
        User(
            id = id,
            email = email,
            username = username,
            password = password,
            name = name.toModel(),
            address = address.toModel(),
            phone = phone,
            __v = v
        )
}

data class NameResponse(
    @SerializedName("firstname") val firstname: String,
    @SerializedName("lastname") val lastname: String
) {
    fun toModel(): Name =
        Name(
            firstname = firstname,
            lastname = lastname
        )
}

data class AddressResponse(
    @SerializedName("geolocation") val geolocation: GeolocationResponse,
    @SerializedName("city") val city: String,
    @SerializedName("street") val street: String,
    @SerializedName("number") val number: Int,
    @SerializedName("zipcode") val zipcode: String
) {
    fun toModel(): Address =
        Address(
            geolocation = geolocation.toModel(),
            city = city,
            street = street,
            number = number,
            zipcode = zipcode
        )
}

data class GeolocationResponse(
    @SerializedName("lat") val lat: String,
    @SerializedName("long") val long: String
) {
    fun toModel(): Geolocation =
        Geolocation(
            lat = lat,
            long = long
        )
}