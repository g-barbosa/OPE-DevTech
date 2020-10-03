package br.com.giovanne.ope_devtech

import java.io.Serializable

class Disciplina: Serializable {

    var id: Long = 0
    var nome = ""
    var ementa = ""
    var foto = ""
    var professor = ""

    override fun toString(): String {
        return "$nome"
    }

}