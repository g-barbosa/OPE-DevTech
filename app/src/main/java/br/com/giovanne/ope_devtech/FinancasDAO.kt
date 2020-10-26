package br.com.giovanne.ope_devtech

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FinancasDAO {
    @Query("SELECT * FROM financas WHERE id = :id")
    fun getById(id: Long): Financas?

    @Query("SELECT * FROM financas")
    fun getAll(): Financas

    @Insert
    fun insert(financas: Financas)

    @Delete
    fun delete(financas: Financas)
}