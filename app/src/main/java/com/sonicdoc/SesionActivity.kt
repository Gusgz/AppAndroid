package com.sonicdoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_sesion.*
import com.models.Paciente
import com.util.SharedPreference

class SesionActivity : AppCompatActivity() {
    val editTextPaciente:EditText = findViewById(R.id.edNombre)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sesion)
        // SharedPrefence
        val sharedPreference = SharedPreference(this)
        // Siguiente sesion automático
        if(sharedPreference.getValueString("Nombre")!=null){
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("KeySesion",sharedPreference.getValueString("Nombre"))
            startActivity(intent)
        }
        btnIngresar.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            var paciente = Paciente()
            paciente.nombre = edNombre.text.toString()
            sharedPreference.save("Nombre",paciente.nombre)
            intent.putExtra("KeySesion",paciente.nombre)
            startActivity(intent)
        }
    }
}
