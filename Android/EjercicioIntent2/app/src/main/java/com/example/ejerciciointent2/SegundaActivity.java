package com.example.ejerciciointent2;

import android.os.Bundle;
import android.app.Activity;
import android.widget.*;
public class SegundaActivity extends Activity{
    //EditText jet;
    Bundle bdl;
    TextView tx1, tx2;
    /*Bundle bdl2;
    Bundle bdl3;*/
    double a, c, s;
    double x1, x2;
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_segunda);
        //jet = findViewById(R.id.xet1);
        tx1 = findViewById(R.id.xtv2);
        tx2 = findViewById(R.id.xtv3);
        /*bdl = getIntent().getExtras();
        bdl2 = getIntent().getExtras();
        bdl3 = getIntent().getExtras();*/
        //jet.append(bdl.getString("A") + "x^2" + " + " + bdl2.getString("B") + "x" + " + " + bdl3.getString("C"));
        bdl = this.getIntent().getExtras();
        a = bdl.getDouble("A");
        s = bdl.getDouble("B");
        c = bdl.getDouble("C");
        //jet.append(a + "x^2" + " + " + s + "x" + " + " + c + " = " + " 0");
        if(s * s < 4 * a * c){
            tx1.append("La solución pertenece a los numeros complejos");
        }else if(a != 0 && s * s > 4 * a * c){
            x1 = (-s + Math.sqrt(Math.pow(s,2) - 4*a*c))/(2*a);
            x2 = (-s - Math.sqrt(Math.pow(s,2) - 4*a*c))/(2*a);
            tx1.append("La primera raiz es: " + x1);
            tx2.append("La segunda raiz es: " + x2);
        }
    }
}