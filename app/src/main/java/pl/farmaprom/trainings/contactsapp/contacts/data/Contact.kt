package pl.farmaprom.trainings.contactsapp.contacts.data

import com.google.android.gms.maps.model.LatLng

data class Contact(
    val id: Long = -1,
    val name: String = "",
    val surname: String = "",
    val relation: String? = null,
    val email: String = "",
    val phone: String = "",
    val city: String = "",
    val birthday: String = "",
    val location: LatLng? = null,
    val profileImageUrl: String? = null,
    val isFavourite: Boolean = false,
    val isMe: Boolean = false,
    val lastActionTime: Long? = null
)
