package com.example.projetfinalandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_easter_egg.*

class EasterEggActivity : AppCompatActivity() {

    val bonneReponse = "20"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easter_egg)

        supportActionBar?.apply {
            setTitle("Easter Egg")
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        btn_soumettre.setOnClickListener {
            val nombre = edit_text.text.toString()

            if (nombre == bonneReponse) {
                text_reponse.setTextColor(getColor(R.color.eseo_blue))
                text_reponse.setText("Voilaaaaa c'est la note qu'il me faut bien joué")
            } else if (nombre > bonneReponse) {
                text_reponse.setTextColor(getColor(R.color.eseo_red))
                text_reponse.setText("Entre 0 et 20 tu sais lire ?")
            } else if (nombre >= "15") {
                text_reponse.setTextColor(getColor(R.color.eseo_red))
                text_reponse.setText("C'est plus ! C'est une bonne note mais bon..")
            } else if (nombre >= "10") {
                text_reponse.setTextColor(getColor(R.color.eseo_red))
                text_reponse.setText("C'est plus ! Je valide le semestre mais bon voila quoi..")
            } else if (nombre >= "5") {
                text_reponse.setTextColor(getColor(R.color.eseo_red))
                text_reponse.setText("C'est plus ! Je valide même pas le semestre avec ça..")
            } else {
                text_reponse.setTextColor(getColor(R.color.eseo_red))
                text_reponse.setText("C'est plus ! Je pense méritais une meilleure note quand même..")
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, EasterEggActivity::class.java)
        }
    }
}