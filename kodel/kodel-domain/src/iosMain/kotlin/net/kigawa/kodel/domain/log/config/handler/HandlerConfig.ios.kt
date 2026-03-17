package net.kigawa.kodel.domain.log.config.handler

import net.kigawa.kodel.domain.log.LogLevel
import net.kigawa.kodel.domain.log.config.formatter.LoggerFormatter
import net.kigawa.kodel.domain.log.handler.LoggerHandler

@Suppress(names = ["EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING"])
actual class HandlerConfig actual constructor(
    formatter: LoggerFormatter?, level: LogLevel?,
    val loggerHandler: (config: HandlerConfig) -> LoggerHandler,
): HandlerConfigCommon(formatter, level) {
    actual override fun createLoggerHandler(): LoggerHandler {
        return loggerHandler(this)
    }
}