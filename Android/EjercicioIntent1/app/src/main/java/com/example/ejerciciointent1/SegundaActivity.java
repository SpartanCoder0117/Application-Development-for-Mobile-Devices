package com.example.ejerciciointent1;

import android.os.Bundle;
import android.app.Activity;
import android.widget.*;
public class SegundaActivity extends Activity{
    EditText jet, jet2;
    Bundle bdl, bdl2;
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_segunda);
        jet = findViewById(R.id.xet1);
        jet2 = findViewById(R.id.xet2);
        bdl = getIntent().getExtras();
        bdl2 = getIntent().getExtras();
        jet.append(bdl.getString("NOMBRE"));
        jet2.append(bdl2.getString("APELLIDO"));
    }
}
