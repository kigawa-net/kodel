package net.kigawa.kodel.domain.log

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect object NativeLoggerAdaptor {
    fun getKogger(name: String): Kogger
}