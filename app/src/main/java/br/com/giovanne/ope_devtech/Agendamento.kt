package br.com.giovanne.ope_devtech

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName="agendamento")
class Agendamento: Serializable {
    @PrimaryKey(autoGenerate = true)
    var identfication:Long = 0
    var id = ""
    var data = ""
    var customerId = ""
    var employeeId = ""
    var customerName = ""
    var product = ""
    var service = ""

    override fun toString(): String {
        return "$data"
    }
}