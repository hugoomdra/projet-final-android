package com.example.projetfinalandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_historique.*

class HistoriqueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historique)

        supportActionBar?.apply {
            setTitle(getString(R.string.menu_localisation_eseo))
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        if(LocalPreferences.getInstance(this).getSaveStringValue() != null){
            text_test.setText(LocalPreferences.getInstance(this).getSaveStringValue())
        }
//
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, HistoriqueActivity::class.java)
        }
    }
}