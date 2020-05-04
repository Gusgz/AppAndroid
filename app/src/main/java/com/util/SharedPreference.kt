package com.util

import android.content.Context
import com.models.Paciente

class SharedPreference(val context: Context) {
    val PREFS_NAME = "sharedPreferences"
    val sharedPreference = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE)
    fun save(keyName:String,value:String){
        val editor = sharedPreference.edit()
        editor.putString(keyName,value)
        editor.commit()
    }
    fun getValueString(keyName: String):String?{
        return sharedPreference.getString(keyName,null)
    }
    fun clearSharedPreferences(){
        val editor = sharedPreference.edit()
        editor.clear()
        editor.commit()
    }
    fun removeValue(keyName: String){
        val editor = sharedPreference.edit()
        editor.remove(keyName)
        editor.commit()
    }
}