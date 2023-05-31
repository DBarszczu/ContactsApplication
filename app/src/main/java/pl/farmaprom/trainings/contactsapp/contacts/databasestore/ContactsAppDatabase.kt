package pl.farmaprom.trainings.contactsapp.contacts.databasestore

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pl.farmaprom.trainings.contactsapp.contacts.databasestore.dao.ContactsDao
import pl.farmaprom.trainings.contactsapp.contacts.databasestore.model.ContactDbModel


@Database(
    entities = [ContactDbModel::class],
    version = 1
)
abstract class ContactsAppDatabase : RoomDatabase() {

    companion object {
        private var INSTANCE: ContactsAppDatabase? = null

        fun getInstance(context: Context): ContactsAppDatabase? {
            if (INSTANCE == null) {
                synchronized(ContactsAppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactsAppDatabase::class.java, "contacts.db"
                    ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
    }

    abstract fun contactsDao(): ContactsDao
}