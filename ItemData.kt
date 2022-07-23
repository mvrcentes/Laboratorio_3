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
  return inputList?.run {
    for (i in inputList) {
      i?.let {
        when (i) {
          is Int -> when {
            i % 10 == 0 -> lista.add(ItemData(inputList.indexOf(i), i, "Entero", "M10"))
            i % 5 == 0 -> lista.add(ItemData(inputList.indexOf(i), i, "Entero", "M5"))
            i % 2 == 0 -> lista.add(ItemData(inputList.indexOf(i), i, "Entero", "M2"))
            else -> lista.add(ItemData(inputList.indexOf(i), i, "Entero", null))
          }
          is String -> lista.add(ItemData(inputList.indexOf(i), i, "Cadena", "L${i.length}"))
          is Boolean -> lista.add(
            ItemData(inputList.indexOf(i), i, "Booleano", if (i == true) "Verdadero" else "Falso"))
          else -> lista.add(ItemData(inputList.indexOf(i), i, null, null))
        }
        //typeItem(i, inputList.indexOf(i))?.let { it1 -> lista.add(it1) } }
      }
    }
    return lista
  }
}


fun typeItem(item: Any, idx: Int): ItemData? {
  return when(item){
    is Int -> return when {
      item % 10 == 0 -> ItemData(idx, item, "Entero", "M10")
      item % 5 == 0 -> ItemData(idx, item, "Entero", "M5")
      item % 2 == 0 -> ItemData(idx, item, "Entero", "M2")
      else -> ItemData(idx, item, "Entero" ,null)
    }
    is String -> ItemData(idx, item, "Cadena", "L${item.length}")
    is Boolean -> ItemData(idx, item, "Booleano", if(item == true) "Verdadero" else "Falso")
    else -> ItemData(idx, item, null, null)
  }
}

//fun infoItem(item: Any): String? {
//  return if(item is Int){
//    when {
//      item % 10 == 0 -> "M10"
//      item % 5 == 0 -> "M5"
//      item % 2 == 0 -> "M2"
//      else -> null
//    }
//  } else if(item is String){
//    "L${item.length}"
//  } else if(item is Boolean){
//    return if(item == true) "Verdadero" else "Falso"
//  } else {
//    null
//  }
//}