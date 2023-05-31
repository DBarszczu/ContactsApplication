package pl.farmaprom.trainings.contactsapp.contacts.presentation.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.farmaprom.trainings.contactsapp.ui.theme.ContactsAppTheme

@Composable
fun ActionItem(
    modifier: Modifier = Modifier,
    image: ImageVector,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.clickable {
            onClick.invoke()
        },
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Icon(
            modifier = Modifier
                .padding(8.dp)
                .size(50.dp),
            imageVector = (image),
            contentDescription = ""
        )
    }
}


@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ActionItemPreview() {
    ContactsAppTheme {
        ActionItem(image = Icons.Outlined.Home)

    }

}