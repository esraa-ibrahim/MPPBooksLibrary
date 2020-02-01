import kotlinx.serialization.Serializable

@Serializable
data class BookInfo(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int = 0
)

@Serializable
data class Item(
    val etag: String,
    val id: String,
    val kind: String,
    val selfLink: String,
    val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    val allowAnonLogging: Boolean,
    val authors: List<String>,
    val averageRating: Double = 0.0,
    val canonicalVolumeLink: String,
    val categories: List<String>,
    val contentVersion: String,
    val description: String,
    val imageLinks: ImageLinks,
    val industryIdentifiers: List<IndustryIdentifier>,
    val infoLink: String,
    val language: String,
    val maturityRating: String,
    val pageCount: Int = 0,
    val panelizationSummary: PanelizationSummary,
    val previewLink: String,
    val printType: String,
    val publishedDate: String,
    val publisher: String,
    val ratingsCount: Int = 0,
    val readingModes: ReadingModes,
    val title: String
)

@Serializable
data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String
)

@Serializable
data class IndustryIdentifier(
    val identifier: String,
    val type: String
)

@Serializable
data class PanelizationSummary(
    val containsEpubBubbles: Boolean,
    val containsImageBubbles: Boolean
)

@Serializable
data class ReadingModes(
    val image: Boolean,
    val text: Boolean
)