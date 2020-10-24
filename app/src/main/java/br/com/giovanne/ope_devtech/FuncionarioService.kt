package br.com.giovanne.ope_devtech

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.net.URL

object FuncionarioService {
    val host = "https://sistema-agendamento-devtech.herokuapp.com"
    val TAG = "ws_lmsApp"
    fun getFuncionarios(context: Context): List<Funcionario> {

        val url = "$host/employees"
        val json = HttpHelper.get(url)

        Log.d(TAG, json)
        var funcionarios = parserJson<List<Funcionario>>(json)


        return funcionarios
        //val dao = DatabaseManager.getFuncionarioDAO()
        //return dao.getAll()
    }

    fun saveFuncionario(funcionario: Funcionario)  {
        val url = "$host/employees"
        val jsonFuncionario = GsonBuilder().create().toJson(funcionario)
        HttpHelper.post(url, jsonFuncionario)
        //val dao = DatabaseManager.getFuncionarioDAO()
        //dao.insert(funcionario)
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}