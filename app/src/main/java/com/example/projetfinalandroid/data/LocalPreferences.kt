package com.example.projetfinalandroid.data

import android.content.Context
import android.content.SharedPreferences

class LocalPreferences private constructor(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

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

    fun addToHistory(newEntry: String){
        val history = this.getHistory()
        history?.add(newEntry)
        sharedPreferences.edit().putStringSet("histories", history).apply()
    }

    fun getHistory(): MutableSet<String>? {
        return sharedPreferences.getStringSet("histories",  mutableSetOf<String>().toMutableSet() )
    }

    fun deleteAllHistory() {
        sharedPreferences.edit().clear().apply()
    }

    fun nullHistory(): Boolean {
        if (sharedPreferences.getStringSet("histories", mutableSetOf<String>())?.isEmpty() != true) {
            return false
        } else
            return true
    }
}




