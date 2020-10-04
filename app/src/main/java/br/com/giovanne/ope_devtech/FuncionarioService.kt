package br.com.giovanne.ope_devtech

import android.content.Context

object FuncionarioService {
    fun getFuncionarios(context: Context): List<Funcionario> {
        var funcionarios = mutableListOf<Funcionario>()

        for (i in 1..10) {
            val d = Funcionario()
            d.nome = "Nome $i"
            d.telefone = "Telefone $i"
            d.usuario = "Username $i"
            d.foto = "https://static.vecteezy.com/system/resources/previews/000/643/109/non_2x/vector-people-user-icon.jpg"
            funcionarios.add(d)
        }
        return funcionarios
    }
}