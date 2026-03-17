package net.kigawa.kodel.domain.log.config.formatter

import net.kigawa.kodel.domain.log.LogRow

interface LoggerFormatter {
    fun format(row: LogRow): String
}