package com.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.models.Especialidad
import com.sonicdoc.R
import kotlinx.android.synthetic.main.prototype_especialidad.view.*

class EspecialidadAdapter(var especialidades:ArrayList<Especialidad>):RecyclerView.Adapter<EspecialidadPrototype>(){
    private var context: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EspecialidadPrototype {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prototype_especialidad,parent,false)
        context = parent.context
        return EspecialidadPrototype(view)
    }

    override fun getItemCount(): Int {
        return especialidades.size
    }

    override fun onBindViewHolder(holder: EspecialidadPrototype, position: Int) {
        holder.bind(especialidades[position])
    }
}

class EspecialidadPrototype(itemView: View):RecyclerView.ViewHolder(itemView){
    var nombre = itemView.textViewEspecialidad
    fun bind(especialidad:Especialidad){
        nombre.text = especialidad.nombre
    }
}