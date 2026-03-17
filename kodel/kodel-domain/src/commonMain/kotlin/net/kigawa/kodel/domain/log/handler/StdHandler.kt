package net.kigawa.kodel.domain.log.handler

import net.kigawa.kodel.domain.log.config.handler.HandlerConfig

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class StdHandler(handlerConfig: HandlerConfig): LoggerHandler
