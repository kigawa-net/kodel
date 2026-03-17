package net.kigawa.kodel.domain.log.config.handler

import net.kigawa.kodel.domain.log.LogLevel
import net.kigawa.kodel.domain.log.config.formatter.LoggerFormatter
import net.kigawa.kodel.domain.log.handler.LoggerHandler

abstract class HandlerConfigCommon(
    val formatter: LoggerFormatter?,
    val level: LogLevel?,
) {
    abstract fun createLoggerHandler(): LoggerHandler
}
