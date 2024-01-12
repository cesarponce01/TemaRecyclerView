package com.example.temarecyclerview


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.temarecyclerview.adapter.PlanetaAdapter
import com.example.temarecyclerview.models.Planeta
class MainActivity : AppCompatActivity() {

      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerViewPlaneta: RecyclerView =findViewById(R.id.recyclerPlaneta)

          var planeList=generarPlanetas()
          var planetaAdapter=PlanetaAdapter(planeList)
          recyclerViewPlaneta.adapter =planetaAdapter

          //recyclerViewPlaneta.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)




          planetaAdapter.setOnItemClickListener(object : PlanetaAdapter.OnMyClickListener{
            override fun onClick( planet:Planeta){
                Toast.makeText(applicationContext,planet.name, Toast.LENGTH_LONG).show()
            }
          })

    }


    @SuppressLint("SuspiciousIndentation")
    fun generarPlanetas(): ArrayList<Planeta>{
        var planeta = ArrayList<Planeta>()

        var lista = Planeta("Mercurio", "Rocoso", R.drawable.mercurio)
            planeta.add(lista)

        lista=Planeta("Venus", "Rocoso", R.drawable.venus)
        planeta.add(lista)

        lista=Planeta("Tierra", "Rocoso",  R.drawable.tierra)
        planeta.add(lista)

        lista=Planeta("Marte", "Rocoso",  R.drawable.marte)
        planeta.add(lista)

        lista=Planeta("Júpiter", "Gaseoso",  R.drawable.jupiter)
        planeta.add(lista)

        lista=Planeta("Saturno", "Gaseoso",  R.drawable.saturno)
        planeta.add(lista)

        lista=Planeta("Urano", "Masa Congelada", R.drawable.urano)
        planeta.add(lista)

        lista=Planeta("Neptuno", "Masa Congelada", R.drawable.neptuno)
        planeta.add(lista)


        return planeta
    }

}