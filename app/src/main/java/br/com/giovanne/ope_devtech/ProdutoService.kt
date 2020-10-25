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

        if (HttpHelper.hasActiveInternetConnection()){
            val json = HttpHelper.get(url)

            Log.d(TAG, json)
            var stock = parserJson<List<Produto>>(json)

            for (p in stock) {
                saveOffline(p)
            }
            return stock
        }
        else {
            val dao = DatabaseManager.getProdutoDAO()
            return dao.getAll()
        }
    }

    fun saveProdutos(produto: Produto)  {
        val url = "$host/stock"

        if (HttpHelper.hasActiveInternetConnection()){
            val jsonCliente = GsonBuilder().create().toJson(produto)
            HttpHelper.post(url, jsonCliente)
        }
        else {
            val dao = DatabaseManager.getProdutoDAO()
            dao.insert(produto)
        }

    }

    fun saveOffline (produto: Produto) {
        val dao = DatabaseManager.getProdutoDAO()
        if (! existe(produto)) {
            dao.insert(produto)
        }
    }

    fun existe(produto: Produto): Boolean {
        val dao = DatabaseManager.getProdutoDAO()
        return dao.getById(produto.id) != null
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}