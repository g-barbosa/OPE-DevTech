package br.com.giovanne.ope_devtech

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName="cliente")
class Cliente: Serializable {
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
    var entityId = ""
    var name = ""
    var phone = ""
    var login = ""
    var password = ""

    override fun toString(): String {
        return "$name"
    }
}