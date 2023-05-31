package pl.farmaprom.trainings.contactsapp.contacts.databasestore.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import pl.farmaprom.trainings.contactsapp.contacts.databasestore.model.ContactDbModel


@Dao
interface ContactsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contactsDbModel: ContactDbModel): Long

    @Query("SELECT * FROM contact")
    fun getAllContacts(): List<ContactDbModel>
}