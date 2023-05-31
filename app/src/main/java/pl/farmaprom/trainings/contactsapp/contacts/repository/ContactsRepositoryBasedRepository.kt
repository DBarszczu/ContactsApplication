package pl.farmaprom.trainings.contactsapp.contacts.repository

import android.content.Context
import android.util.Log
import pl.farmaprom.trainings.contactsapp.contacts.data.Contact
import pl.farmaprom.trainings.contactsapp.contacts.databasestore.ContactsAppDatabase
import pl.farmaprom.trainings.contactsapp.contacts.databasestore.model.ContactDbModel
import pl.farmaprom.trainings.contactsapp.networkstore.model.ContactsApiModel
import pl.farmaprom.trainings.contactsapp.networkstore.model.retrofit

class ContactsRepositoryBasedRepository(context: Context): ContactsRepository {

    private var database: ContactsAppDatabase? = null
    init {
        database = ContactsAppDatabase.getInstance(context)
    }



    override suspend fun getAll(): List<Contact> {
        val contactsFromApi = retrofit.create(ContactsApi::class.java).getAll()
        return contactsFromApi.map { contactsApiModel ->
            database?.contactsDao()?.insertContact(
                ContactDbModel(
                    name = contactsApiModel.name,
                    surname = contactsApiModel.surname,
                    email = contactsApiModel.email ?: "",
                    phone = contactsApiModel.phoneNumber,
                    lat = contactsApiModel.location?.latitude,
                    lon = contactsApiModel.location?.longitude,
                    isFavorite = contactsApiModel.isFavourite,
                    profileImageUrl = contactsApiModel.imageUrl
                )
            )

            transformToDomain(contactsApiModel)
        }
    }


    private fun transformToDomain(apiModel: ContactsApiModel): Contact {
        return Contact(
            id = apiModel.id,
            name = apiModel.name,
            surname = apiModel.surname,
            profileImageUrl = apiModel.imageUrl,
            email = apiModel.email ?: "",
            isFavourite = apiModel.isFavourite
        )
    }

}