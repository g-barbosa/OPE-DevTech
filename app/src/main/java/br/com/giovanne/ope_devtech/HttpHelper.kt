package br.com.giovanne.ope_devtech

import android.util.Log
import okhttp3.*
import java.io.IOException

object HttpHelper {
    val TAG = "ws_lmsApp"
    fun get(url: String): String {
        val request = Request.Builder().url(url).get().build()
        return getJson(request)
    }

    val JSON = MediaType.parse("application/json; charset=utf-8")
    fun post(url: String, json: String): String {
        val body = RequestBody.create(JSON, json)
        val request = Request.Builder().url(url).post(body).build()
        return getJson(request)
    }

    fun delete(url: String): String {
        return ""
    }

    fun getStatus(url: String, json: String): Int {
        try{
            val body = RequestBody.create(JSON, json)
            val request = Request.Builder().url(url).post(body).build()
            val httpResponse: Response = client.newCall(request).execute()
            val status = httpResponse.code();
            return status
        }catch (e: IOException) {
            e.printStackTrace();
        }
        return 0
    }

    val client = OkHttpClient()

    fun getJson(request: Request?): String {
        val response = client.newCall(request).execute()
        val body = response.body()
        if (body != null) {
            return body.string()
        }
        return ""
    }

    fun hasActiveInternetConnection() :Boolean{
        try{
            val request = Request.Builder().url("https://www.google.com").build()
            val httpResponse: Response = client.newCall(request).execute()
            val status = httpResponse.code();
            if (status == 200) {
                return true
            }
            return false
        }catch (e : IOException){
            e.printStackTrace()
        }
        return false
    }
}