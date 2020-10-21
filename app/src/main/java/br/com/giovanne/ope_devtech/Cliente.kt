package br.com.giovanne.ope_devtech

import java.io.Serializable

class Cliente: Serializable {
    var id:Long = 0
    var entityId = ""
    var name = ""
    var phone = ""
    var login = ""
    var password = ""

    override fun toString(): String {
        return "$name"
    }
}