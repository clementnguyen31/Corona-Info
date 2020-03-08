package fr.clnguyen.corona_info;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Carte extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap mapAPI;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapAPI);
        mapFragment.getMapAsync(this);

        //Initialisation variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Accueil selected
        bottomNavigationView.setSelectedItemId(R.id.Carte);

        //Listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.Accueil:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Carte:
                        return true;
                    case R.id.Quiz:
                        startActivity(new Intent(getApplicationContext(), Quiz.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapAPI = googleMap;
        LatLng chine = new LatLng(30.580456, 114.326469);
        LatLng france = new LatLng(50.293930, 2.148420);
        LatLng coreeSud = new LatLng(37.538343, 126.998469);
        LatLng italie = new LatLng(41.759183, 12.541290);
        LatLng iran = new LatLng(31.433087, 52.718303);
        LatLng allemagne = new LatLng(52.275109, 13.395784);
        LatLng espagne = new LatLng(40.310513, -3.527173);
        LatLng japon = new LatLng(35.675135, 139.734337);
        LatLng us = new LatLng(39.029208, -101.657864);
        LatLng suisse = new LatLng(47.324065, 8.394109);
        LatLng uk = new LatLng(51.478111, -0.210117);
        LatLng pays_bas = new LatLng(52.345528, 4.900484);
        LatLng belgique = new LatLng(50.802204, 4.311954);
        LatLng suede = new LatLng(62.634009, 16.583049);
        LatLng norvege = new LatLng(61.589698, 9.218238);
        LatLng singapour = new LatLng(1.348319, 103.866042);
        LatLng hong_kong = new LatLng(22.314883, 114.168804);
        mapAPI.addMarker(new MarkerOptions().position(chine));
        mapAPI.addMarker(new MarkerOptions().position(france));
        mapAPI.addMarker(new MarkerOptions().position(coreeSud));
        mapAPI.addMarker(new MarkerOptions().position(italie));
        mapAPI.addMarker(new MarkerOptions().position(iran));
        mapAPI.addMarker(new MarkerOptions().position(allemagne));
        mapAPI.addMarker(new MarkerOptions().position(espagne));
        mapAPI.addMarker(new MarkerOptions().position(japon));
        mapAPI.addMarker(new MarkerOptions().position(us));
        mapAPI.addMarker(new MarkerOptions().position(suisse));
        mapAPI.addMarker(new MarkerOptions().position(uk));
        mapAPI.addMarker(new MarkerOptions().position(pays_bas));
        mapAPI.addMarker(new MarkerOptions().position(belgique));
        mapAPI.addMarker(new MarkerOptions().position(suede));
        mapAPI.addMarker(new MarkerOptions().position(norvege));
        mapAPI.addMarker(new MarkerOptions().position(singapour));
        mapAPI.addMarker(new MarkerOptions().position(hong_kong));


        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(france));


    }
}
