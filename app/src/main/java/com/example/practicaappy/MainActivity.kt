package com.example.practicaappy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
lateinit var textoAMostrar:TextView
lateinit var boton:Button
lateinit var palabraIngresada:EditText
lateinit var chance:Button
    val palabra= "CELULAR"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textoAMostrar = findViewById(R.id.texto)
        boton = findViewById(R.id.button)
        palabraIngresada=findViewById(R.id.palabraIngresada)
        chance=findViewById(R.id.chance)

         boton.setOnClickListener {
          textoAMostrar.text = crearPalabra(palabra)
          palabraIngresada.text.clear()
          }
         chance.setOnClickListener {
             val palabraArriesgada = palabraIngresada.text.toString()
             if (palabraArriesgada == palabra) textoAMostrar.text = "EXITO"
             else textoAMostrar.text="ERROR"
         }
        }

    fun crearPalabra(palabra:String): String {
        var palabraFinal= arrayOfNulls<Char>(palabra.length)
        var posicionRepetidaNo= arrayOfNulls<Int>(palabra.length)
        val cantidadDeLetras =palabra.length
        var contador=0
        var posicion =0
        var letra : Char
        var retorno=""
        var salir=0
        while (contador<cantidadDeLetras ) {
     while (salir==0) {  // impide que se repita alguna letra de la palabra original
                posicion = (Math.random() * cantidadDeLetras).toInt()
               if (posicionRepetidaNo.contains(posicion))
               else {
                    posicionRepetidaNo[contador] = posicion
                    salir=1
               }
            }
            salir=0
                letra = palabra.get(posicion) //busca una letra de la palabra original
                palabraFinal[contador] = letra  // coloca la letra en la palabra desordenada
                contador++
        }
        palabraFinal.forEach {

         retorno="$retorno$it"  //arma la palabra en un string
        }
       return retorno
    }

}