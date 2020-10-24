package br.com.giovanne.ope_devtech

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

object ClienteService {
    val host = "https://sistema-agendamento-devtech.herokuapp.com"
    val TAG = "ws_lmsApp"
    fun getClientes(context: Context): List<Cliente> {

        val url = "$host/clients"
        val json = HttpHelper.get(url)

        Log.d(TAG, json)
        var clientes = parserJson<List<Cliente>>(json)


        return clientes
        //val dao = DatabaseManager.getFuncionarioDAO()
        //return dao.getAll()
    }

    fun saveCliente(cliente: Cliente)  {
        val url = "$host/clients"
        val jsonCliente = GsonBuilder().create().toJson(cliente)
        HttpHelper.post(url, jsonCliente)
        //val dao = DatabaseManager.getFuncionarioDAO()
        //dao.insert(funcionario)
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}