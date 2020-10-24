package br.com.giovanne.ope_devtech

import android.app.Application
import java.lang.IllegalStateException

class DevTechApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: DevTechApplication? = null
        fun getInstance(): DevTechApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configurar aplication no AndroidManifest")
            }
            return appInstance!!
        }
    }
}