package br.com.giovanne.ope_devtech

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView;
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.nav_view.*
import kotlinx.android.synthetic.main.toolbar.*


class Home : DrawerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        this.drawerLayout = layoutMenuLateralHome
        this.navView = menu_lateral_home

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Funcionários"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        configuraMenuLateral()

        recyclerFuncionarios?.layoutManager = LinearLayoutManager(this)
        recyclerFuncionarios?.itemAnimator = DefaultItemAnimator()
        recyclerFuncionarios?.setHasFixedSize(true)
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
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        taskFuncionarios()
    }

    private var funcionarios = listOf<Funcionario>()
    fun taskFuncionarios() {
        Thread {
            funcionarios = FuncionarioService.getFuncionarios(this)
            runOnUiThread{
                recyclerFuncionarios?.adapter = FuncionarioAdapter(funcionarios) { onClickFuncionario(it) }
            }

        }.start()
    }

    fun onClickFuncionario(funcionario: Funcionario) {
        val it = Intent(this, FuncionarioActivity::class.java)
        it.putExtra("funcionario", funcionario)
        startActivity(it)
    }
}
