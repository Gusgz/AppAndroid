package com.sonicdoc

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.util.SharedPreference
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sesion.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var bundle:Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bundle = intent.extras
        if(bundle!=null){
            val text = bundle!!.getString("KeySesion")
            val textView:TextView = findViewById(R.id.textViewUsuario)
            textView.text = text

        }
        //Cierre de Sesion
        val sharedPreference = SharedPreference(this)
        if(sharedPreference.getValueString("Nombre")!=null){
        btnLogOut.setOnClickListener(){
           val intent = Intent(this,SesionActivity::class.java)
                sharedPreference.removeValue("Nombre")
                Toast.makeText(this,"Ha Cerrado Sesion",Toast.LENGTH_LONG).show()
               startActivity(intent)
            }
        }

    }
}
