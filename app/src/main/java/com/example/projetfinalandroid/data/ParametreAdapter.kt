package com.example.projetfinalandroid.data

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetfinalandroid.ParametreActivity
import com.example.projetfinalandroid.R

class ParametreAdapter(private val parametreList: Array<ParametreActivity.ParametreItem>) : RecyclerView.Adapter<ParametreAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun displayItem(item: ParametreActivity.ParametreItem){
            itemView.findViewById<TextView>(R.id.textItem).text = item.name
            itemView.findViewById<TextView>(R.id.textItem).setOnClickListener({
                item.onClick.invoke()
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.historique_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.displayItem(parametreList[position])
    }

    override fun getItemCount(): Int {
        return parametreList.size
    }

}