package br.com.giovanne.ope_devtech

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.adapter_cliente.*

class ClienteAdapter(
    val clientes: List<Cliente>,
    val onClick: (Cliente) -> Unit
): RecyclerView.Adapter<ClienteAdapter.ClienteViewHolder>(){


    class ClienteViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val cardNome: TextView
        val cadView: CardView
        val cardTelefone: TextView
        val cardUser: TextView

        init {
            cardNome = view.findViewById(R.id.card_nome)
            cadView = view.findViewById(R.id.card_cliente)
            cardTelefone = view.findViewById(R.id.card_telefone)
            cardUser = view.findViewById(R.id.card_user)
        }
    }

    override fun getItemCount() = this.clientes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_cliente, parent, false)

        val holder = ClienteViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ClienteViewHolder, position: Int) {
        val context = holder.itemView.context

        val cliente = this.clientes[position]

        holder.cardNome.text = cliente.name
        holder.cardTelefone.text = cliente.phone
        holder.cardUser.text = cliente.login
        holder.itemView.setOnClickListener { onClick(cliente) }
    }

}