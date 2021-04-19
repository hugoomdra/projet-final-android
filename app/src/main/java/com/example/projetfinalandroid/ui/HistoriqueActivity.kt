package com.example.projetfinalandroid.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.projetfinalandroid.R
import com.example.projetfinalandroid.data.HistoriqueAdapter
import kotlinx.android.synthetic.main.activity_historique.*

class HistoriqueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historique)

        supportActionBar?.apply {
            setTitle(getString(R.string.topbar_historique))
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val items : Array<String> = LocalPreferences.getInstance(this).getHistory()!!.toTypedArray()

        // Liste pour tester le RecyclerView
        // val res : Array<String> = arrayOf("super", "test", "oslo", "rayhko", "voxytech","unzinziin")

        recyclerView.adapter = HistoriqueAdapter(items);

        btn_delete_historique.setOnClickListener{
            LocalPreferences.getInstance(this).deleteAllHistory();
            finish()
        }

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