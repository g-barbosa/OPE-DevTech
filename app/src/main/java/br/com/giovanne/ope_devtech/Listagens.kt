package br.com.giovanne.ope_devtech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_listagens.*
import kotlinx.android.synthetic.main.toolbar.*

class Listagens : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagens)

        val args = intent.extras
        val title = args?.getString("title")

        setSupportActionBar(toolbar)
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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
        taskDisciplinas()
    }

    private var disciplinas = listOf<Disciplina>()
    fun taskDisciplinas() {
        disciplinas = DisciplinaService.getDisciplinas(this)
        recyclerDisciplinas?.adapter = DisciplinaAdapter(disciplinas) { onClickDisciplina(it) }
    }

    fun onClickDisciplina(disciplina: Disciplina) {
        val it = Intent(this, DisciplinaActivity::class.java)
        it.putExtra("disciplina", disciplina)
        startActivity(it)
    }
}
