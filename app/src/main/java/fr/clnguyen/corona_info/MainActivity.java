package fr.clnguyen.corona_info;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialisation image
        ImageButton img_virus = findViewById(R.id.virus);
        ImageButton img_wash = findViewById(R.id.wash);
        ImageButton img_phone = findViewById(R.id.phone);
        ImageButton img_plane = findViewById(R.id.plane);

        //Bordure image -- A FAIRE

        //Listener image 1
        img_virus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, VirusInfo.class);
                startActivity(i);
            }
        });

        //Listener image 2
        img_wash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, WashInfo.class);
                startActivity(i);
            }
        });

        //Listener image 3
        img_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PhoneInfo.class);
                startActivity(i);
            }
        });

        //Listener image 4 -- A FAIRE

        //Initialisation variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Accueil selected
        bottomNavigationView.setSelectedItemId(R.id.Accueil);

        //Listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.Accueil:
                        return true;
                    case R.id.Carte:
                        startActivity(new Intent(getApplicationContext(), Carte.class));
                        overridePendingTransition(0,0);
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
}
