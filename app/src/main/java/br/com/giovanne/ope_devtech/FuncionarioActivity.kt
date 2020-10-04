package br.com.giovanne.ope_devtech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_funcionario.*

class FuncionarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funcionario)
        val disciplina = intent?.getSerializableExtra("funcionario")
        Toast.makeText(this, "Funcionario: $disciplina", Toast.LENGTH_LONG).show()
    }
}
