package com.example.projetfinalandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_localisation.setOnClickListener { ;
            startActivity(LocalisationActivity.getStartIntent(this))
//            finish()
        }

        btn_historique.setOnClickListener{
            startActivity(HistoriqueActivity.getStartIntent(this))
//            if(LocalPreferences.getInstance(this).getSaveStringValue() != null){
//                Toast.makeText(this, LocalPreferences.getInstance(this).getSaveStringValue(), Toast.LENGTH_SHORT).show()
//            }
        }

    }

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}