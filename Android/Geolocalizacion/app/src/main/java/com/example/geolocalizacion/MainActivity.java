package com.example.geolocalizacion;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    LocationManager locManager;
    List<String> listaProviders;
    LocationListener locListener;
    TextView lblEstado = null, lblLatitud = null, lblLongitud = null, lblPrecision = null;
    Button btnActivar = null, btnDesactivar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblEstado = findViewById(R.id.provider);
        lblLatitud = findViewById(R.id.latitud);
        lblLongitud = findViewById(R.id.longitud);
        lblPrecision = findViewById(R.id.precision);
        btnActivar = findViewById(R.id.activar);
        btnDesactivar = findViewById(R.id.desactivar);

        btnActivar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Activado",Toast.LENGTH_LONG).show();
                comenzarLocalizacion();
            }
        });

        btnDesactivar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Desactivado",Toast.LENGTH_SHORT).show();
                locManager.removeUpdates(locListener);
            }
        });

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        locManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        listaProviders = locManager.getAllProviders();
        LocationProvider provider = locManager.getProvider(listaProviders.get(0));
        int precision = provider.getAccuracy();
        boolean obtieneAltitud = provider.supportsAltitude();
        int consumoRecursos = provider.getPowerRequirement();

        Criteria req = new Criteria();
        req.setAccuracy(Criteria.ACCURACY_FINE);
        req.setAltitudeRequired(true);

        String mejorProviderCrit = locManager.getBestProvider(req, false);//Mejor proveedor por criterio
        List<String> listaProvidersCrit = locManager.getProviders(req, false); //Lista por criterio

        if (!locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) { //Si el GPS no esta´ habilitado
            Toast.makeText(getApplicationContext(),"Gps Inhabilitado",Toast.LENGTH_SHORT).show();
        }
    }

    private void mostrarPosicion(Location loc) {
        if (loc != null) {
            lblLatitud.setText("Latitud: " + String.valueOf(loc.getLatitude()));
            lblLongitud.setText("Longitud: " +
                    String.valueOf(loc.getLongitude()));
            lblPrecision.setText("Precision: " +
                    String.valueOf(loc.getAccuracy()));
        } else {
            lblLatitud.setText("Latitud: (sin_datos)");
            lblLongitud.setText("Longitud: (sin_datos)");
            lblPrecision.setText("Precision: (sin_datos)");
        }
    }

    private void comenzarLocalizacion() {
        locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location loc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        mostrarPosicion(loc); //Obtenemos la u´ltima posicio´n conocida y mostrarla
        locListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                mostrarPosicion(location);
            }

            public void onProviderDisabled(String provider) {
                lblEstado.setText("Proveedor en OFF");
            }

            public void onProviderEnabled(String provider) {
                lblEstado.setText("Proveedor en ON");
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
                System.out.println("on status changed");
                lblEstado.setText("Provider Status: " + status);
            }
        };
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30000, 0, locListener);
    }

    private void actualizarPosicion() {
        locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        muestraPosicion(location);
        locListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                muestraPosicion(location);
            }

            public void onProviderDisabled(String provider) {
                lblEstado.setText("Provider OFF");
            }

            public void onProviderEnabled(String provider) {
                lblEstado.setText("Provider ON");
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
                Log.i("LocAndroid", "Provider Status: " + status);
                lblEstado.setText("Provider Status: " + status);
            }
        };
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 15000, 0, locListener);
    }

    private void muestraPosicion(Location loc) {
        if(loc != null) {
            lblLatitud.setText("Latitud: " + String.valueOf(loc.getLatitude()));
            lblLongitud.setText("Longitud: " + String.valueOf(loc.getLongitude()));
            lblPrecision.setText("Precision: " + String.valueOf(loc.getAccuracy()));
            Log.i("LocAndroid", String.valueOf(loc.getLatitude() + " - " +
                    String.valueOf(loc.getLongitude())));
        } else {
            lblLatitud.setText("Latitud: (sin_datos)");
            lblLongitud.setText("Longitud: (sin_datos)");
            lblPrecision.setText("Precision: (sin_datos)");
        }
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}