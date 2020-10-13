package com.example.sergi.mapasejer;

import android.graphics.Point;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    int     cont = 2;
    double  latitud, longitud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int[] cont = {2};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //Cambiar de mapa
        Button btnSatelite;
        btnSatelite = findViewById(R.id.BtnSatelite);
        btnSatelite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                cambiarmapa();
                posiciones_mapa();
            }
        });
        //Hacer zoom
        Button btnCentrar;
        btnCentrar = findViewById(R.id.BtnCentrar);
        btnCentrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                zoom();
                posiciones_mapa();
            }
        });

        Button btnMover;
        btnMover = findViewById(R.id.BtnMover);
        btnMover.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                movercamara();
                posiciones_mapa();
            }
        });

        Button btnAnimar;
        btnMover = findViewById(R.id.BtnAnimar);
        btnMover.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                animarcamara();
                posiciones_mapa();
            }
        });
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    private void posiciones_mapa(){
        CameraPosition camPos = mMap.getCameraPosition();
        LatLng coordenadas = camPos.target;
        latitud = coordenadas.latitude;
        longitud = coordenadas.longitude;
        Toast.makeText(this, "Lat: " + latitud + " | Long: " + longitud, Toast.LENGTH_SHORT).show();
    }

    private void animarcamara(){
        LatLng madrid = new LatLng(latitud, longitud);
        CameraPosition camPos = new CameraPosition.Builder()
                .target(madrid)   //Centramos el mapa en Madrid
                .zoom(19)         //Establecemos el zoom en 19
                .bearing(45)      //Establecemos la orientación con el noreste arriba
                .tilt(70)         //Bajamos el punto de vista de la cámara 70 grados
                .build();
        CameraUpdate camUpd3 =
                CameraUpdateFactory.newCameraPosition(camPos);
        mMap.animateCamera(camUpd3);
    }
    private void movercamara(){
        LatLng lugar = new LatLng(40, 40);
        CameraUpdate camUpd1 = CameraUpdateFactory.newLatLngZoom(new LatLng(40, 40), 10);
        mMap.addMarker(new MarkerOptions().position(lugar).title("Marker in Sevilla"));
        mMap.moveCamera(camUpd1);
    }

    private void zoom(){
        mMap.getUiSettings().setZoomControlsEnabled(true);
        LatLng lugar = new LatLng(37.40, -5.99);
        CameraUpdate camUpd1 = CameraUpdateFactory.newLatLngZoom(new LatLng(37.40, -5.99), 10);
        Toast.makeText(MapsActivity.this, "Lat: " + 37.40 + "\n" + "Lng: " + -5.99 + "\n" , Toast.LENGTH_SHORT).show();
        mMap.addMarker(new MarkerOptions().position(lugar).title("Marker in Sevilla"));
        mMap.moveCamera(camUpd1);
    }

    private void cambiarmapa(){
        if(cont % 2 == 0)
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        else
            mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        cont++;
    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        CameraUpdate camUpd1 = CameraUpdateFactory.newLatLngZoom(new LatLng(-34, 151), 10);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(camUpd1);
    }
}
