package net.kigawa.kutil.kutil.api.err

class SuccessResult<T>(
    private val result: T,
) : Result<T, Any>() {
    override fun getErrorOrNull(): Any? = null

    override fun getResultOrNull(): T = result
}