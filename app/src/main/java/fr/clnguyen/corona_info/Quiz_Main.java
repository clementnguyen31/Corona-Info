package fr.clnguyen.corona_info;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;

public class Quiz_Main extends AppCompatActivity {

    public static final String EXTRA_SCORE = "cScore";

    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCompteur;
    private TextView textViewTemps;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private Button buttonSuivant;

    private ColorStateList textColorDefaultRb;

    private List<Question> questionList;
    private int questionCompteur;
    private int questionNbTotal;
    private Question questionCourante;

    private int score;
    private boolean repondu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);

        Intent intent = getIntent();
        if (intent != null){
            String str = "";
            if (intent.hasExtra("text")){
                str = intent.getStringExtra("text");
            }
            TextView textView = (TextView) findViewById(R.id.prenom_quiz_main);
            textView.setText(""+str);
        }



        textViewQuestion = findViewById(R.id.text_question);
        textViewScore = findViewById(R.id.text_score);
        textViewQuestionCompteur = findViewById(R.id.text_question_compteur);
        textViewTemps = findViewById(R.id.text_temps);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        buttonSuivant = findViewById(R.id.button_suivant);

        textColorDefaultRb = rb1.getTextColors();

        Quiz_DbHelper dbHelper = new Quiz_DbHelper(this);
        questionList = dbHelper.getAllQuestions();
        questionNbTotal = questionList.size();
        Collections.shuffle(questionList);

        afficherProchaineQuestion();

        buttonSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!repondu){
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked()) {
                        verifierReponse();
                    } else {
                        Toast.makeText(Quiz_Main.this, "Selectionner une réponse", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    afficherProchaineQuestion();
                }
            }
        });
    }

    private void verifierReponse() {
        repondu = true;

        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int correctRep = rbGroup.indexOfChild(rbSelected) + 1;

        if (correctRep == questionCourante.getcorrectRep()) {
            score++;
            textViewScore.setText("Score: " + score);
        }

        afficherSolution();
    }

    private void afficherSolution() {
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);

        switch (questionCourante.getcorrectRep()) {
            case 1:
                rb1.setTextColor(Color.GREEN);
                textViewQuestion.setText("La réponse 1 est correct");
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                textViewQuestion.setText("La réponse 2 est correct");
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                textViewQuestion.setText("La réponse 3 est correct");
                break;
        }

        if (questionCompteur < questionNbTotal) {
            buttonSuivant.setText("Suivant");
        } else {
            buttonSuivant.setText("Finir");
        }
    }

    private void afficherProchaineQuestion() {
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();

        if (questionCompteur < questionNbTotal) {
            questionCourante = questionList.get(questionCompteur);

            textViewQuestion.setText(questionCourante.getQuestion());
            rb1.setText(questionCourante.getOption1());
            rb2.setText(questionCourante.getOption2());
            rb3.setText(questionCourante.getOption3());

            questionCompteur++;
            textViewQuestionCompteur.setText("Question: " + questionCompteur + "/" + questionNbTotal);
            repondu = false;
            buttonSuivant.setText("Confirmer");
        } else {
            //Met le score dans le menu de départ du Quiz
            Intent result = new Intent();
            result.putExtra(EXTRA_SCORE, score);
            setResult(RESULT_OK, result);
            finish();
        }
    }
}
