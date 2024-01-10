package com.example.temarecyclerview.model

import android.graphics.Bitmap
import android.os.Bundle

class Planeta {

    var imagen: Bitmap? = null
    var tipo: String? = ""
    var anillo: Int = 0
    var satelite: Int = 0
    var descubrimiento: String? = ""
    var nombre: String? = ""

    constructor(
        nombre: String,
        descubrimiento: String,
        satelite: Int,
        anillo: Int,
        tipo: String,
        imagen: Bitmap?
    ) {
        this.nombre = nombre
        this.descubrimiento = descubrimiento
        this.satelite = satelite
        this.anillo = anillo
        this.tipo = tipo
        this.imagen = imagen
    }

    constructor(bundle: Bundle) {
        this.nombre = bundle.getString("nombre")!!
        this.tipo = bundle.getString("tipo")!!
        this.descubrimiento = bundle.getString("descubrimiento")!!
        this.anillo = bundle.getInt("anillo")!!
        this.satelite = bundle.getInt("satelite")!!
        this.imagen = bundle.getParcelable("imagen")!!

    }


    fun getBundle(): Bundle? {
        var bundle = Bundle()

        bundle.putString("nombre", this.nombre)
        bundle.putString("tipo", this.tipo)
        bundle.putString("descubrimiento", this.descubrimiento)
        bundle.putInt("satelite", this.satelite)
        bundle.putInt("anillo", this.anillo)
        bundle.putParcelable("imagen", this.imagen)

        return bundle
    }


}