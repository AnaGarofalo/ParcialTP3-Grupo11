package ro.alexmamo.roomjetpackcompose.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ro.alexmamo.roomjetpackcompose.core.USER_TABLE

data class DBUserDetails(
    val id: Int,
    val username: String,
    val email: String
)


@Entity(tableName = USER_TABLE)
data class DBUser(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val username: String,
    val email: String
)

fun DBUser.toUserDetails() = DBUserDetails(
    id = this.id,
    username = this.username,
    email = this.email
)