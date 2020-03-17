package fr.clnguyen.corona_info;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Quiz extends AppCompatActivity {

    private static final int CODE = 1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView textViewHighscore;
    private EditText prenom;
    private Button buttonStart;

    private int highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textViewHighscore = findViewById(R.id.meilleur_score);
        prenom = findViewById(R.id.prenom_quiz);
        buttonStart = findViewById(R.id.bouton_commencer);

        //On affiche le meilleur score
        loadHighscore();

        //Bouton commencer
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Quiz.this, Quiz_Main.class);
                //Transmettre le nom du joueur a l'activité suivant
                String str = prenom.getText().toString();
                i.putExtra("text", str);
                startActivityForResult(i, CODE);
            }
        });

        //Initialisation variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Accueil selected
        bottomNavigationView.setSelectedItemId(R.id.Quiz);

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
                        startActivity(new Intent(getApplicationContext(), Carte.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.Quiz:
                        return true;
                }
                return false;
            }
        });

    }

    @Override
    //Pour récuperer le score du quiz
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODE) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(Quiz_Main.EXTRA_SCORE, 0);
                if (score > highscore) {
                    updateHighscore(score);
                }
            }
        }
    }

    //Afficher le meilleur score
    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("Meilleur Score: " + highscore);
    }

    //Mis a jour du meilleur score
    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        textViewHighscore.setText("Meilleur Score: " + highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }


}
