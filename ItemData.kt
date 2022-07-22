package com.example.laboratorio_3

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

fun processList(inputList: List<Any?>?): List<ItemData>? {
    val lista = ArrayList<ItemData>()

    if(inputList == null){
        return null
    } else if (inputList.isEmpty()){
        return emptyList()
    } else {
        for (i in inputList) {
            if (i != null) lista.add(ItemData(inputList.indexOf(i), i, typeItem(i), infoItem(i))) else null
        }
    }
    return lista
}

fun typeItem(item: Any): String? {
    return when(item){
        is Int -> "Entero"
        is String -> "Cadena"
        is Boolean -> "Booleano"
        else -> null
    }
}

fun infoItem(item: Any): String? {
    if(item is Int){
        return when {
            item % 10 == 0 -> "M10"
            item % 5 == 0 -> "M5"
            item % 2 == 0 -> "M2"
            else -> null
        }
    } else if(item is String){
        return "l" + item.length
    } else if(item is Boolean){
        return if(item == true) {
            "Verdadero"
        } else {
            "Falso"
        }
    } else {
        return null
    }
}