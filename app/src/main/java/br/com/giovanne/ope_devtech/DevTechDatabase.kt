package br.com.giovanne.ope_devtech

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Funcionario::class), version = 1)
abstract class DevTechDatabase: RoomDatabase() {
    abstract fun funcionarioDAO():FuncionarioDAO
}