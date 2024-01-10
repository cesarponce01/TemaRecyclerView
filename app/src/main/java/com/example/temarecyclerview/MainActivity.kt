package com.example.temarecyclerview


import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.BitmapFactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.example.temarecyclerview.adapter.PlanetaAdapter
import com.example.temarecyclerview.model.Planeta

//import com.example.examen_cesar_oswaldo_ponce_chavez.adapter.PlanetaAdapter
//import com.example.examen_cesar_oswaldo_ponce_chavez.model.Planeta

class MainActivity : AppCompatActivity() {

    /*lateinit var tvNombre: TextView
    lateinit var ivImagen: ImageView
    lateinit var tvDescubrimiento: TextView
    lateinit var tvSatelite : TextView
    lateinit var tvAnillo : TextView
    lateinit var tvTipo : TextView*/

    private lateinit var listViewItems: ListView
    private lateinit var listaPlanetas: MutableList<Planeta>


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        listViewItems = findViewById(R.id.lvLista)
        listaPlanetas= mutableListOf(
            Planeta("Mercurio", "Descubierto por el Inglés Thomas Harriot en 1631",0,0,"Rocoso", BitmapFactory.decodeResource(resources, R.drawable.mercurio)),
            Planeta("Venus", "Descubierto por Galilei en 1610",0,0,"Rocoso", BitmapFactory.decodeResource(resources, R.drawable.venus)),
            Planeta("Tierra", "Desde el IV antes de la era común se hace mención del planeta",1,0,"Rocoso", BitmapFactory.decodeResource(resources, R.drawable.tierra)),
            Planeta("Marte", "Descubierto por Galileo Galilei en 1610",2,0,"Rocoso", BitmapFactory.decodeResource(resources, R.drawable.marte)),
            Planeta("Júpiter", "Descubierto por Galilei en 1610",95,3,"Gaseoso", BitmapFactory.decodeResource(resources, R.drawable.jupiter)),
            Planeta("Saturno", "Descubierto por Galilei en 1610",146,7,"Gaseoso", BitmapFactory.decodeResource(resources, R.drawable.saturno)),
            Planeta("Urano", "Descubierto por William Herschel en 1781",27,13,"Masa Congelada",BitmapFactory.decodeResource(resources, R.drawable.urano)),
            Planeta("Neptuno", "Descubierto por Johann Galle en 1846",14,6,"Masa Congelada", BitmapFactory.decodeResource(resources, R.drawable.neptuno)))


        //Estamos creando el adaptador y lo enlazamos con los datos a la vez
        var planetaAdapter= PlanetaAdapter(this, listaPlanetas)

        listViewItems.adapter=planetaAdapter


        listViewItems.onItemClickListener= AdapterView.OnItemClickListener { parent, view, position, id ->
            val perfilPlaneta=listaPlanetas[position]
            val miIntent= Intent(this,segundaActividad::class.java)
            miIntent.putExtra("clasePlaneta", perfilPlaneta.getBundle())
            startActivity(miIntent)
        }
    }
}