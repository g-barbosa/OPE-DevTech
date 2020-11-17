package br.com.giovanne.ope_devtech

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AgendamentoDAO {
    @Query("SELECT * FROM agendamento WHERE id = :id")
    fun getById(id: Long): Agendamento?

    @Query("SELECT * FROM agendamento")
    fun getAll(): List<Agendamento>

    @Insert
    fun insert(agendamento: Agendamento)

    @Delete
    fun delete(agendamento: Agendamento)
}