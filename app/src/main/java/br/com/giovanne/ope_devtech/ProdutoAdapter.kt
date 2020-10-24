package br.com.giovanne.ope_devtech

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.adapter_produto.*

class ProdutoAdapter(
    val produtos: List<Produto>,
    val onClick: (Produto) -> Unit
): RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>(){


    class ProdutoViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val cardDescricao: TextView
        val cadView: CardView
        val cardQuantidade: TextView
        val cardValor: TextView

        init {
            cardDescricao = view.findViewById(R.id.card_descricao)
            cadView = view.findViewById(R.id.card_produto)
            cardQuantidade = view.findViewById(R.id.card_quantidade)
            cardValor = view.findViewById(R.id.card_valor)
        }
    }

    override fun getItemCount() = this.produtos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_produto, parent, false)

        val holder = ProdutoViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val context = holder.itemView.context

        val produto = this.produtos[position]

        holder.cardDescricao.text = produto.description
        holder.cardQuantidade.text = "Quantidade: ${produto.quantity}"
        holder.cardValor.text = "Preço: R$: ${produto.value},00"
        holder.itemView.setOnClickListener { onClick(produto) }
    }

}