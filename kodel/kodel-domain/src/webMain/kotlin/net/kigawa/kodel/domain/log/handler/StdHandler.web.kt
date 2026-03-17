package net.kigawa.kodel.domain.log.handler

import net.kigawa.kodel.domain.log.LogLevel
import net.kigawa.kodel.domain.log.config.handler.HandlerConfig

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING", "unused")
actual class StdHandler actual constructor(handlerConfig: HandlerConfig):
    LoggerHandler {
    override fun log(msg: () -> String, logLevel: LogLevel) {
        println(msg())
    }
}
