package net.kigawa.kutil.kutil.api.str.objectformatter

class DefaultObjFormatter : ObjectFormatter {
  override fun format(obj: Any?): String {
    return when (obj) {
      is String -> obj
      is Array<*> -> "[${obj.joinToString(", ") { format(it) }}]"
      else -> obj.toString()
    }
  }
}