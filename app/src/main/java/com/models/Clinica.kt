package com.models

class Clinica {
    var clinicaId:Int = 0
    var nombre:String? = null
    var ruc:Long? = null
    var direccion:String? = null
    var telefono:Long? = null
    var correo:String? = null
    var sedes:ArrayList<Sede>? = null
}