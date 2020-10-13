package com.example.pruebatabladinamica;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends Activity {

    TextView nombre, direccion, textView;
    Button btn;
    TableLayout lista;
    TableRow row;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.editText);
        direccion = findViewById(R.id.editText2);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lista = findViewById(R.id.lista);
                String[] cadena = {nombre.getText().toString(), direccion.getText().toString()};
                row = new TableRow(getBaseContext());
                for(int i = 0; i < 2; i++){
                    textView = new TextView(getBaseContext());
                    textView.setGravity(Gravity.CENTER);
                    textView.setPadding(1, 1, 1, 1);
                    textView.setBackgroundResource(R.color.colorPrimaryDark);
                    textView.setText(cadena[i]);
                    textView.setTextColor(Color.WHITE);
                    TableRow.LayoutParams params = new TableRow.LayoutParams();
                    params.setMargins(1,1,1,1);
                    params.weight = 1;
                    row.addView(textView, params);
                }
                lista.addView(row);
            }
        });
    }

    /*private TableRow.LayoutParams newTableRowParams(){
        TableRow.LayoutParams params = newTableRowParams();
        params.setMargins(1,1,1,1);
        params.weight = 1;
        return params;
    }*/
}
