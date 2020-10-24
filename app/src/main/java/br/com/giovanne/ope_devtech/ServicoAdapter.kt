package br.com.giovanne.ope_devtech

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.adapter_servico.*

class ServicoAdapter(
    val servicos: List<Servico>,
    val onClick: (Servico) -> Unit
): RecyclerView.Adapter<ServicoAdapter.ServicoViewHolder>(){


    class ServicoViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val cardDescricao: TextView
        val cadView: CardView
        val cardValor: TextView

        init {
            cardDescricao = view.findViewById(R.id.card_descricao)
            cadView = view.findViewById(R.id.card_servico)
            cardValor = view.findViewById(R.id.card_valor)
        }
    }

    override fun getItemCount() = this.servicos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_servico, parent, false)

        val holder = ServicoViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ServicoViewHolder, position: Int) {
        val context = holder.itemView.context

        val servicos = this.servicos[position]

        holder.cardDescricao.text = servicos.description
        holder.cardValor.text = "Preço: R$ ${servicos.value},00"
        holder.itemView.setOnClickListener { onClick(servicos) }
    }

}