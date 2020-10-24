package br.com.giovanne.ope_devtech

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_listagens.*
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

        recyclerDisciplinas?.layoutManager = LinearLayoutManager(this)
        recyclerDisciplinas?.itemAnimator = DefaultItemAnimator()
        recyclerDisciplinas?.setHasFixedSize(true)
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
        taskFuncionarios()
    }

    private var funcionarios = listOf<Funcionario>()
    fun taskFuncionarios() {
        funcionarios = FuncionarioService.getFuncionarios(this)
        recyclerDisciplinas?.adapter = FuncionarioAdapter(funcionarios) { onClickFuncionario(it) }
    }

    fun onClickFuncionario(funcionario: Funcionario) {
        val it = Intent(this, FuncionarioActivity::class.java)
        it.putExtra("funcionario", funcionario)
        startActivity(it)
    }

}
