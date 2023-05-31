package pl.farmaprom.trainings.contactsapp.contacts.presentation.editdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import pl.farmaprom.trainings.contactsapp.ui.theme.ContactsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextComponent(
    text: String,
    label: String,
    onTextChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = onTextChange,
        label = {
            Box(modifier = Modifier
                .background(Color.White)){
                Text(text = label)
            }
        }
    )
}



@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ComposablePreview() {
    ContactsAppTheme {
        EditTextComponent(text = "Dominik", onTextChange = {}, label = "Imię")

    }
}
