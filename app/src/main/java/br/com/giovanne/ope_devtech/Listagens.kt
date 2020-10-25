package br.com.giovanne.ope_devtech

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_listagens.*
import kotlinx.android.synthetic.main.activity_listagens.recyclerFuncionarios
import kotlinx.android.synthetic.main.nav_view.*
import kotlinx.android.synthetic.main.toolbar.*

class Listagens : DrawerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagens)

        this.drawerLayout = layoutMenuLateralListagens
        this.navView = menu_lateral_home

        val args = intent.extras
        val title = args?.getString("title")

        setSupportActionBar(toolbar)
        supportActionBar?.title = title
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

        if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        val args = intent.extras
        val title = args?.getString("title")
        when(title) {
            "Clientes" -> {
                var clientes = listOf<Cliente>()
                Thread {
                    clientes = ClienteService.getClientes(this)
                    runOnUiThread{
                        recyclerFuncionarios?.adapter = ClienteAdapter(clientes){ }
                    }

                }.start()
            }
            "Produtos" -> {
                var produtos = listOf<Produto>()
                Thread {
                    produtos = ProdutoService.getProdutos(this)
                    runOnUiThread{
                        recyclerFuncionarios?.adapter = ProdutoAdapter(produtos){  }
                    }

                }.start()
            }
            "Servicos" -> {
                var servicos = listOf<Servico>()
                Thread {
                    servicos = ServicoService.getServicos(this)
                    runOnUiThread{
                        recyclerFuncionarios?.adapter = ServicoAdapter(servicos){  }
                    }

                }.start()
            }
            "Finanças" -> {
                var financas = Financas()
                Thread {
                    financas = FinancasService.getFinances(this)
                    runOnUiThread{
                        recyclerFuncionarios?.adapter = FinancasAdapter(financas){  }
                    }

                }.start()
            }
        }
    }

}
