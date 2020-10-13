package com.example.ejemplokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var edt: EditText? = null
    private var edt2: EditText? = null
    private var edt3: EditText? = null
    private var a: String? = null
    private var b: String? = null
    private var c: String? = null
    private var btnC: Button? = null

    private var Ad: Double = 0.0
    private var Bd: Double = 0.0
    private var Cd: Double = 0.0

    private var x1: Double = 0.0
    private var x2: Double = 0.0

    private var aux1: Double = 0.0
    private var aux2: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv.setText("Ingresa a: ")
        tv2.setText("Ingresa b: ")
        tv3.setText("Ingresa c: ")
        btn.setText("Calcular")

        edt = findViewById<EditText>(R.id.et)
        edt2 = findViewById<EditText>(R.id.et2)
        edt3 = findViewById<EditText>(R.id.et3)
        btnC = findViewById<Button>(R.id.btn)

        btnC?.setOnClickListener(){
            a = edt?.text.toString()
            b = edt2?.text.toString()
            c = edt3?.text.toString()

            Ad = a?.toDouble()!!
            Bd = b?.toDouble()!!
            Cd = c?.toDouble()!!

            if(Ad == 0.0){
                //x1 = (Cd / Bd) * -1.0
                tv4.setText("No es una ecuacion de segundo grado")
                tv5.setText("")
            }else if(Bd == 0.0 && Cd != 0.0){

                if((Cd / Ad) > 0){
                    x1 = (Math.sqrt(-(Cd / Ad) * - 1))
                    x2 = -(Math.sqrt(-(Cd / Ad) * - 1 ))
                    tv4.setText("La primera raiz compleja es: " + x1 + " i")
                    tv5.setText("La segunda raiz compleja es: " + x2 + " i")
                }else{
                    x1 = (Math.sqrt(-(Cd / Ad)))
                    x2 = -(Math.sqrt(-(Cd / Ad)))
                    tv4.setText("La primera raiz es: " + x1)
                    tv5.setText("La segunda raiz es: " + x2)
                }

            }else if(Cd == 0.0 && Bd != 0.0){
                x1 = 0.0
                x2 = -Bd / Ad
                tv4.setText("La primera raiz es: " + x1)
                tv5.setText("La segunda raiz es: " + x2)
            }else if(Bd == 0.0 && Cd == 0.0){
                x1 = 0.0
                tv4.setText("La raiz es: " + x1)
                tv5.setText("")
            }else if(((Bd * Bd) - (4 * Ad * Cd)) == 0.0 ){
                x1 = (-Bd + Math.sqrt(Math.pow(Bd,2.0) - 4*Ad*Cd))/(2*Ad)
                x2 = (-Bd - Math.sqrt(Math.pow(Bd,2.0) - 4*Ad*Cd))/(2*Ad)
                tv4.setText("La primera raiz es: " + "\n"+ x1)
                tv5.setText("La segunda raiz es: " + "\n" + x2)
            }else if(((Bd * Bd) - (4 * Ad * Cd)) > 0.0 ){
                x1 = (-Bd + Math.sqrt(Math.pow(Bd,2.0) - 4*Ad*Cd))/(2*Ad)
                x2 = (-Bd - Math.sqrt(Math.pow(Bd,2.0) - 4*Ad*Cd))/(2*Ad)
                tv4.setText("La primera raiz es: " + "\n" + x1)
                tv5.setText("La segunda raiz es: " + "\n" + x2)
            }else if(((Bd * Bd) - (4 * Ad * Cd)) < 0.0 ){
                aux1 = -Bd / (2*Ad)
                aux2 = Math.sqrt((Math.pow(Bd,2.0) - 4*Ad*Cd) * - 1.0)/(2*Ad)

                tv4.setText("La primera raiz compleja es:" + "\n" + aux1 + " + " + aux2 + " i")
                tv5.setText("La segunda raiz compleja es:" + "\n" + aux1 + " - " + aux2 + " i")
                //x1 = (-Bd + Math.sqrt(Math.pow(Bd,2.0) - 4*Ad*Cd))/(2*Ad)
                //x2 = (-Bd - Math.sqrt(Math.pow(Bd,2.0) - 4*Ad*Cd))/(2*Ad)
                //tv4.setText("No existe")
                //tv5.setText("La segunda raiz es: " + x2)
            }
        }

    }
}
