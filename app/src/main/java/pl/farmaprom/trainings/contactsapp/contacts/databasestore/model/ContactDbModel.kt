package pl.farmaprom.trainings.contactsapp.contacts.databasestore.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contact")

data class ContactDbModel(
    @PrimaryKey var id: Long = -1,
    val name: String = "",
    var surname: String = "",
    var email: String = "",
    var phone: String = "",
    var lat: Double? = null,
    var lon: Double? = null,
    var isFavorite: Boolean = false,
    val profileImageUrl: String? = null
)


