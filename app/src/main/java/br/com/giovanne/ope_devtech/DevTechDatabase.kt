package br.com.giovanne.ope_devtech

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Funcionario::class,
    Cliente::class,
    Produto::class,
    Servico::class,
    Financas::class,
    Agendamento::class), version = 1)
abstract class DevTechDatabase: RoomDatabase() {
    abstract fun funcionarioDAO():FuncionarioDAO
    abstract fun clienteDAO():ClienteDAO
    abstract fun produtoDAO():ProdutoDAO
    abstract fun servicoDAO():ServicoDAO
    abstract fun financasDAO():FinancasDAO
    abstract fun agendamentosDAO():AgendamentoDAO
}