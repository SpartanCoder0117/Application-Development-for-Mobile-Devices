package com.example.listaimagenes2;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.*;

public class Imagenes extends Activity{
    private ListView lv;
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.listado);
        ArrayList<ListaEntrada> al = new ArrayList<ListaEntrada>();
        al.add(new ListaEntrada(R.drawable.pz1, "Panzer I", "El Panzer I fue un tanque ligero producido en el III Reich en los años 1930. \n" +
                "El nombre es una abreviación del nombre en alemán Panzerkampfwagen I (vehículo de combate blindado modelo I), abreviado como PzKpfw I. \n" +
                "La designación del inventario de vehículos militares alemanes para este tanque era Sd.Kfz. 101"));

        al.add(new ListaEntrada(R.drawable.pz2, "Panzer II", "El nombre es una abreviación de su designación oficial en alemán Panzerkampfwagen II (vehículo de combate blindado modelo II), abreviado como PzKpfw II. \n" +
                "La designación del inventario de vehículos militares alemanes para este tanque era Sd.Kfz. 121. \n" +
                "Se diseñó como recurso provisional mientras se desarrollaban otros tanques y tuvo un papel importante en los primeros años del conflicto, durante las campañas de Polonia y Francia. A finales de 1942 se retiró del frente de batalla, y la producción del tanque cesó en 1943, aunque su chasis fue utilizado para otros vehículos blindados."));

        al.add(new ListaEntrada(R.drawable.pz3, "Panzer III", "Panzerkampfwagen III (vehículo de combate blindado modelo III), abreviado como PzKpfw III. Estaba destinado a combatir contra otros vehículos blindados de combate y servir junto al tanque de apoyo de infantería Panzer IV. Sin embargo, para enfrentarse al T-34 soviético, el Panzer III quedó obsoleto en su función y los alemanes necesitaban armas anticarro más poderosas. \n" +
                "Como el Panzer IV tenía una torreta de mayores dimensiones, y montaba el cañón largo KwK 40 de 75 mm, intercambió el papel con el Panzer III para ocuparse de las batallas de tanques. A partir de 1942, la última versión del Panzer III montó el cañón KwK 37 de 75 mm L/24, más adecuado para apoyar a la infantería. \n" +
                "La producción del Panzer III finalizó en 1943. No obstante, se utilizaron los chasis de Panzer III para producir cañones de asalto Sturmgeschütz III hasta el final de la guerra."));

        al.add(new ListaEntrada(R.drawable.pz4, "Panzer IV", "El Panzer IV fue un tanque medio desarrollado en la Alemania nazi a finales de los años 1930, ampliamente utilizado durante la Segunda Guerra Mundial. El nombre es una abreviación del nombre en alemán Panzerkampfwagen IV (vehículo de combate blindado modelo IV), abreviado como PzKpfw IV. \n" +
                "La designación del inventario de vehículos militares alemanes para este tanque era Sd.Kfz. 161."));

        al.add(new ListaEntrada(R.drawable.pz5, "Panzer V (Panther)", "Panther es el nombre común de un carro de combate alemán desplegado en la Segunda Guerra Mundial que estuvo en servicio desde mediados de 1943 hasta el final de la guerra en Europa en 1945. Hasta 1944, su designación oficial era Panzerkampfwagen V Panther(‘vehículo de combate blindado modelo V Pantera’) y su designación en el inventario de vehículos militares alemanes era Sd.Kfz. 171. El 27 de febrero de 1944, Hitler ordenó que el número romano V fuera eliminado de la designación."));

        al.add(new ListaEntrada(R.drawable.pz6, "Panzer VI (Tiger)", "Tiger I es el nombre por el que se suele conocer un tanque pesado alemán desarrollado en principio en 1937 y usado en la Segunda Guerra Mundial hasta la aparición del Tiger II. Su última designación oficial alemana fue Panzerkampfwagen Tiger Ausf. E (‘vehículo de combate blindado Tigre variante E’), a menudo abreviado como Tiger."));

        al.add(new ListaEntrada(R.drawable.pz7, "Panzer VI-B (Tiger II)", "Tiger II es el nombre por el que se suele conocer un tanque pesado alemán de la Segunda Guerra Mundial cuya última designación oficial alemana fue Panzerkampfwagen Tiger Ausf. B(‘vehículo de combate blindado Tigre variante B’), a menudo abreviado como Tiger B.\n" +
                "La designación del inventario de vehículos militares alemanes para este tanque era Sd.Kfz. 182. También era conocido en alemán por el nombre informal Königstiger (el nombre en alemán para el tigre de Bengala), muchas veces traducido literalmente por los soldados estadounidenses como King Tiger (‘rey tigre’) o Royal Tiger (‘tigre real’)." ));

        al.add(new ListaEntrada(R.drawable.pz8,"Panzer VIII (MAUS)", "El Panzerkampfwagen VIII \"Maus\" fue un carro de combate superpesado alemán desarrollado durante la Segunda Guerra Mundial. No se llegó a producir en masa y tan solo se fabricaron dos prototipos. Uno de ellos estaba sin torreta cuando los capturaron las tropas soviéticas y le montaron la torre del otro prototipo que se toparon destruido."));

        lv = (ListView) findViewById(R.id.xlv_listado);
        lv.setAdapter(new ListaAdapter(this, R.layout.activity_imagenes, al){
            public void onEntrada(Object o, View v) {
                if (o != null) {
                    TextView texto_superior_entrada = (TextView)
                            v.findViewById(R.id.textView_superior);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((ListaEntrada) o).get_textoEncima());
                    TextView texto_inferior_entrada = (TextView)
                            v.findViewById(R.id.textView_inferior);
                    if (texto_inferior_entrada != null)
                        texto_inferior_entrada.setText(((ListaEntrada) o).get_textoDebajo());
                    ImageView imagen_entrada = (ImageView) v.findViewById(R.id.imageView_imagen);
                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(((ListaEntrada) o).get_idImagen());
                }
            }
        });
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> av, View view, int i, long l) {
                ListaEntrada le = (ListaEntrada) av.getItemAtPosition(i);
                CharSequence cs = "Seleccionado: " + le.get_textoDebajo();
                Toast t = Toast.makeText(Imagenes.this, cs, Toast.LENGTH_SHORT);
                t.show();
            }
        });
    }
}
