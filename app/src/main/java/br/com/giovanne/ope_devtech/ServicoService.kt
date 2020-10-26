package br.com.giovanne.ope_devtech

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

object ServicoService {
    val host = "https://sistema-agendamento-devtech.herokuapp.com"
    val TAG = "ws_lmsApp"
    fun getServicos(context: Context): List<Servico> {

        val url = "$host/prices"


        if (HttpHelper.hasActiveInternetConnection()){
            val json = HttpHelper.get(url)

            Log.d(TAG, json)
            var services = parserJson<List<Servico>>(json)

            for (s in services) {
                saveOffline(s)
            }

            return services
        }
        else {
            val dao = DatabaseManager.getServicoDAO()
            return dao.getAll()
        }
    }

    fun saveServicos(servico: Servico)  {
        val url = "$host/prices"


        if (HttpHelper.hasActiveInternetConnection()){
            val jsonCliente = GsonBuilder().create().toJson(servico)
            HttpHelper.post(url, jsonCliente)
        }
        else {
            val dao = DatabaseManager.getServicoDAO()
            dao.insert(servico)
        }

    }

    fun saveOffline (servico: Servico) {
        val dao = DatabaseManager.getServicoDAO()
        if (! existe(servico)) {
            dao.insert(servico)
        }
    }

    fun existe(servico: Servico): Boolean {
        val dao = DatabaseManager.getServicoDAO()
        return dao.getById(servico.id) != null
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}