package pl.farmaprom.trainings.contactsapp.ui

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.farmaprom.trainings.contactsapp.contacts.data.Contact
import pl.farmaprom.trainings.contactsapp.contacts.presentation.ContactsViewState
import pl.farmaprom.trainings.contactsapp.contacts.repository.ContactsRepository
import pl.farmaprom.trainings.contactsapp.contacts.repository.ContactsRepositoryBasedRepository
import pl.farmaprom.trainings.contactsapp.sampleData

class MainViewModel : ViewModel() {

    private var context: Context? = null
    private var repository: ContactsRepository? = null

    var viewState = mutableStateOf(ContactsViewState())
        private set

    fun attach(context: Context) {
        repository = ContactsRepositoryBasedRepository(context)
        viewModelScope.launch {
            viewState.value = ContactsViewState(
                contacts = repository!!.getAll()
            )
        }
    }


    fun getContactsById(id: Long): Contact {
        return sampleData.first { singleListItem ->
            singleListItem.id == id
        }
    }

}


//    fun onContactSelect(id: Long){
//        val contact = sampleData.first {
//            it.id==id
//        }
//        viewState.value=viewState.value.copy(selectedContact = contact)
//    }
//    fun onNavigateUp(){
//        viewState.value=viewState.value.copy(selectedContact = null)
//
//    }
