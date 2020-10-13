package com.example.listaimagenes2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Intent in;
    Button btnI;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        btnI = findViewById(R.id.btn);
        btnI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                in = new Intent(MainActivity.this, Imagenes.class);
                startActivity(in);
            }
        });
    }
}
