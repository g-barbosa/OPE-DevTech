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
            d.foto = "https://i.pinimg.com/originals/75/4d/3e/754d3e92bf084b365537a6bb255f13f8.png"
            funcionarios.add(d)
        }
        return funcionarios
    }
}