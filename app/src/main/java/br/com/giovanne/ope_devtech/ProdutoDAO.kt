package br.com.giovanne.ope_devtech

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProdutoDAO {
    @Query("SELECT * FROM produto WHERE id = :id")
    fun getById(id: Long): Produto?

    @Query("SELECT * FROM produto")
    fun getAll(): List<Produto>

    @Insert
    fun insert(produto: Produto)

    @Delete
    fun delete(produto: Produto)
}