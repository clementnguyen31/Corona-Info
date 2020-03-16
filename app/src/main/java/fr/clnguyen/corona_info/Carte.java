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
                switch (menuItem.getItemId()) {
                    case R.id.Accueil:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.Carte:
                        return true;
                    case R.id.Quiz:
                        startActivity(new Intent(getApplicationContext(), Quiz.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //On met tous les points
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
        LatLng autriche = new LatLng(47.932889, 14.926167);
        mapAPI.addMarker(new MarkerOptions().position(autriche));

        LatLng malaisie = new LatLng(4.434679, 102.438696);
        mapAPI.addMarker(new MarkerOptions().position(malaisie));

        LatLng bahrein = new LatLng(25.970315, 50.531229);
        mapAPI.addMarker(new MarkerOptions().position(bahrein));

        LatLng australie = new LatLng(-24.147410, 128.274050);
        mapAPI.addMarker(new MarkerOptions().position(australie));

        LatLng grece = new LatLng(39.320018, 21.748711);
        mapAPI.addMarker(new MarkerOptions().position(grece));

        LatLng koweit = new LatLng(29.463670, 47.532810);
        mapAPI.addMarker(new MarkerOptions().position(koweit));

        LatLng canada = new LatLng(61.255033, -112.016708);
        mapAPI.addMarker(new MarkerOptions().position(canada));

        LatLng irak = new LatLng(33.323952, 43.725997);
        mapAPI.addMarker(new MarkerOptions().position(irak));

        LatLng egypte = new LatLng(26.893750, 31.062252);
        mapAPI.addMarker(new MarkerOptions().position(egypte));

        LatLng iceland = new LatLng(64.863349, -18.212256);
        mapAPI.addMarker(new MarkerOptions().position(iceland));

        LatLng thailande = new LatLng(15.724607, 101.408730);
        mapAPI.addMarker(new MarkerOptions().position(thailande));

        LatLng emiratsArabesUnis = new LatLng(23.788145, 54.334222);
        mapAPI.addMarker(new MarkerOptions().position(emiratsArabesUnis));

        LatLng inde = new LatLng(20.917660, 79.034230);
        mapAPI.addMarker(new MarkerOptions().position(inde));

        LatLng israel = new LatLng(31.123845, 34.824931);
        mapAPI.addMarker(new MarkerOptions().position(israel));

        LatLng saintMarin = new LatLng(43.935687, 12.460435);
        mapAPI.addMarker(new MarkerOptions().position(saintMarin));

        LatLng danemark = new LatLng(56.105787, 9.322238);
        mapAPI.addMarker(new MarkerOptions().position(danemark));

        LatLng republiqueTcheque = new LatLng(49.845921, 15.088918);
        mapAPI.addMarker(new MarkerOptions().position(republiqueTcheque));

        LatLng liban = new LatLng(33.904962, 35.835807);
        mapAPI.addMarker(new MarkerOptions().position(liban));

        LatLng finlande = new LatLng(62.974618, 26.494274);
        mapAPI.addMarker(new MarkerOptions().position(finlande));

        LatLng portugal = new LatLng(39.496545, -8.193771);
        mapAPI.addMarker(new MarkerOptions().position(portugal));

        LatLng vietnam = new LatLng(11.256353, 107.971849);
        mapAPI.addMarker(new MarkerOptions().position(vietnam));

        LatLng bresil = new LatLng(-10.782174, -51.677319);
        mapAPI.addMarker(new MarkerOptions().position(bresil));

        LatLng irelande = new LatLng(53.066337, -7.867412);
        mapAPI.addMarker(new MarkerOptions().position(irelande));

        LatLng algerie = new LatLng(28.998064, 1.963010);
        mapAPI.addMarker(new MarkerOptions().position(algerie));

        LatLng oman = new LatLng(20.956338, 56.907255);
        mapAPI.addMarker(new MarkerOptions().position(oman));

        LatLng slovenie = new LatLng(46.052349, 14.690426);
        mapAPI.addMarker(new MarkerOptions().position(slovenie));

        LatLng equateur = new LatLng(-1.750600, -78.617346);
        mapAPI.addMarker(new MarkerOptions().position(equateur));

        LatLng roumanie = new LatLng(46.003961, 24.732700);
        mapAPI.addMarker(new MarkerOptions().position(roumanie));

        LatLng arabieSaoudite = new LatLng(24.855092, 44.484311);
        mapAPI.addMarker(new MarkerOptions().position(arabieSaoudite));

        LatLng georgie = new LatLng(41.981210, 43.729221);
        mapAPI.addMarker(new MarkerOptions().position(georgie));

        LatLng argentine = new LatLng(-37.055010, -64.676160);
        mapAPI.addMarker(new MarkerOptions().position(argentine));

        LatLng qatar = new LatLng(25.200775, 51.184093);
        mapAPI.addMarker(new MarkerOptions().position(qatar));

        LatLng croatie = new LatLng(45.126677, 15.273049);
        mapAPI.addMarker(new MarkerOptions().position(croatie));

        LatLng pologne = new LatLng(52.273591, 19.350768);
        mapAPI.addMarker(new MarkerOptions().position(pologne));

        LatLng chili = new LatLng(-33.651914, -71.278083);
        mapAPI.addMarker(new MarkerOptions().position(chili));

        LatLng estonie = new LatLng(58.794968, 25.623403);
        mapAPI.addMarker(new MarkerOptions().position(estonie));

        LatLng philippines = new LatLng(7.555144, 124.981140);
        mapAPI.addMarker(new MarkerOptions().position(philippines));

        LatLng azerbaïdjan = new LatLng(40.547717, 47.939187);
        mapAPI.addMarker(new MarkerOptions().position(azerbaïdjan));

        LatLng costaRica = new LatLng(9.956780, -83.889256);
        mapAPI.addMarker(new MarkerOptions().position(costaRica));

        LatLng hongrie = new LatLng(47.131795, 19.085792);
        mapAPI.addMarker(new MarkerOptions().position(hongrie));

        LatLng mexique = new LatLng(24.698644, -102.771776);
        mapAPI.addMarker(new MarkerOptions().position(mexique));

        LatLng russie = new LatLng(64.481601, 93.728103);
        mapAPI.addMarker(new MarkerOptions().position(russie));

        LatLng bielorussie = new LatLng(53.502589, 28.018884);
        mapAPI.addMarker(new MarkerOptions().position(bielorussie));

        LatLng indonesie = new LatLng(-2.759211, 103.489594);
        mapAPI.addMarker(new MarkerOptions().position(indonesie));

        LatLng pakistan = new LatLng(29.094172, 68.426804);
        mapAPI.addMarker(new MarkerOptions().position(pakistan));

        LatLng perou = new LatLng(-8.783226, -75.804546);
        mapAPI.addMarker(new MarkerOptions().position(perou));

        LatLng guyaneFrancaise = new LatLng(3.864556, -53.110925);
        mapAPI.addMarker(new MarkerOptions().position(guyaneFrancaise));

        LatLng nouvelleZelande = new LatLng(-43.891381, 170.712738);
        mapAPI.addMarker(new MarkerOptions().position(nouvelleZelande));

        LatLng slovaquie = new LatLng(48.802898, 19.686984);
        mapAPI.addMarker(new MarkerOptions().position(indonesie));

        LatLng afghanistan = new LatLng(33.395017, 65.671825);
        mapAPI.addMarker(new MarkerOptions().position(afghanistan));

        LatLng bulgarie = new LatLng(42.663105, 25.211735);
        mapAPI.addMarker(new MarkerOptions().position(bulgarie));

        LatLng maldives = new LatLng(-0.612669, 73.094598);
        mapAPI.addMarker(new MarkerOptions().position(maldives));

        LatLng senegal = new LatLng(14.861537, -14.728948);
        mapAPI.addMarker(new MarkerOptions().position(senegal));

        LatLng lettonie = new LatLng(56.932091, 25.180230);
        mapAPI.addMarker(new MarkerOptions().position(lettonie));

        LatLng malte = new LatLng(35.892321, 14.429152);
        mapAPI.addMarker(new MarkerOptions().position(malte));

        LatLng macedoineduNord = new LatLng(41.421542, 21.711272);
        mapAPI.addMarker(new MarkerOptions().position(macedoineduNord));

        LatLng afriqueDuSud = new LatLng(-29.792560, 24.658320);
        mapAPI.addMarker(new MarkerOptions().position(afriqueDuSud));

        LatLng ilesFeroe = new LatLng(62.162818, -7.031501);
        mapAPI.addMarker(new MarkerOptions().position(ilesFeroe));

        LatLng bangladesh = new LatLng(24.254103, 89.967824);
        mapAPI.addMarker(new MarkerOptions().position(bangladesh));

        LatLng bosnieherzegovine = new LatLng(44.427230, 17.694508);
        mapAPI.addMarker(new MarkerOptions().position(bosnieherzegovine));

        LatLng cambodge = new LatLng(13.058465, 104.427916);
        mapAPI.addMarker(new MarkerOptions().position(cambodge));

        LatLng cameroun = new LatLng(5.124360, 12.523920);
        mapAPI.addMarker(new MarkerOptions().position(cameroun));

        LatLng luxembourg = new LatLng(49.774942, 6.138701);
        mapAPI.addMarker(new MarkerOptions().position(luxembourg));

        LatLng martinique = new LatLng(14.689722, -61.028926);
        mapAPI.addMarker(new MarkerOptions().position(martinique));

        LatLng maroc = new LatLng(32.503549, -5.711325);
        mapAPI.addMarker(new MarkerOptions().position(maroc));

        LatLng tunisie = new LatLng(34.888898, 9.726405);
        mapAPI.addMarker(new MarkerOptions().position(tunisie));


        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(france));


    }
}
