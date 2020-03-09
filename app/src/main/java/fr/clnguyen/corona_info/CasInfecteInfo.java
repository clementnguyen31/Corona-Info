package fr.clnguyen.corona_info;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CasInfecteInfo extends AppCompatActivity {

    private ListView maliste;
    private String[] pays = new String[]{
            "Chine : 80 904 cas",
            "République de Corée : 7 382 cas",
            "Italie : 7 375 cas",
            "Iran (République islamique d') : 6 566 cas",
            "France : 1 116 cas",
            "Allemagne : 902 cas",
            "Transport international (Diamond Princess) : 696 cas",
            "Espagne : 589 cas",
            "Japon : 488 cas",
            "Suisse : 332 cas",
            "Royaume-Uni : 277 cas",
            "Pays-Bas : 265 cas",
            "États-Unis d'Amérique : 213 cas",
            "Suède : 203 cas",
            "Belgique : 200 cas",
            "Norvège : 169 cas",
            "Singapour : 150 cas",
            "Autriche : 102 cas",
            "Malaisie : 93 cas",
            "Bahreïn : 79 cas",
            "Australie : 77 cas",
            "Grèce : 73 cas",
            "Koweït : 64 cas",
            "Canada : 60 cas",
            "Irak : 60 cas",
            "Egypte : 55 cas",
            "Islande : 55 cas",
            "Thaïlande : 50 cas",
            "Émirats arabes unis : 45 cas",
            "Inde : 39 cas",
            "Israël : 39 cas",
            "Saint-Marin : 37 cas",
            "Danemark : 36 cas",
            "République tchèque : 32 cas",
            "Liban : 32 cas",
            "Finlande : 30 cas",
            "Portugal : 30 cas",
            "Viet Nam : 30 cas",
            "Brésil : 25 cas",
            "Irlande : 21 cas",
            "Territoire palestinien occupé : 19 cas",
            "Algérie : 17 cas",
            "Oman : 16 cas",
            "Slovénie : 16 cas",
            "Équateur : 15 cas",
            "Roumanie : 15 cas",
            "Arabie Saoudite : 15 cas",
            "Géorgie : 13 cas",
            "Argentine : 12 cas",
            "Qatar : 12 cas",
            "Croatie : 11 cas",
            "Pologne : 11 cas",
            "Chili : 10 cas",
            "Estonie : 10 cas",
            "Philippines : 10 cas",
            "Azerbaïdjan : 9 cas",
            "Costa Rica : 9 cas",
            "Hongrie : 8 cas",
            "Mexique : 7 cas",
            "Fédération de Russie : 7 cas",
            "Bélarus : 6 cas",
            "Indonésie : 6 cas",
            "Pakistan : 6 cas",
            "Pérou : 6 cas",
            "Guyane française : 5 cas",
            "Nouvelle-Zélande : 5 cas",
            "Slovaquie : 5 cas",
            "Afghanistan : 4 cas",
            "Bulgarie : 4 cas",
            "Maldives : 4 cas",
            "Sénégal : 4 cas",
            "Lettonie : 3 cas",
            "Malte : 3 cas",
            "Macédoine du Nord : 3 cas",
            "Afrique du Sud : 3 cas",
            "Îles Féroé : 3 cas",
            "Bangladesh : 3 cas",
            "Bosnie-Herzégovine : 2 cas",
            "Cambodge : 2 cas",
            "Cameroun : 2 cas",
            "Luxembourg : 2 cas",
            "Martinique : 2 cas",
            "Maroc : 2 cas",
            "Saint Martin : 2 cas",
            "Tunisie : 2 cas",
            "Albanie : 2 cas",
            "Andorre : 1 cas",
            "Arménie : 1 cas",
            "Bhoutan : 1 cas",
            "Colombie : 1 cas",
            "République dominicaine : 1 cas",
            "Gibraltar : 1 cas",
            "Saint-Siège : 1 cas",
            "Jordanie : 1 cas",
            "Liechtenstein : 1 cas",
            "Lituanie : 1 cas",
            "Monaco : 1 cas",
            "Népal : 1 cas",
            "Nigeria : 1 cas",
            "République de Moldavie : 1 cas",
            "Saint-Barthélemy : 1 cas",
            "Serbie : 1 cas",
            "Sri Lanka : 1 cas",
            "Togo : 1 cas",
            "Ukraine : 1 cas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cas_info);

        this.maliste = (ListView) findViewById(R.id.liste_cas);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(CasInfecteInfo.this,
                android.R.layout.simple_list_item_1, this.pays);
        this.maliste.setAdapter(adapter);
    }
}