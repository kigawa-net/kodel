package net.kigawa.kutil.kutil.api.list


@Suppress("unused")
fun <E> Collection<E>.containsIf(filter: (E) -> Boolean): Boolean {
  forEach { element ->
    if (filter(element)) return true
  }
  return false
}

@Suppress("unused")
fun <E, R : Any> Collection<E>.firstOrNullMap(transform: (E) -> R?): R? {
  forEach { element ->
    val result = transform(element)
    if (result != null) return result
  }
  return null
}
