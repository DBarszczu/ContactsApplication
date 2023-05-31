package pl.farmaprom.trainings.contactsapp.contacts.presentation.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.farmaprom.trainings.contactsapp.ui.theme.ContactsAppTheme


@Composable
fun ContactDetailsButton(
    imageVector: ImageVector,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(70.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.secondary),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            tint = Color.Black
        )
    }
}


@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ContactDetailsButtonPreview() {
    ContactsAppTheme {
        ContactDetailsButton(imageVector = Icons.Outlined.Email) {
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ContactDetailsButtonPreview2() {
    ContactsAppTheme {
        ContactDetailsButton(imageVector = Icons.Outlined.Call) {
        }
    }
}



