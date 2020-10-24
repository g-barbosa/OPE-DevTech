package br.com.giovanne.ope_devtech

import java.io.Serializable

class Produto: Serializable {
    var id:Long = 0
    var entityId = ""
    var description = ""
    var quantity = ""
    var value = ""

    override fun toString(): String {
        return "$description"
    }
}