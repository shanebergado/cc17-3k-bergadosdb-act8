package com.example.bookshelfapp

data class Book(
    val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    val title: String,
    val authors: List<String>?,
    val description: String?,
    val imageLinks: ImageLinks?,
    val infoLink: String? // This is the link you want to open

)

data class ImageLinks(
    val thumbnail: String
)