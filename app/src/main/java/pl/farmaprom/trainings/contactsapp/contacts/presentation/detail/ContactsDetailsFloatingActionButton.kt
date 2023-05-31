package pl.farmaprom.trainings.contactsapp.contacts.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text
import pl.farmaprom.trainings.contactsapp.ui.theme.Blue500
import pl.farmaprom.trainings.contactsapp.ui.theme.ContactsAppTheme


@Composable
fun ContactsDetailsFloatingActionButton(
    onNavigateClick: () -> Unit,
    contentColor: Color,
   containerColor: Color,
    text: String
) {
    FloatingActionButton(
        modifier = Modifier
            .height(46.dp)
            .width(66.dp),
        shape = RoundedCornerShape(percent = 25),
        onClick = { onNavigateClick() },
        contentColor = contentColor,
        containerColor = MaterialTheme.colorScheme.secondary
    ) {
        Text(text = text)
    }
}



@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ContactsDetailsFloatingActionButtonPreview() {
    ContactsAppTheme {
        ContactsDetailsFloatingActionButton(
            onNavigateClick = {},
            contentColor = Color.Black,
            containerColor = MaterialTheme.colorScheme.secondary,
            text = "Edytuj",

        )
    }
}
