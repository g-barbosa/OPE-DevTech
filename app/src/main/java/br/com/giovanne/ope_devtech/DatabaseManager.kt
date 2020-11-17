package br.com.giovanne.ope_devtech

import androidx.room.Room

object DatabaseManager {
    private var dbInstance: DevTechDatabase
    init {
        val context = DevTechApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            context,
            DevTechDatabase::class.java,
            "devtech.sqlite"
        ).build()
    }

    fun getFuncionarioDAO(): FuncionarioDAO {
        return dbInstance.funcionarioDAO()
    }

    fun getClienteDAO(): ClienteDAO {
        return dbInstance.clienteDAO()
    }

    fun getProdutoDAO(): ProdutoDAO {
        return dbInstance.produtoDAO()
    }

    fun getServicoDAO(): ServicoDAO {
        return dbInstance.servicoDAO()
    }

    fun getFinancasDAO(): FinancasDAO {
        return dbInstance.financasDAO()
    }

    fun getAgendamentosDAO(): AgendamentoDAO {
        return dbInstance.agendamentosDAO()
    }
}