package com.sonicdoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adapter.MedicoAdapter
import com.models.Medico
import kotlinx.android.synthetic.main.activity_medico.*

class MedicoActivity : AppCompatActivity() {

    private var medicos = ArrayList<Medico>()
    private var medicoAdapter = MedicoAdapter(medicos)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medico)
        initView()
        addTestMedicos()
    }
    fun initView(){
        recyclerViewMedicos.adapter = medicoAdapter
        recyclerViewMedicos.layoutManager = LinearLayoutManager(this)
    }
    fun addTestMedicos(){
        medicos.add(Medico(0,"Name#1","LastName#1"))
        medicos.add(Medico(1,"Name#2","LastName#2"))
        medicos.add(Medico(2,"Name#3","LastName#3"))
    }
}
