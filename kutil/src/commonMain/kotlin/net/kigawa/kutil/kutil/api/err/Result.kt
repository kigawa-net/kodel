package net.kigawa.kutil.kutil.api.err

sealed class Result<T, E> {
    abstract fun getErrorOrNull(): E?
    abstract fun getResultOrNull(): T?
}