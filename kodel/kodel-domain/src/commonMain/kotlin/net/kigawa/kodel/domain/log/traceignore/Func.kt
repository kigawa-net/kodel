package net.kigawa.kodel.domain.log.traceignore

import net.kigawa.kodel.domain.log.Kogger
import net.kigawa.kodel.domain.log.fine
import net.kigawa.kodel.domain.log.severe
import net.kigawa.kodel.domain.log.warning


fun Kogger.debug(msg: String) = fine(msg)

@Suppress("unused")
fun Kogger.debug(msg: () -> String) = fine(msg)

@Suppress("unused")


fun Kogger.warn(msg: String) = warning(msg)

@Suppress("unused")
fun Kogger.warn(msg: () -> String) = warning(msg)


fun Kogger.error(msg: String, e: Throwable? = null) {
    severe(msg)
    e?.printStackTrace()
}

fun Kogger.error(msg: () -> String, e: Throwable? = null) {
    severe(msg)
    e?.printStackTrace()
}
