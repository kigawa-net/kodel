package net.kigawa.kutil.domain.serializable

import io.ktor.http.URLBuilder
import io.ktor.http.Url
import io.ktor.http.appendEncodedPathSegments
import io.ktor.http.parseUrl
import net.kigawa.kutil.domain.AbstractUrl
import net.kigawa.kutil.domain.exception.UrlParseException

class SerializableUrl(
    private val url: Url,
) : AbstractUrl() {
    companion object {
        fun parse(strUrl: String): SerializableUrl {
            val url = parseUrl(strUrl) ?: throw UrlParseException("invalid url $strUrl")
            return SerializableUrl(url)
        }
    }

    fun toKtorUrl() = url
    fun appendPath(path: String) = URLBuilder(toKtorUrl())
        .appendEncodedPathSegments(path)
        .build()
        .let { SerializableUrl(it) }
}