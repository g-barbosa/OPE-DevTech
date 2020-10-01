package br.com.giovanne.ope_devtech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_disciplina.*

class DisciplinaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disciplina)
        val disciplina = intent?.getSerializableExtra("disciplina")
        Toast.makeText(this, "Disciplina: $disciplina", Toast.LENGTH_LONG).show()
    }
}
