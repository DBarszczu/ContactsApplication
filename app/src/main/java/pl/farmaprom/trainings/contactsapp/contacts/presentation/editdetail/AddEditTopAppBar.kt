package pl.farmaprom.trainings.contactsapp.contacts.presentation.editdetail


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text

import pl.farmaprom.trainings.contactsapp.ui.theme.ContactsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditTopAppBar(
    text1: String,
    text2: String,
    onNavigateCancel: () -> Unit,
    onnavigateDone: () -> Unit,
) {
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.secondary),
        title = {},
        actions = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(
                    modifier = Modifier.padding(start = 8.dp),
                    onClick = { onNavigateCancel.invoke() }
                ) {
                    Text(
                        text = "Cancel")
                }
                TextButton(
                    modifier = Modifier.padding(end = 8.dp),
                    onClick = { onnavigateDone.invoke() }
                ) {
                    Text(text = "Done")
                }
            }
        }
    )
}







@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun AddEditTopAppBarPreview() {
    ContactsAppTheme {
        AddEditTopAppBar(text1 = "Anuluj", onNavigateCancel = {}, text2 = "Gotowe", onnavigateDone = {})


    }
}

