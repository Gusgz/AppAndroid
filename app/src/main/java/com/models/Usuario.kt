package com.models

import com.google.gson.annotations.SerializedName

class Usuario(
    @SerializedName("usuarioId") var usuarioId:Int,
    @SerializedName("dni") var dni:Int,
    @SerializedName("email") var email:String,
    @SerializedName("username") var username:String,
    @SerializedName("password") var password:String
 )