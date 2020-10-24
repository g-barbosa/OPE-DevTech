package br.com.giovanne.ope_devtech

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

object ProdutoService {
    val host = "https://sistema-agendamento-devtech.herokuapp.com"
    val TAG = "ws_lmsApp"
    fun getProdutos(context: Context): List<Produto> {

        val url = "$host/stock"
        val json = HttpHelper.get(url)

        Log.d(TAG, json)
        var stock = parserJson<List<Produto>>(json)


        return stock
        //val dao = DatabaseManager.getFuncionarioDAO()
        //return dao.getAll()
    }

    fun saveProdutos(produto: Produto)  {
        val url = "$host/stock"
        val jsonCliente = GsonBuilder().create().toJson(produto)
        HttpHelper.post(url, jsonCliente)
        //val dao = DatabaseManager.getFuncionarioDAO()
        //dao.insert(funcionario)
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}