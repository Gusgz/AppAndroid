package com.sonicdoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sesion.*
import com.models.Paciente
import com.util.SharedPreference

class SesionActivity : AppCompatActivity() {
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

            btnIngresar.setOnClickListener {
                var paciente = Paciente()
                paciente.nombre = edNombre.text.toString()
                if(sharedPreference.getValueString("Nombre")== null && paciente.nombre==""){
                    Toast.makeText(this,"Ingresar Datos",Toast.LENGTH_LONG).show()
                }else {
                    sharedPreference.save("Nombre", paciente.nombre)
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("KeySesion", paciente.nombre)
                    startActivity(intent)
                }
            }

    }
}
