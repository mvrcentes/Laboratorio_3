package Laboratorio_3

data class ItemData(
  var originalPos: Int,
  var originalValue: Any,
  var type: String? = null,
  var info: String? = null
)
// -----------------------

fun main() {
  val result = processList(listOf(25, "Hola", null, false))
  println(result)
}

fun processList(inputList: List<Any?>?): ArrayList<ItemData>? {
  val lista = ArrayList<ItemData>()
  return inputList?.run {//se quito la función porque no era necesaria exactamente, solo era moder un moódulo (con la función solo se hubiera visto maás ordernado)
    for (i in inputList) {
      i?.let {
        when (i) { //se redujó el código por quitar funciones en donde se podía aprovechar mismo loop de `when`.
          is Int -> when {
            i % 10 == 0 -> lista.add(ItemData(inputList.indexOf(i), i, "Entero", "M10"))
            i % 5 == 0 -> lista.add(ItemData(inputList.indexOf(i), i, "Entero", "M5"))
            i % 2 == 0 -> lista.add(ItemData(inputList.indexOf(i), i, "Entero", "M2"))
            else -> lista.add(ItemData(inputList.indexOf(i), i, "Entero", null))
          }
          is String -> lista.add(ItemData(inputList.indexOf(i), i, "Cadena", "L${i.length}"))
          is Boolean -> lista.add(ItemData(inputList.indexOf(i), i, "Booleano", if (i == true) "Verdadero" else "Falso"))
          else -> lista.add(ItemData(inputList.indexOf(i), i, null, null))
        }
      }
    }
    return lista
  }
}
