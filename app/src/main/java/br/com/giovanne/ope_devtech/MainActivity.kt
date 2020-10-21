package br.com.giovanne.ope_devtech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        loginMessage.setText("Faça seu login")
        imageView.setImageResource(R.drawable.deriklogo)

        emailInput.setText(Prefs.getString("lembrarNome"))
        passwordInput.setText(Prefs.getString("lembrarSenha"))
        checkBox.isChecked = Prefs.getBoolean("lembrar")

        loginButton.setOnClickListener{
            val nomeUsuario = emailInput.text.toString()
            val camposenha = passwordInput.text.toString()

            val lembrar = checkBox.isChecked
            Prefs.setBoolean("lembrar", lembrar)

            if (lembrar) {
                Prefs.setString("lembrarNome", nomeUsuario)
                Prefs.setString("lembrarSenha", camposenha)
            } else {
                Prefs.setString("lembrarNome", "")
                Prefs.setString("lembrarSenha", "")
            }

            if (nomeUsuario != "aluno" || camposenha != "impacta"){
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()
            }
            else {
                var intent = Intent(this, Home::class.java)
                intent.putExtra("nome_usuario", nomeUsuario)
                intent.putExtra("numero", 10)

                startActivity(intent)
            }
        }
    }
}
