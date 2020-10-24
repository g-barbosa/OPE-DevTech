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
        val json = HttpHelper.get(url)

        Log.d(TAG, json)
        var services = parserJson<List<Servico>>(json)


        return services
        //val dao = DatabaseManager.getFuncionarioDAO()
        //return dao.getAll()
    }

    fun saveServicos(servico: Servico)  {
        val url = "$host/prices"
        val jsonCliente = GsonBuilder().create().toJson(servico)
        HttpHelper.post(url, jsonCliente)
        //val dao = DatabaseManager.getFuncionarioDAO()
        //dao.insert(funcionario)
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}