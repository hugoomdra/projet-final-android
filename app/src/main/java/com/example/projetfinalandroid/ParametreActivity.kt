package com.example.projetfinalandroid

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import com.example.projetfinalandroid.data.ParametreAdapter
import kotlinx.android.synthetic.main.activity_parametre.*

class ParametreActivity : AppCompatActivity() {

    data class ParametreItem(val name: String, val onClick: (() -> Unit))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parametre)

        supportActionBar?.apply {
            setTitle(getString(R.string.topbar_parametre))
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val settings = arrayOf(
            ParametreItem("Paramètre application", {
                startActivity(Intent(Settings.ACTION_SETTINGS))
            }),
            ParametreItem("Paramètre localisation", {
                startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
            }),
            ParametreItem("Carte ESEO", {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("geo:47.492884574915365,-0.5509639806591626")));
            }),
            ParametreItem("Site de l'ESEO", {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://eseo.fr/")))
            }),
            ParametreItem("Me contacter", {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("mailto:hugoomdra@gmail.com?Subject="
                        + Uri.encode("Contact depuis l'application")
                        + "&Body="
                        + Uri.encode("Hey, je te contacte depuis l'application car j'aimerais te dire que ..."))))
            }),
            ParametreItem("A Propos de Moi", {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/hugo-madureira/")))
            }),

        )

        recyclerView.adapter = ParametreAdapter(settings)

    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, ParametreActivity::class.java)
        }
    }
}