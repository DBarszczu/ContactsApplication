package pl.farmaprom.trainings.contactsapp.contacts.presentation.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.farmaprom.trainings.contactsapp.ui.theme.ContactsAppTheme
import pl.farmaprom.trainings.contactsapp.ui.theme.Dimens

@Composable
fun KeyValueItem(
    key: String,
    value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = Dimens.small),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = key,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.tertiary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
@Preview(name = "KeyValueItem", showBackground = true, device = Devices.PIXEL_4)
fun KeyValueItemPreview() {
    ContactsAppTheme {
        KeyValueItem(key = "Adres email", value = "DBarszcz@gmail.com")
    }
}
