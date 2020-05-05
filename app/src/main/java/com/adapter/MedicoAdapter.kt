package com.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.models.Medico
import com.sonicdoc.R
import kotlinx.android.synthetic.main.prototype_medico.view.*

class MedicoAdapter(var medicos:ArrayList<Medico>): RecyclerView.Adapter<MedicoPrototype>(){
    private var context: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicoPrototype {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.prototype_medico,parent,false)
        context = parent.context
        return MedicoPrototype(view)
    }
    override fun getItemCount(): Int {
        return medicos.size
    }
    override fun onBindViewHolder(holder: MedicoPrototype, position: Int) {
        holder.bind(medicos[position])
    }

}

class MedicoPrototype(itemView: View):RecyclerView.ViewHolder(itemView){
    var nombre = itemView.textViewNombre
    var apellido = itemView.textViewApellido
    fun bind(medico: Medico){
        nombre.text = medico.nombre
        apellido.text = medico.apellido
    }
}