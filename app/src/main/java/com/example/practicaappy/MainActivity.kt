package com.example.practicaappy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
lateinit var textoAMostrar:TextView
lateinit var boton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textoAMostrar = findViewById(R.id.texto)
        boton = findViewById(R.id.button)

        boton.setOnClickListener {


            textoAMostrar.text = crearPalabra()

        }

    }

    fun crearPalabra(): String {
        val palabra= "CELULAR"
        var palabraFinal= arrayOfNulls<Char>(palabra.length)
        var palabraFinal2= arrayOfNulls<Char>(palabra.length)

        var posicionRepetidaNo= arrayOfNulls<Int>(palabra.length)
        val cantidadDeLetras =palabra.length
        var contador=0
        var posicion =0
        var letra : Char
        var retorno=""
        var noSeRepite=true
        var repetido=0;
        while (contador<cantidadDeLetras ) {

           posicion = (Math.random() * cantidadDeLetras).toInt()
     // posicion=contador
            posicionRepetidaNo[contador] = posicion

            while (repetido!=1) {
                posicionRepetidaNo.forEach {
                    posicionRepetidaNo[contador]= posicion
                    repetido=1
                    var actual = "$it"
                    if (actual == posicion.toString()) {
                        noSeRepite = false
                        posicion++
                        repetido=0
                        if(posicion==palabra.length)posicion=0
                    }

                }

            }
                if(noSeRepite) {
                letra = palabra.get(posicion) //busca una letra de la palabra original
                palabraFinal[contador] = letra  // coloca la letra en la palabra desordenada
                contador++
            }
            noSeRepite=true


        }
        palabraFinal.forEach {
         retorno="$retorno$it"  //arma la palabra en un string
        }
        return retorno
    }

}
