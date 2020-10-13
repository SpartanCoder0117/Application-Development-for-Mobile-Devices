package com.example.nummarav;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    int num = 0, num2;
    int a = 0, b = 0, fibo = 1;
    int inc = 0;

    boolean bError = false;

    TextView jtv1;
    TextView jtv2;
    TextView jtv3;
    TextView jtv4;

    String resultado = "";
    String FB = " es Fibonacci";
    String NFB = " no es Fibonacci";
    String cadena = "";
    String primo = " es numero primo";
    String Nprimo = " no es numero primo";
    String PAL = " es palindromo";
    String NPA = " no es palindromo";
    String Palabra = "anitalavalatina";
    String Numero = "Numero a comprobar: ";

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        Maravilloso();
        Primo();
        Fibonacci();
        Palindromo();
    }

    public void Maravilloso(){
        num = 21;
        num2 = num;
        while(num != 1){
            if(num % 2 == 0){
                num = num/2;
                cadena = cadena + num + "\n";
                jtv1 = findViewById(R.id.xtv1);
                jtv1.setText(Numero + num2 + "\n" + cadena + num2 + " es un numero maravilloso");
            }else{
                num = num * 3 + 1;
                cadena = cadena + num + "\n";
                jtv1 = findViewById(R.id.xtv1);
                jtv1.setText(Numero + num2 + "\n" + cadena + num2 + " es un numero maravilloso");
            }
        }
    }

    public void Primo(){
        num = 21;
        num2 = num - 1;
        while ((num % num2) != 0){
            num2--;
        }
        cadena = (num2 == 1) ? primo : Nprimo;
        jtv2 = findViewById(R.id.xtv2);
        jtv2.setText(num + cadena);
    }

    public void Fibonacci(){
        num = 21;
        while(fibo < num){
            fibo = fibo + a;
            a = b;
            b = fibo;
        }
        resultado = (fibo == num || num == 0) ? FB : NFB;
        jtv3 = findViewById(R.id.xtv3);
        jtv3.setText(num + resultado);
    }

    public void Palindromo(){
        int des = Palabra.length()-1;
        while ((inc<des) && (!bError)){

            if (Palabra.charAt(inc) == Palabra.charAt(des)){
                inc++;
                des--;
            } else {
                bError = true;
            }
        }
        resultado = (!bError) ? PAL : NPA;
        jtv4 = findViewById(R.id.xtv4);
        jtv4.setText("'" + Palabra + "'" + resultado);
    }
}


