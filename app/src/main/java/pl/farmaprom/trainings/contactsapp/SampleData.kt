package pl.farmaprom.trainings.contactsapp

import pl.farmaprom.trainings.contactsapp.contacts.data.Contact

//val CONTENT_TYPE = "application/json".toMediaType()
const val API_URL = "http://trainingcontactsapp-env.eba-x3t56ejz.eu-central-1.elasticbeanstalk.com/"
const val API_KEY = ""

val sampleData = listOf(
    Contact(
        id = 1L,
        name = "Golden",
        surname = "Kamper",
        email = "kamper@dog.com",
        phone = "123456",
        profileImageUrl = "https://raw.githubusercontent.com/kamilruchalaf/trainingassets/main/assets/face4.png",
        isFavourite = true
    ),
    Contact(
        id = 2L,
        name = "Tuchel",
        surname = "Wuefista",
        email = "tuchel@czelsi.com",
        phone = "553523532",
        profileImageUrl = "https://raw.githubusercontent.com/kamilruchalaf/trainingassets/main/assets/face4.png",
        isFavourite = false
    ),
    Contact(
        id = 3L,
        name = "Dominik",
        surname = "Barszcz",
        email = "DBarszczu@gmail.com",
        phone = "650056505",
        city = "Kraków",
        birthday = "3 czerwca",
        profileImageUrl = "https://raw.githubusercontent.com/kamilruchalaf/trainingassets/main/assets/face3.png",
        isFavourite = true
    ),
    Contact(
        id = 4L,
        name = "Dziki",
        surname = "Dzik",
        email = "Dzik@dziki.com",
        phone = "123456",
        profileImageUrl = "https://raw.githubusercontent.com/kamilruchalaf/trainingassets/main/assets/face3.png",
        isFavourite = false
    ),
    Contact(
        id = 5L,
        name = "Młody",
        surname = "Byk",
        email = "Dzik@dziki.com",
        phone = "123456",
        profileImageUrl = "https://raw.githubusercontent.com/kamilruchalaf/trainingassets/main/assets/face4.png",
        isFavourite = false
    ),
)
