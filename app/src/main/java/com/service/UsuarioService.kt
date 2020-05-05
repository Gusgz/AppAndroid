package com.service

import com.models.Usuario
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UsuarioService {
    //@GET("api/Usuarios/Show/1")
    //fun getUsuario(@Query("format")format:String):Call<Usuario>
    @GET("api/Usuarios/List")
    fun getAllUsuarios():Call<List<Usuario>>
    @GET("Api/GET-api-Usuario-ID/{ID}")
    fun getUsuarioById(@Path("ID") id:Int):Call<Usuario>
}