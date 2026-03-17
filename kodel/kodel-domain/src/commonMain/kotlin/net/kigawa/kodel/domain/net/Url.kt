package net.kigawa.kodel.domain.net

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class Url: UrlBase {
    override val path: String
    override fun setPath(path: String): Url
    override fun toStrUrl(): String
    override fun toString(): String

    companion object {
        @Suppress("unused")
        fun parse(strUrl: String): Url
    }
}
