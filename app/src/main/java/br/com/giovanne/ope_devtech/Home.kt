package br.com.giovanne.ope_devtech

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView;
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuItemCompat
import kotlinx.android.synthetic.main.activity_home.*
import android.app.SearchManager;
import android.widget.SearchView.OnQueryTextListener;


class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.title = "Home"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        button_funcionarios.setOnClickListener{
            var intent = Intent(this, Listagens::class.java)
            intent.putExtra("title", "Funcionários")
            startActivity(intent)
        }

        button_produtos.setOnClickListener{
            var intent = Intent(this, Listagens::class.java)
            intent.putExtra("title", "Produtos")
            startActivity(intent)
        }

        button_servicos.setOnClickListener{
            var intent = Intent(this, Listagens::class.java)
            intent.putExtra("title", "Serviços")
            startActivity(intent)
        }
    }

    fun showText(text: String){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?) : Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        (menu?.findItem(R.id.actionBuscar)?.actionView as SearchView).setOnQueryTextListener(
            object : SearchView.OnQueryTextListener{
                override fun onQueryTextChange(newText: String): Boolean {
                    showText(newText)
                    return false
                }

                override fun onQueryTextSubmit(query: String): Boolean {
                    showText(query)
                    return false
                }
            })

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == R.id.actionBuscar) {
            Toast.makeText(this, "buscar", Toast.LENGTH_LONG).show()
        }
        else if (id == R.id.action_atualizar) {
            Toast.makeText(this, "botao atualizar", Toast.LENGTH_LONG).show()
            progressBar.visibility = View.VISIBLE
            Handler().postDelayed({
                progressBar.visibility = View.GONE
            }, 10000)
        } else if (id == R.id.action_config){
            Toast.makeText(this, "botao config", Toast.LENGTH_LONG).show()
            var intent = Intent(this, Configuracoes::class.java)
            startActivity(intent)
        } else if (id == R.id.action_adicionar) {
            Toast.makeText(this, "botao add", Toast.LENGTH_LONG).show()
            var intent = Intent(this, AdicionarServicos::class.java)
            startActivity(intent)
        } else if (id == android.R.id.home) {
            finish()
        }else if (id == R.id.action_logout) {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }
}
