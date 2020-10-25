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

        if (HttpHelper.hasActiveInternetConnection()){
            val json = HttpHelper.get(url)

            Log.d(TAG, json)
            var clientes = parserJson<List<Cliente>>(json)

            for (c in clientes) {
                saveOffline(c)
            }

            return clientes
        }
        else {
            val dao = DatabaseManager.getClienteDAO()
            return dao.getAll()
        }
    }

    fun saveCliente(cliente: Cliente)  {
        val url = "$host/clients"


        if (HttpHelper.hasActiveInternetConnection()){
            val jsonCliente = GsonBuilder().create().toJson(cliente)
            HttpHelper.post(url, jsonCliente)
        }
        else {
            val dao = DatabaseManager.getClienteDAO()
            dao.insert(cliente)
        }

    }

    fun saveOffline (cliente: Cliente) {
        val dao = DatabaseManager.getClienteDAO()
        if (! existe(cliente)) {
            dao.insert(cliente)
        }
    }

    fun existe(cliente: Cliente): Boolean {
        val dao = DatabaseManager.getServicoDAO()
        return dao.getById(cliente.id) != null
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}