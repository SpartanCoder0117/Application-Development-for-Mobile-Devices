package com.example.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView txv1;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnFact, btnRes;
    Button btnC;// btnB;
    String operador, mostrar, reserva;
    double factorial = 1;
    double numero;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnFact = findViewById(R.id.btnFact);
        btnRes = findViewById(R.id.btnRes);
        btnC = findViewById(R.id.btnClean);
        //btnB = findViewById(R.id.btnBrr);
        txv1 = findViewById(R.id.et1);

        btn0.setOnClickListener(bn0Listener);
        btn1.setOnClickListener(bn1Listener);
        btn2.setOnClickListener(bn2Listener);
        btn3.setOnClickListener(bn3Listener);
        btn4.setOnClickListener(bn4Listener);
        btn5.setOnClickListener(bn5Listener);
        btn6.setOnClickListener(bn6Listener);
        btn7.setOnClickListener(bn7Listener);
        btn8.setOnClickListener(bn8Listener);
        btn9.setOnClickListener(bn9Listener);
        btnRes.setOnClickListener(bnIListener);
        btnFact.setOnClickListener(bnFListener);
        btnC.setOnClickListener(bnCListener);
        //btnB.setOnClickListener(bnBListener);

    }

    public OnClickListener bn0Listener = new OnClickListener() {
        public void onClick(View v) {
           mostrar = txv1.getText().toString();
           mostrar = mostrar + 0;
           txv1.setText(mostrar);
        }
    };

    public OnClickListener bn1Listener = new OnClickListener() {
        public void onClick(View v) {
            mostrar = txv1.getText().toString();
            mostrar = mostrar + 1;
            txv1.setText(mostrar);
        }
    };

    public OnClickListener bn2Listener = new OnClickListener() {
        public void onClick(View v) {
            mostrar = txv1.getText().toString();
            mostrar = mostrar + 2;
            txv1.setText(mostrar);
        }
    };

    public OnClickListener bn3Listener = new OnClickListener() {
        public void onClick(View v) {
            mostrar = txv1.getText().toString();
            mostrar = mostrar + 3;
            txv1.setText(mostrar);
        }
    };

    public OnClickListener bn4Listener = new OnClickListener() {
        public void onClick(View v) {
            mostrar = txv1.getText().toString();
            mostrar = mostrar + 4;
            txv1.setText(mostrar);
        }
    };

    public OnClickListener bn5Listener = new OnClickListener() {
        public void onClick(View v) {
            mostrar = txv1.getText().toString();
            mostrar = mostrar + 5;
            txv1.setText(mostrar);
        }
    };

    public OnClickListener bn6Listener = new OnClickListener() {
        public void onClick(View v) {
            mostrar = txv1.getText().toString();
            mostrar = mostrar + 6;
            txv1.setText(mostrar);
        }
    };

    public OnClickListener bn7Listener = new OnClickListener() {
        public void onClick(View v) {
            mostrar = txv1.getText().toString();
            mostrar = mostrar + 7;
            txv1.setText(mostrar);
        }
    };

    public OnClickListener bn8Listener = new OnClickListener() {
        public void onClick(View v) {
            mostrar = txv1.getText().toString();
            mostrar = mostrar + 8;
            txv1.setText(mostrar);
        }
    };

    public OnClickListener bn9Listener = new OnClickListener() {
        public void onClick(View v) {
            mostrar = txv1.getText().toString();
            mostrar = mostrar + 9;
            txv1.setText(mostrar);
        }
    };

    public OnClickListener bnFListener = new OnClickListener() {
        public void onClick(View v) {
            reserva = txv1.getText().toString();
            operador = "!";
            txv1.setText(operador);
        }
    };

    public OnClickListener bnIListener = new OnClickListener() {
        public void onClick(View v) {
            mostrar = txv1.getText().toString();
            mostrar = mostrar + 1;
            //condicion = mostrar + "!";
            numero = Double.parseDouble(reserva);
            if(operador.equals("!")){
                while(numero != 0){
                    factorial = factorial * numero;
                    numero--;
                }
                txv1.setText(String.valueOf(factorial));
            }
        }
    };

    public OnClickListener bnCListener = new OnClickListener() {
        public void onClick(View v) {
            mostrar = "";
            txv1.setText(mostrar);
            reserva = "";
            operador = "";
            factorial = 1;
        }
    };

    /*public OnClickListener bnBListener = new OnClickListener() {
        public void onClick(View v) {
            mostrar = txv1.getText().toString();
            mostrar = mostrar.substring(0,mostrar.length()-1);
            txv1.setText(mostrar);
        }
    };*/
}
