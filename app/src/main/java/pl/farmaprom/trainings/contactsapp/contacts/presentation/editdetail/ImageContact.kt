package pl.farmaprom.trainings.contactsapp.contacts.presentation.editdetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import pl.farmaprom.trainings.contactsapp.R
import pl.farmaprom.trainings.contactsapp.ui.theme.ContactsAppTheme

@Composable
fun ImageContact(
    profileImageUrl: String?
) {
    val resolvedUrl = profileImageUrl ?: R.drawable.ic_launcher_background

    Box(modifier = Modifier.padding(15.dp), Alignment.Center){
        GlideImage(
            modifier = Modifier
                .blur(2.dp)
                .size(115.dp)
                .clip(CircleShape),
            imageModel = { resolvedUrl },
            previewPlaceholder = R.drawable.ic_launcher_background,
            imageOptions = ImageOptions(
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            )
        )
        Icon(
            modifier = Modifier.size(50.dp),
            imageVector = Icons.Outlined.Edit,
            contentDescription ="" )
    }



}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ImageContactPreview() {
    ContactsAppTheme {
        ImageContact(profileImageUrl = null)
    }

}