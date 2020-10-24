package br.com.giovanne.ope_devtech

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

object FinancasService {
    val host = "https://sistema-agendamento-devtech.herokuapp.com"
    val TAG = "ws_lmsApp"
    fun getFinances(context: Context): Financas {

        val url = "$host/finances"
        val json = HttpHelper.get(url)

        Log.d(TAG, json)
        var financas = parserJson<Financas>(json)


        return financas
        //val dao = DatabaseManager.getFuncionarioDAO()
        //return dao.getAll()
    }

    fun saveFinances(financas: Financas)  {
        val url = "$host/finances"
        val jsonCliente = GsonBuilder().create().toJson(financas)
        HttpHelper.post(url, jsonCliente)
        //val dao = DatabaseManager.getFuncionarioDAO()
        //dao.insert(funcionario)
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}