package pl.farmaprom.trainings.contactsapp.contacts.presentation.editdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.farmaprom.trainings.contactsapp.R
import pl.farmaprom.trainings.contactsapp.contacts.data.Contact
import pl.farmaprom.trainings.contactsapp.sampleData
import pl.farmaprom.trainings.contactsapp.ui.theme.ContactsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditScreen(
    contact: Contact,
    onNavigateCancel: () -> Unit = {},
    onNavigateReady: () -> Unit = {}
) {
    Scaffold(topBar = {
        AddEditTopAppBar(
            text1 = "Anuluj", onNavigateCancel = {
                onNavigateCancel.invoke()
            },
            text2 = "Gotowe", onnavigateDone = {
                onNavigateReady.invoke()

            })
    }
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    ImageContact(
                        profileImageUrl = contact.profileImageUrl,

                        )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(modifier = Modifier.weight(2f)) {
                        EditTextComponent(
                            label = stringResource(id = R.string.name),
                            text = contact.name,
                            onTextChange = {})
                        EditTextComponent(
                            label = stringResource(id = R.string.Surname),
                            text = contact.surname,
                            onTextChange = {})
                    }
                }
            }
            item {
                EditTextComponent(
                    label = stringResource(id = R.string.Email),
                    text = contact.email,
                    onTextChange = {})
                EditTextComponent(
                    label = stringResource(id = R.string.Phone),
                    text = "+48 " + contact.phone,
                    onTextChange = {})
                EditTextComponent(
                    label = stringResource(id = R.string.City),
                    text = contact.city,
                    onTextChange = {})
                EditTextComponent(
                    label = stringResource(id = R.string.Birthday),
                    text = contact.birthday,
                    onTextChange = {})
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun AddEditScreenPreview() {
    ContactsAppTheme {
        AddEditScreen(contact = sampleData[2])

    }

}