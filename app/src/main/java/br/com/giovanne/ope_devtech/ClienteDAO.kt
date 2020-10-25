package br.com.giovanne.ope_devtech

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ClienteDAO {
    @Query("SELECT * FROM cliente WHERE id = :id")
    fun getById(id: Long): Cliente?

    @Query("SELECT * FROM cliente")
    fun getAll(): List<Cliente>

    @Insert
    fun insert(cliente: Cliente)

    @Delete
    fun delete(cliente: Cliente)
}