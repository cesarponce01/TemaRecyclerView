package com.example.temarecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.temarecyclerview.R
import com.example.temarecyclerview.models.Planeta

class PlanetaAdapter(private val listaPlanetas: ArrayList<Planeta>) :
    RecyclerView.Adapter<PlanetaAdapter.PlanetaViewHolder> (){

    private var onMyClickListener: OnMyClickListener? = null
    interface OnMyClickListener{
        fun onClick(planet:Planeta)
    }

    class PlanetaViewHolder(itemView : View) :
        RecyclerView.ViewHolder(itemView){

        val tvNombre: TextView
        val ivImagen: ImageView
        val tvTipo: TextView

        init {
            tvNombre=itemView.findViewById(R.id.adapterNombre)
            ivImagen=itemView.findViewById(R.id.adapterImagen)
            tvTipo=itemView.findViewById(R.id.adapterTipo)
        }

        fun render(planetaModelo: Planeta, onMyClickListener: OnMyClickListener?){
            tvNombre.text=planetaModelo.name
            ivImagen.setImageResource(planetaModelo.image)
            tvTipo.text=planetaModelo.type

            itemView.setOnClickListener{
               if (onMyClickListener != null){
                   onMyClickListener.onClick(planetaModelo)
               }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetaViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.planet_item,parent,false)
        return PlanetaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaPlanetas.size
    }

    override fun onBindViewHolder(holder: PlanetaViewHolder, position: Int) {
        //holder.tvNombre.text = listaPlanetas[position].name
        //holder.tvTipo.text = listaPlanetas[position].type
        //holder.ivImagen.setImageResource(listaPlanetas[position].image)

        holder.render(listaPlanetas[position], onMyClickListener)
    }

    fun setOnItemClickListener(onMyClickListener: OnMyClickListener){
        this.onMyClickListener = onMyClickListener
    }
}