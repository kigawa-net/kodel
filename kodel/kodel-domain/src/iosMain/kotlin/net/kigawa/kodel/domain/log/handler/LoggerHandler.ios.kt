package net.kigawa.kodel.domain.log.handler

import net.kigawa.kodel.domain.log.LogLevel

@Suppress(names = ["EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING"])
actual interface LoggerHandler {
    fun log(msg: () -> String, logLevel: LogLevel)
}
