import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json

class BooksApi {
    private val httpClient = HttpClient()

    @UnstableDefault
    suspend fun getBookByISBN(bookId: String, success: (VolumeInfo) -> Unit, failure: (Throwable?) -> Unit) {
        try {
            val url = "https://www.googleapis.com/books/v1/volumes?q=isbn:$bookId"
            val json = httpClient.get<String>(url)
            Json.nonstrict.parse(BookInfo.serializer(), json)
                .items[0].volumeInfo
                .also(success)
        } catch (ex: Exception) {
            failure(ex)
        }
    }
}