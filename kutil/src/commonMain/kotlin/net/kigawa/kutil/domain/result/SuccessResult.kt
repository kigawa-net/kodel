package net.kigawa.kutil.domain.result

class SuccessResult<T>(
    private val result: T,
) : Result<T, Any>() {
    override fun getErrorOrNull(): Any? = null

    override fun getResultOrNull(): T = result
}