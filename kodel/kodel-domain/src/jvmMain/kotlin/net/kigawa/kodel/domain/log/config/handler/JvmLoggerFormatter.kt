package net.kigawa.kodel.domain.log.config.handler

import net.kigawa.kodel.domain.log.LogRow
import net.kigawa.kodel.domain.log.config.formatter.LoggerFormatter
import java.util.logging.Formatter
import java.util.logging.LogRecord

class JvmLoggerFormatter(
    val formatter: LoggerFormatter,
): Formatter() {


    override fun format(p0: LogRecord?): String? {
        return p0?.let { formatter.format(LogRow.fromJvm(it)) }
    }
}