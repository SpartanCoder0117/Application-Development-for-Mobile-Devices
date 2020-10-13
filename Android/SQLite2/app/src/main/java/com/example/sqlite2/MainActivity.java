package com.example.sqlite2;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
public class MainActivity extends Activity {
    EditText        jetI, jetN;
    Button         jbnA, jbnL, jbnM, jbnB;
    TextView        jtvL;
    SQLiteDatabase  sqld;
    int d=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jetI = (EditText)   findViewById(R.id.xetI);
        jetN = (EditText)   findViewById(R.id.xetN);
        jbnA = (Button)     findViewById(R.id.xbnA);
        jbnL = (Button)     findViewById(R.id.xbnL);
        jbnM = (Button)     findViewById(R.id.xbnM);
        jbnB = (Button)     findViewById(R.id.xbnB);
        jtvL = (TextView)   findViewById(R.id.xtvL);

        DbmsSQLiteHelper dsqlh = new DbmsSQLiteHelper(this, "DBContactos", null, 1);
        sqld = dsqlh.getWritableDatabase();
        jbnA.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                String          id = jetI.getText().toString();
                String          nombre = jetN.getText().toString();
                String          roid = ((String.valueOf(d)));
                ContentValues   cv = new ContentValues();
                cv.put("roid", roid);
                cv.put("id", id);
                cv.put("nombre", nombre);
                sqld.insert("Contactos", null, cv);
                jetI.setText(""); jetN.setText("");
                d++;
            }
        });
        jbnL.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String id, nombre;
                Cursor c = sqld.rawQuery("SELECT * FROM Contactos", null);
                jtvL.setText("");
                if (c.moveToFirst()) {
                    do {
                        id = c.getString(0);
                        nombre = c.getString(2);
                        jtvL.append(" " + id + "\t" + nombre + "\n");
                    } while(c.moveToNext());
                }
            }
        });
        jbnM.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String          id = jetI.getText().toString();
                String          nombre = jetN.getText().toString();
                ContentValues   cv = new ContentValues();

                sqld.execSQL("UPDATE Contactos SET nombre='"+nombre+"' WHERE roid='"+id+"'");

            }
        });
        jbnB.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String          id = jetI.getText().toString();
                String          nombre = jetN.getText().toString();
                ContentValues   cv = new ContentValues();

                sqld.execSQL("DELETE FROM Contactos WHERE roid='"+id+"'");
            }
        });
    }
}