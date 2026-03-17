package net.kigawa.kodel.domain.log.config

import net.kigawa.kodel.domain.log.handler.LoggerHandler
import net.kigawa.kodel.domain.log.LogLevel
import net.kigawa.kodel.domain.log.config.formatter.LoggerFormatter
import net.kigawa.kodel.domain.log.config.handler.HandlerConfig

class LoggerHandlerDsl {

    var formatter: LoggerFormatter? = null
    var level: LogLevel? = null
    fun asHandlerConfig(loggerHandler: (config: HandlerConfig) -> LoggerHandler) = HandlerConfig(
        formatter = formatter,
        level = level,
        loggerHandler = loggerHandler
    )
}
