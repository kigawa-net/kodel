package net.kigawa.kodel.domain.log.config.handler

import net.kigawa.kodel.domain.log.LogLevel
import net.kigawa.kodel.domain.log.config.formatter.LoggerFormatter
import net.kigawa.kodel.domain.log.handler.LoggerHandler

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class HandlerConfig(
    formatter: LoggerFormatter?,
    level: LogLevel?,
    loggerHandler: (config: HandlerConfig) -> LoggerHandler,
): HandlerConfigCommon {
    override fun createLoggerHandler(): LoggerHandler
}