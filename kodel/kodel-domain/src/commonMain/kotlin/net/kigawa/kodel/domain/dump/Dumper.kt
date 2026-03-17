package net.kigawa.kodel.domain.dump

import kotlin.reflect.KClass
import kotlin.reflect.KProperty0

@Suppress("unused")
object Dumper {
    val strBuilder = StrDumpBuilder()
    fun dump(kClass: KClass<*>, vararg fields: DumpField) = DumpComponent(
        kClass.simpleName!!, fields
    )
}

@Suppress("unused")
infix fun <T> KProperty0<T>.with(block: (T) -> DumpComponent): DumpField = DumpField(
    this.name, block(this.get())
)

@Suppress("unused")
infix fun <T> KProperty0<T>.withStr(block: (T) -> String): DumpField = DumpField(
    this.name, DumpComponent(block(this.get()), emptyArray())
)
