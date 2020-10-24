package br.com.giovanne.ope_devtech

import android.content.SharedPreferences

object Prefs {
    private fun prefs(): SharedPreferences{
        val context = DevTechApplication.getInstance().applicationContext
        return context.getSharedPreferences("DevTech", 0)
    }

    fun setString(flag: String, valor: String) = prefs().edit().putString(flag, valor).apply()

    fun getString(flag: String) = prefs().getString(flag, "")

    fun setBoolean(flag: String, valor: Boolean) = prefs().edit().putBoolean(flag, valor).apply()

    fun getBoolean(flag: String) = prefs().getBoolean(flag, false)
}