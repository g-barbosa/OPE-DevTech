package br.com.giovanne.ope_devtech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class mapasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapas)
    }

    override fun onResume() {
        super.onResume()
        val mapaFragment = MapaFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.layoutMapas, mapaFragment)
            .commit()
    }
}