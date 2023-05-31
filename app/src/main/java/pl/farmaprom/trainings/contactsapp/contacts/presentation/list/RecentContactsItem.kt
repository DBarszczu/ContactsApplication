import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun RecentContactsItem(
    id: Long,
    profileImageUrl: String?,
    name: String,
    onContactClicked: (id: Long) -> Unit = {}
) {
    val resolvedUrl = profileImageUrl ?: R.drawable.ic_launcher_background
    Column(
        modifier = Modifier
            .width(120.dp)
            .height(120.dp)
            .clickable {
                onContactClicked.invoke(id)
            }
            .background(
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(16.dp),

                ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
           horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            GlideImage(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape),
                imageModel = { resolvedUrl },
                previewPlaceholder = R.drawable.ic_launcher_background,
                imageOptions = ImageOptions(
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = name,
                style = MaterialTheme.typography.headlineSmall
            )
        }

    }
}



@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun RecentContactsItemPreview() {
    ContactsAppTheme {
        RecentContactsItem(
            id = 1L,
            profileImageUrl = null,
            name = "Prewiew" )
    }
}