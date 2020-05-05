package com.sonicdoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_sesion.*
import com.models.Paciente
import com.models.Usuario
import com.service.UsuarioService
import com.util.SharedPreference
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
        btnLoad.setOnClickListener{
            loadUsuario()
        }
    }
    private fun loadUsuario(){
        // https://localhost:44348/
        // http://localhost:57198/
        // http://192.168.1.23:57198/
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.23:45458/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val usuarioService = retrofit.create(UsuarioService::class.java)
        usuarioService.getAllUsuarios().enqueue(object:Callback<List<Usuario>>{
            override fun onResponse(call: Call<List<Usuario>>, response: Response<List<Usuario>>) {
                Toast.makeText(this@SesionActivity,response.body()?.get(0)?.username,Toast.LENGTH_SHORT).show()
            }
            override fun onFailure(call: Call<List<Usuario>>, t: Throwable) {
                Toast.makeText(this@SesionActivity,"NO",Toast.LENGTH_SHORT).show()
            }
        })
    }
}
