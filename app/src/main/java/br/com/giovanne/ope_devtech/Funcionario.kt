package br.com.giovanne.ope_devtech

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName="funcionario")
class Funcionario: Serializable {

    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
    var entityId = ""
    var name = ""
    var phone = ""
    var foto = ""
    var login = ""
    var starts = ""
    var ends = ""
    var password = ""

    override fun toString(): String {
        return "$name"
    }

}