package br.com.giovanne.ope_devtech

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName="produto")
class Produto: Serializable {
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
    var entityId = ""
    var description = ""
    var quantity = ""
    var value = ""

    override fun toString(): String {
        return "$description"
    }
}