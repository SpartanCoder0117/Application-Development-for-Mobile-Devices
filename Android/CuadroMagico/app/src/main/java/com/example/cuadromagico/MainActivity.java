package com.example.cuadromagico;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
    int n;
    EditText et1;
    Button btn;
    Bundle bdl;
    Intent intn;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.xet);
        btn = findViewById(R.id.xbn);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                intn = new Intent(MainActivity.this, SegundaActivity.class);
                bdl = new Bundle();
                n = Integer.parseInt(et1.getText().toString());
                bdl.putInt("Numero", n);
                intn.putExtras(bdl);
                startActivity(intn);
            }
        });

    }
}
