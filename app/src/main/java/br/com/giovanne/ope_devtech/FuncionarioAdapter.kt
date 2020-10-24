package br.com.giovanne.ope_devtech

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.squareup.picasso.Picasso

class FuncionarioAdapter(
    val funcionarios: List<Funcionario>,
    val onClick: (Funcionario) -> Unit
): RecyclerView.Adapter<FuncionarioAdapter.FuncionarioViewHolder>(){


    class FuncionarioViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val cardNome: TextView
        //val cardImg: ImageView
        //val cardProgress: ProgressBar
        val cadView: CardView
        val cardTelefone: TextView
        val cardUser: TextView
        val cardStarts: TextView
        val cardEnds: TextView

        init {
            cardNome = view.findViewById(R.id.card_nome)
            //cardProgress = view.findViewById(R.id.card_progress)
            cadView = view.findViewById(R.id.card_funcionario)
            cardTelefone = view.findViewById(R.id.card_telefone)
            cardUser = view.findViewById(R.id.card_user)
            cardStarts = view.findViewById(R.id.card_starts)
            cardEnds = view.findViewById(R.id.card_ends)
        }
    }

    override fun getItemCount() = this.funcionarios.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FuncionarioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_funcionario, parent, false)

        val holder = FuncionarioViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: FuncionarioViewHolder, position: Int) {
        val context = holder.itemView.context

        val funcionario = this.funcionarios[position]

        holder.cardNome.text = funcionario.name
        holder.cardTelefone.text = funcionario.phone
        holder.cardUser.text = funcionario.login
        holder.cardStarts.text = "Entrada: ${funcionario.starts}"
        holder.cardEnds.text = "Saída: ${funcionario.ends}"
        //holder.cardProgress.visibility = View.VISIBLE

        //Picasso.with(context).load("https://upload.wikimedia.org/wikipedia/en/c/cd/Dwight_Schrute.jpg").fit().into(
        //    holder.cardImg,
        //    object : com.squareup.picasso.Callback {
        //        override fun onSuccess() {
        //            holder.cardProgress.visibility = View.GONE
        //        }
        //
        //        override fun onError() {
        //            holder.cardProgress.visibility = View.GONE
        //        }
        //    }
        //)
        holder.itemView.setOnClickListener { onClick(funcionario) }
    }

}