package net.kigawa.kodel.domain.log.config.root

import net.kigawa.kodel.domain.log.config.LoggerConfigureDsl
import kotlin.reflect.KClass

class RootLoggerConfigureDsl: LoggerConfigureDsl() {

    @Suppress("unused")
    fun classConfig(clazz: KClass<*>, block: LoggerConfigureDsl.() -> Unit) {
        child(clazz.simpleName!!, block)
    }
}
