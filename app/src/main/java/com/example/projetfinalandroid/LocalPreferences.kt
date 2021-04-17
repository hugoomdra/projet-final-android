package com.example.projetfinalandroid
import android.content.Context
import android.content.SharedPreferences

class LocalPreferences private constructor(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

    fun saveStringValue(key: String?, yourValue: String?) {
        sharedPreferences.edit().putString(key, yourValue).apply()
    }

    fun getSaveStringValue(key: String?): String? {
        return sharedPreferences.getString(key, null)
    }

    companion object {
        private var INSTANCE: LocalPreferences? = null

        fun getInstance(context: Context): LocalPreferences {
            return INSTANCE?.let {
                INSTANCE
            } ?: run {
                INSTANCE = LocalPreferences(context)
                return INSTANCE!!
            }
        }
    }

}