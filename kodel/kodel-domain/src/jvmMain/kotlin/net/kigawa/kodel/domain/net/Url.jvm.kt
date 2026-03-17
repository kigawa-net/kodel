package net.kigawa.kodel.domain.net

import java.net.URI
import java.net.URL

@Suppress(names = ["EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING", "unused"])
actual class Url(
    private val uri: URI,
): UrlBase {
    @Suppress("unused")
    fun toJvmUrl(): URL = uri.toURL()

    actual companion object {
        @Suppress("unused")
        actual fun parse(strUrl: String): Url {
            return Url(URI(strUrl))
        }
    }


    actual override fun setPath(path: String): Url {
        return Url(URI(uri.scheme, uri.userInfo, uri.host, uri.port, path, uri.query, uri.fragment))
    }

    actual override fun toStrUrl(): String = uri.toString()

    actual override fun toString(): String = toStrUrl()

    actual override val path: String
        get() = uri.path
}
