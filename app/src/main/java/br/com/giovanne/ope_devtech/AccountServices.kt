package br.com.giovanne.ope_devtech

import android.content.Context
import android.util.Log
import br.com.giovanne.ope_devtech.HttpHelper.client
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.Request
import okhttp3.Response


object AccountServices {
    val host = "https://sistema-agendamento-devtech.herokuapp.com"
    val TAG = "ws_lmsApp"

    fun login(login: Login): Int  {
        val url = "${host}/login"
        val jsonLogin = GsonBuilder().create().toJson(login)
        val status = HttpHelper.getStatus(url, jsonLogin)
        return status
    }
}