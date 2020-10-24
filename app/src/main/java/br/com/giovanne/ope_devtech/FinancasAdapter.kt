package br.com.giovanne.ope_devtech

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.adapter_produto.*

class FinancasAdapter(
    val financas: Financas,
    val onClick: (Financas) -> Unit
): RecyclerView.Adapter<FinancasAdapter.FinancasViewHolder>(){


    class FinancasViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val cardLucro: TextView
        val cadView: CardView
        val cardDespesa: TextView
        val cardTotal: TextView

        init {
            cardLucro = view.findViewById(R.id.card_lucro)
            cadView = view.findViewById(R.id.card_financas)
            cardDespesa = view.findViewById(R.id.card_despesa)
            cardTotal = view.findViewById(R.id.card_total)
        }
    }

    override fun getItemCount() = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinancasViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_financas, parent, false)

        val holder = FinancasViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: FinancasViewHolder, position: Int) {
        val context = holder.itemView.context

        val financas = this.financas

        holder.cardDespesa.text = "Despesas: R$: ${financas.despesa},00"
        holder.cardLucro.text = "Lucro: R$: ${financas.lucro},00"
        holder.cardTotal.text = "Total: R$: ${financas.total},00"
        holder.itemView.setOnClickListener { onClick(financas) }
    }

}