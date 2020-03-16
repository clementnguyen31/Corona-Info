package fr.clnguyen.corona_info;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CasInfecteInfo extends AppCompatActivity {

    private ListView maliste;
    private String[] valeurs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cas_info);

        this.maliste = (ListView) findViewById(R.id.liste_cas);

        this.valeurs = getResources().getStringArray(R.array.listeInfectes);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(CasInfecteInfo.this,
                android.R.layout.simple_list_item_1, this.valeurs);

        this.maliste.setAdapter(adapter);
    }
}