package br.com.giovanne.ope_devtech

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

object AgendamentoService {
    val host = "https://sistema-agendamento-devtech.herokuapp.com"
    val TAG = "ws_lmsApp"
    fun getAgendamentos(context: Context): List<Agendamento> {

        val url = "$host/agenda"

        if (HttpHelper.hasActiveInternetConnection()){
            val json = HttpHelper.get(url)

            Log.d(TAG, json)
            var agendamentos = parserJson<List<Agendamento>>(json)
            /*
            for (c in agendamentos) {
                saveOffline(c)
            }
            */
            return agendamentos
        }
        else {
            val dao = DatabaseManager.getAgendamentosDAO()
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

    fun saveOffline (agendamento: Agendamento) {
        val dao = DatabaseManager.getAgendamentosDAO()
        if (! existe(agendamento)) {
            dao.insert(agendamento)
        }
    }

    fun existe(agendamento: Agendamento): Boolean {
        val dao = DatabaseManager.getAgendamentosDAO()
        return dao.getById(agendamento.identfication) != null
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}