package br.com.giovanne.ope_devtech

import java.io.Serializable

class Funcionario: Serializable {

    var id: Long = 0
    var nome = ""
    var telefone = ""
    var foto = ""
    var usuario = ""
    var entrada = ""
    var saida = ""

    override fun toString(): String {
        return "$nome"
    }

}