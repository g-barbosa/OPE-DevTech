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

        if (HttpHelper.hasActiveInternetConnection()){
            val json = HttpHelper.get(url)

            Log.d(TAG, json)
            var financas = parserJson<Financas>(json)

            saveOffline(financas)
            return financas
        }
        else {
            val dao = DatabaseManager.getFinancasDAO()
            return dao.getAll()
        }
    }

    fun saveFinances(financas: Financas)  {
        val url = "$host/finances"


        if (HttpHelper.hasActiveInternetConnection()){
            val jsonCliente = GsonBuilder().create().toJson(financas)
            HttpHelper.post(url, jsonCliente)
        }
        else {
            val dao = DatabaseManager.getFinancasDAO()
            dao.insert(financas)
        }

    }

    fun saveOffline (financas: Financas) {
        val dao = DatabaseManager.getFinancasDAO()
        if (! existe(financas)) {
            dao.insert(financas)
        }
    }

    fun existe(financas: Financas): Boolean {
        val dao = DatabaseManager.getFinancasDAO()
        return dao.getById(financas.id) != null
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}