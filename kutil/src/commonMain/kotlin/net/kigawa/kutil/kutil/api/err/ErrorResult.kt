package net.kigawa.kutil.kutil.api.err

class ErrorResult<E>(private val err: E) : Result<Any, E>() {
    override fun getErrorOrNull(): E = err

    override fun getResultOrNull(): Any? = null
}