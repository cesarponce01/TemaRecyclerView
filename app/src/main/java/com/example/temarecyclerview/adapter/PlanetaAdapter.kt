package com.example.temarecyclerview.adapter

import android.app.Activity
import android.database.DataSetObserver
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.temarecyclerview.R
import com.example.temarecyclerview.model.Planeta


class PlanetaAdapter(
    private val activity: Activity,
    private val listaPlanetas: MutableList<Planeta>
) : RecyclerView.Adapter<PlanetaAdapter.ViewHolder>(), ListAdapter {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.adapterNombre)
        val ivImagen: ImageView = itemView.findViewById(R.id.adapterImagen)
        val tvTipo: TextView = itemView.findViewById(R.id.adapterTipo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_adaptador, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNombre.text = listaPlanetas[position].nombre
        holder.tvTipo.text = listaPlanetas[position].tipo
    }



}
