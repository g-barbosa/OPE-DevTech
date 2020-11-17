package br.com.giovanne.ope_devtech

import android.icu.util.Calendar
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_agenda.*
import kotlinx.android.synthetic.main.activity_agenda.card_progress
import kotlinx.android.synthetic.main.activity_agenda.recyclerFuncionarios
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.nav_view.*
import kotlinx.android.synthetic.main.toolbar.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class AgendaActivity : DrawerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda)

        this.drawerLayout = layoutMenuLateralAgendas
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
        card_progress.visibility = View.VISIBLE
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

    override fun onResume() {
        super.onResume()
        var agendamentos = listOf<Agendamento>()
        Thread {
            agendamentos = AgendamentoService.getAgendamentos(this)
            runOnUiThread{
                recyclerFuncionarios?.adapter = AgendaAdapter(agendamentos){ onClickAgendamento(it) }
            }
        }.start()
        card_progress.visibility = View.GONE
    }

    fun onClickAgendamento(agendamento: Agendamento) {
        var calendar: Calendar = Calendar.getInstance()
        val firstApiFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val date = LocalDate.parse(agendamento.data , firstApiFormat)
        calendar.set(date.year, (date.monthValue - 1), date.dayOfMonth)
        val teste = calendar.timeInMillis
        calendarView.setDate(teste, true, true)
    }
}
