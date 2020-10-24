package br.com.giovanne.ope_devtech

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.toolbar.*


open class DrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var drawerLayout: DrawerLayout? = null
    var navView: NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun configuraMenuLateral() {
        var toogle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_closed
        )
        toogle.isDrawerIndicatorEnabled = true
        drawerLayout?.addDrawerListener(toogle)
        toogle.syncState()

        navView?.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        var intent = Intent(this, Listagens::class.java)

        when(item.itemId) {
            R.id.nav_agenda -> {
                intent.putExtra("title", "Agenda")
                startActivity(intent)
            }
            R.id.nav_clientes -> {
                intent.putExtra("title", "Clientes")
                startActivity(intent)
            }
            R.id.nav_financas -> {
                intent.putExtra("title", "Finanças")
                startActivity(intent)
            }
            R.id.nav_funcionario -> {
                intent = Intent(this, Home::class.java)
                startActivity(intent)
            }
            R.id.nav_produtos -> {
                intent.putExtra("title", "Produtos")
                startActivity(intent)
            }
            R.id.nav_servicos -> {
                intent.putExtra("title", "Servicos")
                startActivity(intent)
            }
            R.id.nav_sair -> {
                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        drawerLayout?.closeDrawer(GravityCompat.START)
        return true
    }

}
