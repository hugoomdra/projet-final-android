package com.example.projetfinalandroid

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androideseo.data.LocalPreferences
import com.example.projetfinalandroid.data.HistoriqueAdapter
import com.example.projetfinalandroid.databinding.ActivityHistoriqueBinding
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

        val items : Array<String> = LocalPreferences.getInstance(this).getHistory()!!.toTypedArray()

        val res : Array<String> = arrayOf("super", "test", "oslo", "rayhko", "voxytech","unzinziin")

        recyclerView.adapter = HistoriqueAdapter(res);

        Log.d("test", LocalPreferences.getInstance(this).getHistory().toString())
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