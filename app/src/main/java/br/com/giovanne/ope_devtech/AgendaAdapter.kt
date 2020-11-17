package br.com.giovanne.ope_devtech

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.adapter_cliente.*

class AgendaAdapter(
    val agendamentos: List<Agendamento>,
    val onClick: (Agendamento) -> Unit
): RecyclerView.Adapter<AgendaAdapter.AgendamentoViewHolder>(){


    class AgendamentoViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val cliente_nome: TextView
        val servico: TextView
        val cardView: CardView

        init {
            cardView = view.findViewById(R.id.card_agenda)
            cliente_nome = view.findViewById(R.id.cliente_nome)
            servico = view.findViewById(R.id.servico)
        }
    }

    override fun getItemCount() = this.agendamentos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgendamentoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_agenda, parent, false)

        val holder = AgendamentoViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: AgendamentoViewHolder, position: Int) {
        val context = holder.itemView.context

        val agendamento = this.agendamentos[position]

        holder.cliente_nome.text = agendamento.customerName
        holder.servico.text = agendamento.service
        holder.itemView.setOnClickListener { onClick(agendamento) }
    }

}