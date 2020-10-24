package br.com.giovanne.ope_devtech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_adicionar_servicos.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar.*

class AdicionarServicos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_servicos)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Adicionar Funcionário"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        salvar.setOnClickListener{
            var f = Funcionario()
            f.name = name.text.toString()
            f.password = password.text.toString()
            f.phone = phone.text.toString()
            f.login = login.text.toString()
            f.starts = starts.text.toString()
            f.ends = ends.text.toString()

            Thread {
                FuncionarioService.saveFuncionario(f)
                runOnUiThread {
                    finish()
                }
            }.start()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
