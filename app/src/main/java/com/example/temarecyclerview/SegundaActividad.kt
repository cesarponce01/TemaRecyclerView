package com.example.temarecyclerview


import android.annotation.SuppressLint
import android.content.Intent

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.temarecyclerview.model.Planeta

//import com.example.examen_cesar_oswaldo_ponce_chavez.model.Planeta

class segundaActividad: AppCompatActivity() {

    private lateinit var tvNombre: TextView
    private lateinit var ivImagen: ImageView
    private lateinit var tvDescubrimiento: TextView
    private lateinit var tvSatelite : TextView
    private lateinit var tvAnillo : TextView
    private lateinit var tvTipo : TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.segundo_layout)

        tvNombre=findViewById(R.id.tvNombre)
        tvDescubrimiento=findViewById(R.id.tvDescubrimiento)
        tvTipo=findViewById(R.id.tvTipo)
        ivImagen=findViewById(R.id.ivImagen)
        tvSatelite=findViewById(R.id.tvSatelite)
        tvAnillo=findViewById(R.id.tvAnillo)

        val bundlePlaneta =intent.getBundleExtra("clasePlaneta")
        val planeta= Planeta(bundlePlaneta!!)

        tvNombre.text = planeta.nombre
        tvDescubrimiento.text = planeta.descubrimiento
        tvTipo.text = planeta.tipo
        ivImagen.setImageBitmap(planeta.imagen)
        tvSatelite.text = planeta.satelite.toString()  // Asumiendo que satelite es de tipo Int
        tvAnillo.text = planeta.anillo.toString()  //Asumiendo que anillo es de tipo Int


    }


    fun onVolver(view: View){

        var inten2= Intent(this,MainActivity::class.java)
        setResult(RESULT_OK,inten2)
        finish()
    }
}