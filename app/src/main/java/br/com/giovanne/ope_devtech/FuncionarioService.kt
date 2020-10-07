package br.com.giovanne.ope_devtech

import android.content.Context
import android.util.Log
import java.net.URL

object FuncionarioService {
    val host = "https://sistema-agendamento-devtech.herokuapp.com"
    val TAG = "ws_lmsApp"
    fun getFuncionarios(context: Context): List<Funcionario> {
        var funcionarios = mutableListOf<Funcionario>()
        val url = "$host/employees"
        val json = URL(url).readText()

        Log.d(TAG, json)


        return funcionarios
    }
}