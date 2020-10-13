package dyhm.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ImagenCompleta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen_completa);
        Intent i = getIntent();
        String id = i.getStringExtra("imagen");
        ImageView iv;
        // array todos los desc, y comparo
        /* IMAGENES
         1  atlas 2131099735
         2 boson 2131099736
         3 lhc 2131099749
         4 radiacion 2131099765
         5 maquinaria 2131099750
         6 colaboracion 2131099745
         7 colisioniones 2131099746
         8 maquinaria2 2131099751
         9 peso 2131099764
         10 superiman 2131099766
         */
        System.out.println("El numero recibido es: " +id);
        iv = (ImageView) findViewById(R.id.imageFull);
        if(id.equals("0")){
            iv.setImageResource(R.drawable.galileo);
        }else if(id.equals("1")){
            iv.setImageResource(R.drawable.luna);
        }else if(id.equals("2")){
            iv.setImageResource(R.drawable.deimos);
        }else if(id.equals("3")){
            iv.setImageResource(R.drawable.fobos);
        }else if(id.equals("4")){
            iv.setImageResource(R.drawable.lo);
        }else if(id.equals("5")){
            iv.setImageResource(R.drawable.lo2);
        }else if(id.equals("6")){
            iv.setImageResource(R.drawable.europa);
        }else if(id.equals("7")){
            iv.setImageResource(R.drawable.ariel);
        }else if(id.equals("8")){
            iv.setImageResource(R.drawable.estrellas);
        }else if(id.equals("9")){
            iv.setImageResource(R.drawable.energeticos);
        }

    }
}
