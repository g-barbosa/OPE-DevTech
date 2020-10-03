package br.com.giovanne.ope_devtech

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.squareup.picasso.Picasso

class DisciplinaAdapter(
    val disciplinas: List<Disciplina>,
    val onClick: (Disciplina) -> Unit
): RecyclerView.Adapter<DisciplinaAdapter.DisciplinasViewHolder>(){


    class DisciplinasViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val cardNome: TextView
        val cardImg: ImageView
        val cardProgress: ProgressBar
        val cadView: CardView

        init {
            cardNome = view.findViewById(R.id.card_nome)
            cardImg = view.findViewById(R.id.card_image)
            cardProgress = view.findViewById(R.id.card_progress)
            cadView = view.findViewById(R.id.card_disciplina)
        }
    }

    override fun getItemCount() = this.disciplinas.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisciplinasViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_disciplina, parent, false)

        val holder = DisciplinasViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: DisciplinasViewHolder, position: Int) {
        val context = holder.itemView.context

        val disciplina = this.disciplinas[position]

        holder.cardNome.text = disciplina.nome
        holder.cardProgress.visibility = View.VISIBLE

        Picasso.with(context).load(disciplina.foto).fit().into(
            holder.cardImg,
            object : com.squareup.picasso.Callback {
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }

                override fun onError() {
                    holder.cardProgress.visibility = View.GONE
                }
            }
        )
        holder.itemView.setOnClickListener { onClick(disciplina) }
    }

}