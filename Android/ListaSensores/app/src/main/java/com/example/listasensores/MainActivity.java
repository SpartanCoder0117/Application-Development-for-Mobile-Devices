package com.example.listasensores;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.*;
import java.util.ArrayList;
import android.content.Context;
import android.hardware.*;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView lvItems;
    private Adaptador adaptador;
    TextView tx;
    Sensor s;
    SensorManager sm;
    List <Sensor> l;
    String c, v;
    int n, t;
    float p, r, d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx = findViewById(R.id.texto);
        lvItems = findViewById(R.id.listado);
        adaptador = new Adaptador(this, GetArrayItems());
        lvItems.setAdapter(adaptador);
        //Este fragmento de codigo sirve para mostrar el TOAST
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Entidad le = (Entidad) adapterView.getItemAtPosition(i);
                CharSequence cs = "Seleccionado: " + le.get_textoDebajo();
                Toast t = Toast.makeText(MainActivity.this, cs, Toast.LENGTH_SHORT);
                t.show();
            }
        });
    }

    private ArrayList<Entidad> GetArrayItems(){
        ArrayList<Entidad> listItems = new ArrayList<>();
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        l = sm.getSensorList(Sensor.TYPE_ALL);
        n = l.size();
        tx.append("Sensores detectados: " + n + "\n");

        s = l.get(0);
        t = s.getType();
        c = s.getName();
        v = s.getVendor();
        p = s.getPower();
        r = s.getResolution();
        d = s.getMaximumRange();
        listItems.add(new Entidad(R.drawable.acelerometro, "" + c, "Tipo: " + t + "\n" + "Proveedor: " + v + "\n" + "Potencia (ma): " + p + "\n" + "Maxima resolución: " + r + "\n" + "Rango: " + d + ""));
        s = l.get(1);
        t = s.getType();
        c = s.getName();
        v = s.getVendor();
        p = s.getPower();
        r = s.getResolution();
        d = s.getMaximumRange();
        listItems.add(new Entidad(R.drawable.proximidad,  "" + c, "Tipo: " + t + "\n" + "Proveedor: " + v + "\n" + "Potencia (ma): " + p + "\n" + "Maxima resolución: " + r + "\n" + "Rango: " + d + ""));
        s = l.get(2);
        t = s.getType();
        c = s.getName();
        v = s.getVendor();
        p = s.getPower();
        r = s.getResolution();
        d = s.getMaximumRange();
        listItems.add(new Entidad(R.drawable.luz, "" + c, "Tipo: " + t + "\n" + "Proveedor: " + v + "\n" + "Potencia (ma): " + p + "\n" + "Maxima resolución: " + r + "\n" + "Rango: " + d + ""));
        s = l.get(3);
        t = s.getType();
        c = s.getName();
        v = s.getVendor();
        p = s.getPower();
        r = s.getResolution();
        d = s.getMaximumRange();
        listItems.add(new Entidad(R.drawable.orientacion, "" + c, "Tipo: " + t + "\n" + "Proveedor: " + v + "\n" + "Potencia (ma): " + p + "\n" + "Maxima resolución: " + r + "\n" + "Rango: " + d + ""));
        s = l.get(4);
        t = s.getType();
        c = s.getName();
        v = s.getVendor();
        p = s.getPower();
        r = s.getResolution();
        d = s.getMaximumRange();
        listItems.add(new Entidad(R.drawable.magnetometro, "" + c, "Tipo: " + t + "\n" + "Proveedor: " + v + "\n" + "Potencia (ma): " + p + "\n" + "Maxima resolución: " + r + "\n" + "Rango: " + d + ""));


        /*listItems.add(new Entidad(R.drawable.acelerometro, "" + t + ", " + c, "Proveedor: " + v + "\n" + "Potencia (ma): " + p + "\n" + "Maxima resolución: " + r + "\n" + "Rango: " + d + ""));
        listItems.add(new Entidad(R.drawable.proximidad, "" + t + ", " + c, "Proveedor: " + v + "\n" + "Potencia (ma): " + p + "\n" + "Maxima resolución: " + r + "\n" + "Rango: " + d + ""));
        listItems.add(new Entidad(R.drawable.luz, "" + t + ", " + c, "Proveedor: " + v + "\n" + "Potencia (ma): " + p + "\n" + "Maxima resolución: " + r + "\n" + "Rango: " + d + ""));
        listItems.add(new Entidad(R.drawable.orientacion, "" + t + ", " + c, "Proveedor: " + v + "\n" + "Potencia (ma): " + p + "\n" + "Maxima resolución: " + r + "\n" + "Rango: " + d + ""));
        listItems.add(new Entidad(R.drawable.magnetometro, "" + t + ", " + c, "Proveedor: " + v + "\n" + "Potencia (ma): " + p + "\n" + "Maxima resolución: " + r + "\n" + "Rango: " + d + ""));*/

        /*for(int i=0; i<n; i++){
            s = l.get(i);
            t = s.getType();
            c = s.getName();
            v = s.getVendor();
            p = s.getPower();
            r = s.getResolution();
            d = s.getMaximumRange();
            /*jtv.append("\nTipo de sensor: " + t + ", " + c);
            jtv.append("\nProveedor: " + v);
            jtv.append("\nPotencia (ma): " + p);
            jtv.append("\nMáxima resolución: " + r);
            jtv.append(", rango: " + d + "\n");
        }*/

        return listItems;
    }
}
