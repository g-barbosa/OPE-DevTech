package br.com.giovanne.ope_devtech

import android.content.Context

object DisciplinaService {
    fun getDisciplinas(context: Context): List<Disciplina> {
        var disciplinas = mutableListOf<Disciplina>()

        for (i in 1..10) {
            val d = Disciplina()
            d.nome = "Disciplina $i"
            d.ementa = "Ementa $i"
            d.professor = "Professor $i"
            d.foto = "https://i.pinimg.com/originals/75/4d/3e/754d3e92bf084b365537a6bb255f13f8.png"
            disciplinas.add(d)
        }
        return disciplinas
    }
}