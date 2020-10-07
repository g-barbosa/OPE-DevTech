package br.com.giovanne.ope_devtech

import okhttp3.OkHttpClient
import okhttp3.Request

object HttpHelper {
    fun get(url: String): String {
        val request = Request.Builder().url(url).get().build()
        return getJson(request)
    }

    fun post(url: String, json: String): String {
        return ""
    }

    fun delete(url: String): String {
        return ""
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
}