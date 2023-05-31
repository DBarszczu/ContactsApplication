@file:OptIn(ExperimentalMaterial3Api::class)

package pl.farmaprom.trainings.contactsapp.contacts.presentation.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.farmaprom.trainings.contactsapp.R
import pl.farmaprom.trainings.contactsapp.contacts.data.Contact
import pl.farmaprom.trainings.contactsapp.sampleData
import pl.farmaprom.trainings.contactsapp.ui.theme.ContactsAppTheme
import pl.farmaprom.trainings.contactsapp.ui.theme.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    contact: Contact,
    onNavigateUp: () -> Unit = {},
    onNavigate: (id: Long) -> Unit = {},
    onToggleFavoriteClick: () -> Unit = {},
    onCallRequested: () -> Unit = {},
    onExportClicked: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            ContactDetailsTopAppBar(
                isFavourite = contact.isFavourite,
                onNavigateBackClick = { onNavigateUp.invoke() },
                onFavouriteClick = { onToggleFavoriteClick.invoke() }
            )
        },
        floatingActionButton = {
            ContactsDetailsFloatingActionButton(
                contentColor = Color.Black,
                onNavigateClick = { onNavigate.invoke(contact.id) },
                containerColor = MaterialTheme.colorScheme.secondary,
                text = "Edytuj"
            )
        }
    )
    {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .padding(Dimens.medium)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                ContactInfoItem(
                    imageUrl = contact.profileImageUrl,
                    name = contact.name,
                    surname = contact.surname
                )
            }
            item {
                Row {
                    ActionItem(
                        image = Icons.Outlined.Call,
                        onClick = onCallRequested
                    )
                    Spacer(modifier = Modifier.padding(14.dp))
                    ActionItem(
                        image = Icons.Outlined.Email,
                        onClick = onCallRequested
                    )

                }
            }
            item {
                ContactData(contact = contact)
            }
            item {
                TextButton(
                    onClick = { onExportClicked.invoke() },
                ) {
                    Text(text = "Export Contact")
                }
            }


        }
    }
}


@Composable
private fun ContactData(contact: Contact) {
    Column {
        KeyValueItem(key = stringResource(id = R.string.Email), value = contact.email)
        KeyValueItem(key = stringResource(id = R.string.Phone), value = contact.phone)
        KeyValueItem(key = stringResource(id = R.string.City), value = contact.city)
        KeyValueItem(key = stringResource(id = R.string.Birthday), value = contact.birthday)
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
    ContactsAppTheme {
        DetailsScreen(
            contact = sampleData[2]
        )
    }
}
