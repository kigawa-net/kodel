@file:Suppress("unused")

package net.kigawa.kutil.kutil.api.list

object KutilList {
  fun <T> connectList(vararg list: List<T>): List<T> {
    return list.toList().flatMap { it }
  }
}
