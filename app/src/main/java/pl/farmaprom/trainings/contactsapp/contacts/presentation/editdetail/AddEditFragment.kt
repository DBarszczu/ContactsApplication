package pl.farmaprom.trainings.contactsapp.contacts.presentation.editdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import pl.farmaprom.trainings.contactsapp.R
import pl.farmaprom.trainings.contactsapp.contacts.data.Contact
import pl.farmaprom.trainings.contactsapp.contacts.presentation.detail.DetailFragmentArgs
import pl.farmaprom.trainings.contactsapp.ui.MainViewModel
import pl.farmaprom.trainings.contactsapp.ui.theme.ContactsAppTheme

class AddEditFragment : Fragment() {
    private val vieModel: MainViewModel by navGraphViewModels(R.id.nav)
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ComposeView>(R.id.compose_view).apply {
            setContent {
                setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
                val contactId = args.id
                val contact: Contact = vieModel.getContactsById(contactId)
                ContactsAppTheme {
                   AddEditScreen(contact = contact,
                       onNavigateCancel = {
                           findNavController().navigateUp()
                       })
                }
            }
        }
    }
}