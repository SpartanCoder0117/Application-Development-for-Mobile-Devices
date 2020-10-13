package dyhm.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    Drawable drawID;
    String cade;
    int cont;
    CharSequence csDesc;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<ListaEntrada> entrada;
        entrada = obtenerDatos();
        cont = 0;
        listView = findViewById(R.id.listView);
        listView.setAdapter(new ListaAdapter(this, R.layout.list_item, entrada) {
            @Override
            void onEntrada(Object o, View v) {
                if (o != null) {
                    TextView textViewSuperior = v.findViewById(R.id.tv_superior);
                    if (textViewSuperior != null)
                        textViewSuperior.setText(((ListaEntrada) o).getA());
                    TextView textViewInferior = v.findViewById(R.id.tv_inferior);
                    if ( textViewInferior != null)
                        textViewInferior.setText(((ListaEntrada) o).getD());
                    ImageView imageView = v.findViewById(R.id.image_view);
                    if (imageView != null)
                        imageView.setImageResource(((ListaEntrada) o).getIdim());
                        cade = String.valueOf(((ListaEntrada) o).getID());
                        imageView.setContentDescription(cade);

                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView iv = (ImageView) view.findViewById(R.id.image_view);
                CharSequence source = iv.getContentDescription();


                drawID = iv.getDrawable();
                TextView v = (TextView) view.findViewById(R.id.tv_superior);
                ListaEntrada listaEntrada = (ListaEntrada) parent.getItemAtPosition(position);
                CharSequence cs = "Seleccionado: " + listaEntrada.getD();
                //Toast t = Toast.makeText(MainActivity.this, cs, Toast.LENGTH_LONG);


                Toast.makeText(getApplicationContext(), " " + listaEntrada.getToa(), Toast.LENGTH_LONG).show();
                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        csDesc = v.getContentDescription();
                        i = new Intent(MainActivity.this, ImagenCompleta.class);
                        i.putExtra("imagen", csDesc);
                        System.out.println("La descripcion: "+csDesc);
                        csDesc = "";
                        startActivity(i);
                        //Toast.makeText(MainActivity.this, " " + drawID, Toast.LENGTH_LONG).show();

                    }
                });
                //t.show();

            }
        });

    }

    public static List<ListaEntrada> obtenerDatos(){
        List<ListaEntrada> entradaList = new ArrayList<>();
        entradaList.add(new ListaEntrada(R.drawable.galileo, "DIBUJOS GALILEO GALILEI", "Como Galileo, los astrónomos siguen utilizando telescopios para observar el universo, ahora construidos con tecnologías "
                , 0,
                "avanzadas como el telescopio espacial \\\"Hubble\\\". También se han realizado observaciones por medio de naves espaciales. Hoy por la noche observa nuestra luna. ¿Qué edad le calculas? Los científicos calculan que en 2017 cumple casi ¡4500 millones de años! Ellos dicen que su nacimiento fue impresionante, ¡Imagínate! Ocurrió cuando una gran roca del tamaño del planeta Marte chocó contra la Tierra, expulsando al espacio rocas y materiales que, con el tiempo Se juntaron hasta formar la Luna.\n" +
                "\n" +
                "Tanto la luna como la Tierra giran alrededor del Sol, por eso algunas noches vemos sólo una parte de ella, y su forma aparentemente cambia.\n" +
                "\n" +
                "A veces, la luna nos parece muy cercana, aunque en realidad Está a unos 385 mil kilómetros, algo así como viajar en auto sin parar durante 5 meses. Por suerte, hoy existen naves espaciales que pueden llegar a ella en 3 días.\n" +
                "\n" +
                "En realidad la luna no es tan grande, en la tierra cabrían cuatro de ellas. Es dura y rocosa algunas de sus rocas son tan válidas que reflejan la luz del sol por eso parece que brilla."));

        entradaList.add(new ListaEntrada(R.drawable.luna, "LUNA", "Para obtener la imagen que ves aquí los científicos utilizaron tecnologías avanzadas. Reunieron 15 fotografías, como en un"
                , 1,
                "rompecabezas, para formar una más grande donde claramente pudiéramos distinguir los detalles, los colores de la superficie de la luna, más algunas estrellas en el fondo. Algo muy difícil de lograr en una fotografía del espacio.\n" +
                "\n" +
                "Te has preguntado cómo es realmente la luna? Durante largo tiempo, muchos se hicieron esta pregunta hasta que en 1969, avanzamos un poco gracias al astronauta Neil Armstrong. Fue la primera vez con la nave llegaba a la luna y que un ser humano pisaba su superficie. Ese fue un gran paso en la historia de la humanidad. Pregunta a tus abuelos o a los mayores de tu familia Cómo fueron las noticias de este día.\n" +
                "\n" +
                "Nuestra luna es un lugar maravilloso tiene montañas como la tierra también vayas volcanes e incluso un poco de agua hay sobre ella grandes agujeros llamados cráteres pero no hay en ella seres vivos.\n" +
                "\n" +
                "Porque hablamos de muchas lunas? Porque la mayoría de los planetas tienen sus propias lunas, algunos sólo una como la tierra; otros, como mercurio y Venus ninguna y otros planetas como Saturno y Júpiter más de 60 lunas cada uno.\n" +
                "\n" +
                "Hasta ahora conocemos 146 lunas en nuestro sistema solar Aunque todavía Hay muchas en espera de ser reconocidas por la unión astronómica internacional.\n" +
                "\n" +
                "Como puedes notar, el universo es más grande de lo que imaginamos y guarda muchos misterios que los astrónomos tratan de descifrar para que los conozcamos mejor."));

        entradaList.add(new ListaEntrada(R.drawable.deimos, "DEIMOS", "Cuanto tardas en tomar una fotografía? Con un celular, tal vez menos de un segundo. En el espacio es diferente pues para tomar la"
                ,2,
                "fotografía que aquí aparece, a la nave espacial de la NASA “Orbitador de reconocimiento de Marte” le tomó cinco horas y media.\n" +
                "\n" +
                "Te presentamos a “Deimos” o “Pánico” el hermano menor de la luna llamada fobos. Los tres nombres son tomados de la mitología griega, en la que ambos personajes son hijos de Marte. Por eso miedo es hermano de pánico.\n" +
                "\n" +
                "Deimos es la luna más pequeña del planeta Marte, pues cabría dos veces en la luna fobos. Puedes calcular la medida de Deimos: es casi la distancia que hay de Buenavista a la UNAM cruzando la avenida Insurgentes: 12 km.\n" +
                "\n" +
                "Deimos es rápida, tarda un día, 6 horas y 17.9 minutos en dar una vuelta alrededor de Marte. A diferencia de demos, nuestra luna tarda aproximadamente 28 días en girar alrededor de la Tierra."));

        entradaList.add(new ListaEntrada(R.drawable.fobos, "FOBOS", "La imagen que ves aquí es de “Fobos”, una de las dos lunas de Marte, el también llamado “Planeta rojo”."
                ,3,
                "Esta luna y su compañera fueron descubiertas en 1887 por el astrónomo Asaph Hall quién, inspirado en la mitología de la antigua Grecia, las nombró como dos de los cuatro hijos de los dioses Marte y Venus. Ya habíamos dicho que fobos significa miedo y deimos  quiere decir pánico.\n" +
                "\n" +
                "Si observas bien, fobos tiene forma de una papa llena de cráteres; el más grande se llama Sticney (como la primera esposa del astrónomo hall) y mide 9 km de diámetro, casi 100 canchas de fútbol como la del Estadio Azteca.\n" +
                "\n" +
                "Desde la tierra podemos ver el disco de la luna, sin embargo, si estuviéramos en Marte veríamos a fobos, por su pequeño tamaño, como el planeta Venus, con un brillo parecido al de una estrella más grande que las demás, mientras que deimos apenas sería visible a simple vista."));

        entradaList.add(new ListaEntrada(R.drawable.lo, "Io",
                "En esta imagen puedes observar el extraño color amarillo de lo, capturado por la Sonda espacial Galileo en 1999."
                ,4,
                "Esta nave giro alrededor del planeta Júpiter durante 8 años, y como parte de sus estudios voló más cerca de lo que cualquier otra revelando nos imágenes de sus gigantescos lagos de lava y de derrumbes de sus enormes montañas. lo lleva el nombre de una de las muchas doncellas de las que se enamoró el dios griego Zeus \n" +
                "\n" +
                "Io parece una enorme Pizza llena de queso y es la luna más extraña porque:\n" +
                "\n" +
                "Es la más pesada del sistema solar, pues su núcleo es de hierro fundido.\n" +
                "\n" +
                "Es la que tiene menor cantidad de agua. Está formada por minerales como el azufre y el silicato.\n" +
                "\n" +
                "Sufre constantes “lo - motos” pues se mueve de arriba a abajo como si fuera un ascensor llevando a las personas al piso más alto y luego al más bajo de un edificio de 30 pisos.\n" +
                "\n" +
                "Tiene más de 400 violentos volcanes en constante erupción, que expulsan lava tan caliente que hacen que lo brillo intensamente en la oscuridad.\n" +
                "\n" +
                "No tiene cráteres causados por impactos. Los astrónomos creen que es una luna joven (en comparación de las demás de nuestro sistema solar que tienen miles de millones de años).\n" +
                "\n" +
                "Todavía falta mucho por conocer de lo, por eso los científicos creen que seguirá sorprendiéndonos durante mucho tiempo."));

        entradaList.add(new ListaEntrada(R.drawable.lo2, "Io2",
                "Júpiter es uno de los planetas gigantes del sistema solar. En esta imagen, tomada por la nave espacial cassini, puedes verlo, "
                ,5,
                "al compararlo con El pequeño tamaño de lo una de sus varias lunas Ya la viste?. Comparada con Júpiter, lo se ve diminuta, pero no es tan pequeña: mide 3600 km de diámetro, casi como la luna de la Tierra.\n" +
                "\n" +
                "Júpiter tiene más de 60 lunas, pero por su tamaño Las cuatro lunas galileanas son las más conocidas. Éstas Fueron descubiertas por Galileo Galilei en 1610 y nombradas por el astrónomo Simón marius como las enamoradas del dios griego Zeus: lo, calisto, ganímedes y Europa. Estas lunas son como las grandes amores del planeta Júpiter.\n" +
                "\n" +
                "Muchas de las lunas de Júpiter tienen órbitas “altamente elípticas”, eso significa que giran alrededor de este planeta formando, en lugar de un círculo un elipse muy alargada . Otras más también giran en sentido contrario."));

        entradaList.add(new ListaEntrada(R.drawable.europa, "EUROPA",
                "Bienvenidos a Europa! Pero no hablamos del continente de la tierra, sino de una luna del planeta Júpiter."
                ,6,
                "Te invitamos a observarla y a conocerla. \n" +
                        "\n" +
                        "Europa es la más pequeña de las llamadas “lunas galileanas”. Al igual que sus compañeras, lleva el nombre de otra de las enamoradas del dios Zeus, la madre del rey minos, de Grecia.\n" +
                        "\n" +
                        "Europa es la luna más Lisa de nuestro sistema solar. Como puedes notar está cubierta por una capa de hielo, Te imaginas el frío que hace ahí? La temperatura de Europa es menos -163 grados centígrados, como 100 veces más baja que la temperatura en la ciudad de México en invierno\n" +
                        "\n" +
                        "Ya viste las manchas de Europa? Son grietas Bajo su capa de hielo, muy parecidas a las que existen en la tierra.\n" +
                        "\n" +
                        "De las grietas de Europa, salen expulsados chorros de agua caliente hacia el espacio, como hacen los geiseres en la tierra, algo que los científicos creen que sucede porque en el fondo existe un profundo océano que podría tener condiciones para la vida."));

        entradaList.add(new ListaEntrada(R.drawable.ariel, "ARIEL",
                "Cómo se formaron los valles de Ariel? Fue la pregunta que se hicieron los científicos cuando la nave espacial Voyager 2 "
                ,7,
                "obtuvo la imagen que ves. \n " +
                        "\n" +
                        "Pero Quién es Ariel?.\n" +
                        "\n" +
                        "Después de Miranda, Ariel es la segunda luna más cercana al planeta Urano.\n" +
                        "\n" +
                        "Fue descubierta en 1851 por el astrónomo William Lassell, quien la nombró igual que los personajes de dos obras de la literatura inglesa: es una es la lideresa El rizo robado, de Alexander Pope, y otra es el hada en La tempestad de William Shakespeare.\n" +
                        "\n" +
                        "Igual que las 27 lunas de Urano, Ariel está formada por hielo y roca, pero su paisaje es diferente, pues además de cráteres, cañones y picos rocosos, tiene valles una característica interesante para los científicos.\n" +
                        "\n" +
                        "Así como nuestra luna influye en las mareas de la tierra, los científicos creen que en el pasado, Ariel también influyó sobre Urano, provocando un extremo calentamiento y sismos que hundieron su superficie y formaron sus misteriosos Valles"));

        entradaList.add(new ListaEntrada(R.drawable.estrellas, "LAS ESTRELLAS",
                "Las estrellas que observamos en el cielo tienen brillos aparentes distintos, dependiendo de su distancia a nosotros y de "
                ,8,
                "su luminosidad intrínseca, tal como se aprecieria cuando observamos una lampara a diferentes distancias. De manera general las estrellas mas luminosas son mas masivas, ya que su propio peso les ayuda a quemar su combustible nuclear mas rapido. Por esta razon dichas estrellas evolucionan mas rapido que las estrellas menos masivas como nuestro sol\n" +
                "\n" +
                        "está diferencia en masa \n" +
                        "tiene consecuencias muy importantes en las etapas finales de la evolución de las estrellas una vez que una estrella con 8 \n" +
                        "veces la masa de nuestro sol ha consumido todo su combustible nuclear explotara de manera espectacular originando lo que se \n" +
                        " conoce como una supernova Después de varios años es posible observar los restos de la explosión como en el lado inferior \n" +
                        "derecho de la imagen principal esta imagen corresponde a la remanente de supernova de en la constelación de casiopea \n" +
                        "astrónomos de la UNAM han detectado en la región central de este remanente Fenómenos físicos exóticos como la superfluidez.\n" + "En cambio estrellas con masas similares a la de nuestro sol o menores tienen una vida Mucho más larga y cuando terminan de \n" +
                        "consumir su combustible nuclear arrojan una buena parte de su envolvente gaseosa originando a las nebulosas planetarias como\n" +
                        " en el lado izquierdo de la imagen principal, donde aparece la llamada nebulosa del esquimal existe una larga tradición en \n" +
                        "la astronomía mexicana en el estudio de las propiedades físicas de estos objetos."));

        entradaList.add(new ListaEntrada(R.drawable.energeticos, "EVENTOS ENERGETICOS",
                "En Nuestro cielo de verano en el hemisferio norte y en lugares suficientemente oscuros se puede reconocer una banda de luz difusa "
                ,9,
                "que atraviesa el cielo. Algo similar se puede observar en el cielo del hemisferio sur como se aprecia en la \n" +
                "\n" +
                        "imagen al final de esta\n" + "Sí pudiésemos conjuntar ambas vistas obtendríamos la imagen principal Aquí presentada esta imagen tiene aspecto de una \n" +
                        "galaxia de canto y es la evidencia de que vivimos dentro de una galaxia de disco llamada la vía láctea la imagen está \n" +
                        "compuesta por múltiples observaciones En el infrarrojo utilizando telescopios en ambos hemisferios como parte del estudio\n" +
                        "del cielo llamado 2MASS. La parte central brillante con forma de cacahuate es denominada el bulbo barra de nuestra galaxia \n" +
                        "Y contiene a algunas de las estrellas más viejas que conocemos las bandas brillantes que rodean el bulbo se representan a \n" +
                        "las estrellas del disco de nuestra galaxia las zonas oscuras en esta imagen son originadas por el bloqueo de la luz de las \n" +
                        "estrellas del disco galáctico debido al polvo cósmico que las rodea En la parte inferior derecha de la imagen principal así\n" +
                        "como en la imagen del cielo del hemisferio sur en esta cédula se aprecian dos pequeñas concentraciones de estrellas conocidas \n" +
                        "como las nubes de Magallanes pequeñas galaxias satélites de la vía láctea entre otras más determinar Cuántas Y qué tipo de \n" +
                        "pequeñas galaxias se mueven alrededor de la nuestra y de otras galaxias puede dar pistas sobre el proceso de la formaciónde \n" +
                        "la vía láctea y del universo mismo.\n" + "La luz infrarroja puede penetrar las regiones oscurecidas en la imagen principal y permiten obtener información de la \n" +
                        "profundidad del disco con ayuda del observatorio espacial spitzer Se elaboró una de las más recientes imágenes panorámicas\n" +
                        " de nuestra galaxia a luz infrarroja utilizando esta información y geometría fue posible construir una imagen de la misma \n" +
                        "casi vista de frente produciendo la representación artística en la parte inferior de la imagen principal esto confirmó la \n" +
                        "presencia de brazos espirales y un Bulbo elongado otros estudios que analizaron el movimiento de las estrellas en la región\n" +
                        " central de nuestra galaxia han podido comprobar la presencia de un agujero negro supermasivo central más recientemente se \n" +
                        "ha detectado en radiación de alta energía rayos Gamma la presencia de dos burbujas emanando a ambos lados del centro de \n" +
                        "nuestra galaxia dichas estructuras podrían aportar información adicional sobre la presencia de este agujero negro en el \n" +
                        "núcleo de la vía láctea Cómo se ha detectado en otras galaxias nuestro sol es una estrella localizada en el disco a unos \n" +
                        "30 mil años luz alejada del centro Cómo se señala en la parte inferior de la imagen principal la Esfera de influencia de \n" +
                        "esta radiación es prácticamente nula en la posición de nuestro sistema solar."));


        return entradaList;
    }
}
