package com.example.ejerciciointent2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    EditText et1, et2, et3;
    Button btn;
    Bundle bdl, bdl2, bdl3;
    Intent itn;
    Double x, y, z;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        btn = findViewById(R.id.xbn);

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                itn = new Intent(MainActivity.this, SegundaActivity.class);
                bdl = new Bundle();
                bdl2 = new Bundle();
                bdl3 = new Bundle();
                x = Double.parseDouble(et1.getText().toString());
                y = Double.parseDouble(et2.getText().toString());
                z = Double.parseDouble(et3.getText().toString());
                bdl.putDouble("A", x);
                bdl2.putDouble("B", y);
                bdl3.putDouble("C", z);
                itn.putExtras(bdl);
                itn.putExtras(bdl2);
                itn.putExtras(bdl3);
                startActivity(itn);
            }
        });
    }
}
