package br.com.giovanne.ope_devtech

import java.io.Serializable

class Servico: Serializable {
    var id:Long = 0
    var entityId = ""
    var description = ""
    var value = ""

    override fun toString(): String {
        return "$description"
    }
}