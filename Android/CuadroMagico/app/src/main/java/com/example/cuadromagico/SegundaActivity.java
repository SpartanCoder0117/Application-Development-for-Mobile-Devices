package com.example.cuadromagico;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.widget.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SegundaActivity extends Activity{
    int n;
    int i_ant = 0;
    int j_ant = 0;
    int punto_ini;
    int temp = 1;
    int [][] matriz_magica;

    String aux = "";

    Bundle bdl2;

    TableLayout tabla;
    TextView columna;
    TableRow fila;
    TableRow.LayoutParams params = new TableRow.LayoutParams();

    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_segunda);

        tabla = findViewById(R.id.tabla);
        //columna = findViewById(R.id.texto);

        bdl2 = this.getIntent().getExtras();
        n = bdl2.getInt("Numero");

        //Logica cuadro magico
        ////////////////////////////////////////////////////////////////////////////////////////////
        punto_ini = n/2;
        matriz_magica = new int[n][n];

        //Llena matriz de ceros
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matriz_magica[i][j] = 0;
            }
        }

        int i = 0;
        int j = punto_ini;

        while(temp != (n*n) + 1){
            if(matriz_magica[i][j] == 0){
                matriz_magica[i][j] = temp;
            }else{
                i = i_ant + 1;
                j = j_ant;
                matriz_magica[i][j] = temp;
            }

            i_ant = i;
            j_ant = j;

            temp++;
            j++;
            i--;

            if(i < 0 && j == n){
                i = n - 1;
                j = 0;
            }else if(i < 0){
                i = i + n;
            }else if(j == n){
                j = 0;
            }
        }
        //Termina logica
        ////////////////////////////////////////////////////////////////////////////////////////////
        //Impresion de datos
        //List<Integer> list = new ArrayList<Integer>();
        fila = new TableRow(getBaseContext());
        for(int x = 0; x < n; x++){ //filas
            for(int y = 0; y < n; y++){ //columnas
                if(y == n - 1){
                    columna = new TextView(getBaseContext());
                    columna.setGravity(Gravity.CENTER);
                    columna.setPadding(1, 1, 1, 1);
                    columna.setBackgroundResource(R.color.colorPrimaryDark);
                    columna.setTextColor(Color.WHITE);
                    params.setMargins(1,1,1,1);
                    params.weight = 1;
                    //if((matriz_magica.length/n) == n - 1)
                    //x = 0;
                    columna.append("" + matriz_magica[x][y] + "\n");

                    fila.addView(columna, params);
                    //tabla.addView(fila);
                }else {
                    columna = new TextView(getBaseContext());
                    columna.setGravity(Gravity.CENTER);
                    columna.setPadding(1, 1, 1, 1);
                    columna.setBackgroundResource(R.color.colorPrimaryDark);
                    columna.setTextColor(Color.WHITE);
                    params.setMargins(1,1,1,1);
                    params.weight = 1;

                    columna.append("" + matriz_magica[x][y]);

                    fila.addView(columna,params);
                    //tabla.addView(fila);
                }
                //tabla.addView(fila);
                //list.add(matriz_magica[x][y]);
                /*if(y == n - 1){
                    columna.append(matriz_magica[x][y] + "\n");
                }else{
                    columna.append("" + matriz_magica[x][y]);
                }*/
            }
            //tabla.addView(fila);
        }
        tabla.addView(fila);

       /* fila = new TableRow(getBaseContext());
        int[] vector = new int[list.size()];
        for(int z = 0; z < vector.length; z++){ //vector.length
            vector[z] = list.get(z);

            if(z == n - 1){
                aux = aux + vector[z] + "\n";
                columna = new TextView(getBaseContext());
                columna.setGravity(Gravity.CENTER);
                columna.setPadding(1, 1, 1, 1);
                columna.setBackgroundResource(R.color.colorPrimaryDark);
                columna.append(aux);
                columna.setTextColor(Color.WHITE);
                params.setMargins(1,1,1,1);
                params.weight = 1;

                fila.addView(columna, params);
            }else{
                aux = aux + vector[z];
                columna = new TextView(getBaseContext());
                columna.setGravity(Gravity.CENTER);
                columna.setPadding(1, 1, 1, 1);
                columna.setBackgroundResource(R.color.colorPrimaryDark);
                columna.append(aux);
                columna.setTextColor(Color.WHITE);
                params.setMargins(1,1,1,1);
                params.weight = 1;

                fila.addView(columna, params);
            }
        }
        tabla.addView(fila);*/
        //Termina impresion
    }
}