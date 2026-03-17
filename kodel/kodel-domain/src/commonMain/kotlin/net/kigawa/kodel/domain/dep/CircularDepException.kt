package net.kigawa.kodel.domain.dep

import kotlin.reflect.KClass

class CircularDepException(
    val depClasses: List<KClass<*>>,
): IllegalStateException(
    "circular dependency ${depClasses.joinToString(" ->", transform = { it.simpleName ?: "unknown" })}"
) {
}
