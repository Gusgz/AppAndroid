package com.sonicdoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adapter.EspecialidadAdapter
import com.models.Especialidad
import kotlinx.android.synthetic.main.activity_especialidad.*

class EspecialidadActivity : AppCompatActivity() {

    private var especialidades = ArrayList<Especialidad>()
    private var especialidadAdapter = EspecialidadAdapter(especialidades)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_especialidad)
        initView()
        addTestEspecialidades()
    }
    fun initView(){
        recyclerViewEspecialidad.adapter = especialidadAdapter
        recyclerViewEspecialidad.layoutManager = LinearLayoutManager(this)
    }
    fun addTestEspecialidades(){
        especialidades.add(Especialidad(0,"Code#1","Cardiología"))
        especialidades.add(Especialidad(0,"Code#2","Odontología"))
        especialidades.add(Especialidad(0,"Code#3","Neurología"))
    }
}
