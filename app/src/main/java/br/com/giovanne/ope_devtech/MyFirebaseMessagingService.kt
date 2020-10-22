package br.com.giovanne.ope_devtech

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {
    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Prefs.setString("FB_TOKEN", token!!)
        Log.d("firebase", token!!)
    }

    override fun onMessageReceived(mensagemRemota: RemoteMessage?) {
        super.onMessageReceived(mensagemRemota)

        if(mensagemRemota?.notification != null) {
            val titulo = mensagemRemota?.notification?.title
            val corpo = mensagemRemota?.notification?.body
            Log.d("firebase", titulo)
            Log.d("firebase", corpo)
            showNotification(mensagemRemota)
        }
        if (mensagemRemota?.data!!.isNotEmpty()){
            val dado = mensagemRemota?.data!!.get("funcionarioId")
            Log.d("firebase", "data: $dado")
        }
    }

    private fun showNotification(mensagemRemota: RemoteMessage){
        val intent = Intent(this, FuncionarioActivity::class.java)
        val titulo = mensagemRemota?.notification?.title
        val corpo = mensagemRemota?.notification?.body

        NotificationUtil.create(1, intent, titulo!!, corpo!!)
    }
}