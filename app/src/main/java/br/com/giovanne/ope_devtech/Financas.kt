package br.com.giovanne.ope_devtech

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName="financas")
class Financas {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var lucro: Int = 0
    var despesa: Int = 0
    var total: Int = 0
}