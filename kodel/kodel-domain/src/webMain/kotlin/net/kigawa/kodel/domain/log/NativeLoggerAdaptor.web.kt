package net.kigawa.kodel.domain.log

@Suppress(names = ["EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING"])
actual object NativeLoggerAdaptor {
    actual fun getKogger(name: String): Kogger {
        return Kogger()
    }
}