package pl.farmaprom.trainings.contactsapp.contacts.presentation.detail

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import pl.farmaprom.trainings.contactsapp.R
import pl.farmaprom.trainings.contactsapp.contacts.data.Contact
import pl.farmaprom.trainings.contactsapp.ui.MainViewModel
import pl.farmaprom.trainings.contactsapp.ui.theme.ContactsAppTheme
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class DetailFragment : Fragment() {

    private val vieModel: MainViewModel by navGraphViewModels(R.id.nav)
    private val args: DetailFragmentArgs by navArgs()

    private lateinit var permissionsLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionsLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
                if (isGranted) {
                    requestCall()
                } else {
                    Toast.makeText(requireContext(), "abc", Toast.LENGTH_LONG).show()
                }
            }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    private fun exportContactToTxt(contact: Contact) {
        val fileName = "contact.txt"
        val fileContent = buildString {
            append("Name: ${contact.name}\n")
            append("Surname: ${contact.surname}\n")
            append("Email: ${contact.email}\n")
            append("Phone: ${contact.phone}\n")
            append("City: ${contact.city}\n")
            append("Birthday: ${contact.birthday}\n")
        }

        try {
            val file = File(requireContext().filesDir, fileName)
            file.writeText(fileContent)
            Toast.makeText(requireContext(), "Contact exported successfully", Toast.LENGTH_SHORT)
                .show()
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Failed to export contact", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ComposeView>(R.id.compose_view).apply {
            setContent {
                setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
                val contactId = args.id
                val contact: Contact = vieModel.getContactsById(contactId)
                ContactsAppTheme {
                    DetailsScreen(
                        contact = contact,
                        onNavigateUp = {
                            findNavController().navigateUp()
                        },
                        onNavigate = {
                            contactId
                            findNavController().navigate(
                                DetailFragmentDirections.actionDetailFragmentToAddEditFragment(
                                    contactId
                                )
                            )
                        },
                        onCallRequested = { requestCallWithPermission() },
                        onExportClicked = { exportContactToFile(requireContext(), contact) }
                    )
                }
            }
        }
    }

    private fun requestCallWithPermission() {
        when {
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CALL_PHONE
            ) == PackageManager.PERMISSION_GRANTED -> {
                requestCall()
            }

            shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE) -> {
                Toast.makeText(requireContext(), "Because we need it", Toast.LENGTH_LONG).show()
            }


            else -> permissionsLauncher.launch(Manifest.permission.CALL_PHONE)
        }
    }


    private fun requestCall() {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$123456789")
        }
        startActivity(intent)
    }

    private fun exportContactToFile(context: Context, contact: Contact) {
        val fileName = "contact_${contact.id}.txt"
        val fileContents = "Name: ${contact.name}\n" +
                "Surname: ${contact.surname}\n" +
                "Email: ${contact.email}\n" +
                "Phone: ${contact.phone}\n" +
                "City: ${contact.city}\n" +
                "Birthday: ${contact.birthday}"

        try {
            val file = File(context.filesDir, fileName)
            val fos = FileOutputStream(file)
            fos.write(fileContents.toByteArray())
            fos.close()

            Toast.makeText(context, "Contact exported to $fileName", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            e.printStackTrace()

            Toast.makeText(context, "Failed to export contact", Toast.LENGTH_SHORT).show()
        }
    }
}