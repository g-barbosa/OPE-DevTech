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
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_adicionar_servicos.*
import kotlinx.android.synthetic.main.nav_view.*
import kotlinx.android.synthetic.main.toolbar.*


class Home : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Home"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        configuraMenuLateral()

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

    private fun configuraMenuLateral() {
        var toogle = ActionBarDrawerToggle(
            this,
            layoutMenuLateralHome,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_closed
        )
        layoutMenuLateralHome.addDrawerListener(toogle)
        toogle.syncState()

        menu_lateral_home.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_agenda -> {
                Toast.makeText(this, "agenda", Toast.LENGTH_LONG).show()
            }
            R.id.nav_clientes -> {
                Toast.makeText(this, "clientes", Toast.LENGTH_LONG).show()
            }
            R.id.nav_financas -> {
                Toast.makeText(this, "financas", Toast.LENGTH_LONG).show()
            }
            R.id.nav_funcionario -> {
                Toast.makeText(this, "funcionarios", Toast.LENGTH_LONG).show()
            }
            R.id.nav_sair -> {
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        layoutMenuLateralHome.closeDrawer(GravityCompat.START)
        return true
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

        when(id) {
            R.id.actionBuscar -> {
                Toast.makeText(this, "buscar", Toast.LENGTH_LONG).show()
            }
            R.id.action_atualizar -> {
                Toast.makeText(this, "botao atualizar", Toast.LENGTH_LONG).show()
                progressBar.visibility = View.VISIBLE
                Handler().postDelayed({
                    progressBar.visibility = View.GONE
                }, 10000)
            }
            R.id.action_config -> {
                Toast.makeText(this, "botao config", Toast.LENGTH_LONG).show()
                var intent = Intent(this, Configuracoes::class.java)
                startActivity(intent)
            }
            R.id.action_adicionar -> {
                Toast.makeText(this, "botao add", Toast.LENGTH_LONG).show()
                var intent = Intent(this, AdicionarServicos::class.java)
                startActivity(intent)
            }
            R.id.home -> {
                finish()
            }
            R.id.action_logout -> {
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
