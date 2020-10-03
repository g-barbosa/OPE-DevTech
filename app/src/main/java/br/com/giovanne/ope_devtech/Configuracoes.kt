package br.com.giovanne.ope_devtech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.toolbar.*

class Configuracoes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracoes)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Configurações"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
