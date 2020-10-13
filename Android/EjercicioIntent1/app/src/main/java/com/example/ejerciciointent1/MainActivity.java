package com.example.ejerciciointent1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.content.Intent;
import android.widget.*;

public class MainActivity extends Activity {

    EditText et1, et2;
    Button btn;
    Bundle bdl;
    Bundle bdl2;
    Intent intn;
    //Intent intn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btnE);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                intn = new Intent(MainActivity.this, SegundaActivity.class);
                bdl = new Bundle();
                bdl2 = new Bundle();
                bdl.putString("NOMBRE", et1.getText().toString());
                bdl2.putString("APELLIDO", et2.getText().toString());
                intn.putExtras(bdl);
                intn.putExtras(bdl2);
                startActivity(intn);
                //startActivity(intn2);
            }
        });

    }
}
