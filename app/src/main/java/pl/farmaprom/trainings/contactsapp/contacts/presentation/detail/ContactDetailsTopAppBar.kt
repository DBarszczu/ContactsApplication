package pl.farmaprom.trainings.contactsapp.contacts.presentation.detail

import androidx.compose.animation.animateColorAsState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import pl.farmaprom.trainings.contactsapp.ui.theme.ContactsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactDetailsTopAppBar(
    isFavourite: Boolean,
    onNavigateBackClick: () -> Unit,
    onFavouriteClick: (Boolean) -> Unit,

) {
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.secondary),
        title = {},

        navigationIcon = {
            IconButton(
                modifier = Modifier,
                onClick = {
                    onNavigateBackClick.invoke()
                }
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        },
        actions = {
            IconButton(
                modifier = Modifier,
                onClick = {
                    onFavouriteClick.invoke(!isFavourite)
                }
            ) {
                val icon = if (isFavourite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder
                val color = animateColorAsState(targetValue = getFavouriteIconColor(isFavourite))
                Icon(imageVector = icon, tint = color.value, contentDescription = null)
            }

        }
    )
}

@Composable
private fun getFavouriteIconColor(isFavourite: Boolean) =
    if (isFavourite) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.onBackground

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ContactDetailsTopAppBarPreviewFavorite() {
    ContactsAppTheme {
        ContactDetailsTopAppBar(
            isFavourite = true,
            onNavigateBackClick = { },
            onFavouriteClick = {}
        )
    }
}
@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun ContactDetailsTopAppBarPreview() {
    ContactsAppTheme {
        ContactDetailsTopAppBar(
            isFavourite = false,
            onNavigateBackClick = { },
            onFavouriteClick = {}
        )
    }
}
