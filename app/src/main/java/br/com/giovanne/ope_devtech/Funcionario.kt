package br.com.giovanne.ope_devtech

import java.io.Serializable

class Funcionario: Serializable {

    var entityId = ""
    var name = ""
    var phone = ""
    var foto = ""
    var login = ""
    var starts = ""
    var ends = ""
    var password = ""

    override fun toString(): String {
        return "$name"
    }

}