package fr.clnguyen.corona_info;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Quiz_DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "Quiz.db";

    public final String SQL_CREATE = "CREATE TABLE Quiz (id INTEGER PRIMARY KEY, question TEXT, option1 TEXT, option2 TEXT, option3 TEXT, correctRep INTEGER);";
    public final String SQL_DELETE = "DROP TABLE IF EXISTS Quiz;";

    private SQLiteDatabase db;

    public Quiz_DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        db.execSQL(SQL_CREATE);
        remplirQuestionTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE);
        onCreate(db);
    }

    private void remplirQuestionTable() {
        Question q1 = new Question("Quel n’est pas le symptôme du Coronavirus COVID-19 ?", "Fièvre", "Difficultés respiratoires", "Des vomissements", 3);
        addQuestion(q1);
        Question q2 = new Question("Comment se transmet le virus ?", "Animaux", "Humain", "Les deux", 3);
        addQuestion(q2);
        Question q3 = new Question("Les aliments cuits d’origine animale présentent-ils un risque d’infection ?", "Oui le virus est toujours présent", "Non le virus est détruit", "Tout dépend de la cuisson", 2);
        addQuestion(q3);
        Question q4 = new Question("Peut-on attraper le virus par de l’eau contaminée ?", "Oui", "Non", "On ne sait pas encore", 2);
        addQuestion(q4);
        Question q5 = new Question("Quelles sont les personnes les plus à risque ?", "Les trentenaires", "Les adolescents", "Les personnes fragiles", 3);
        addQuestion(q5);
        Question q6 = new Question("Dans quelle tranche d’âge le taux de mortalité est le plus élevé ?", "-39", "40-80", "80+", 3);
        addQuestion(q6);
        Question q7 = new Question("Quel est le délai d’incubation moyen de la maladie ?", "7 jours", "14 jours", "21 jours", 2);
        addQuestion(q7);
        Question q8 = new Question("Qui est-il préférable d’appeler en cas d’infection supposée ?", "Son médecin", "Le SAMU", "La police", 2);
        addQuestion(q8);
        Question q9 = new Question("Par quel intermédiaire le virus se diffuse le plus rapidement ?", "Le contact interhumain", "Un objet contaminé", "Les postillons", 1);
        addQuestion(q9);
        Question q10 = new Question("Combien de personnes un malade peut-il contaminer en moyenne ?", "1 personne", "2 personnes", "3 personnes", 3);
        addQuestion(q10);
        Question q11 = new Question("Qui doit porter un masque en priorité ?", "Les malades", "Les non-malades", "Le personnel de santé", 1);
        addQuestion(q11);
        Question q12 = new Question("Comment se protéger du virus ?", "Ne pas se laver les mains régulièrement", "Tousser dans son coude", "Privilégier les contacts étroits", 2);
        addQuestion(q12);
        Question q13 = new Question("Quel est le foyer du COVID-19 ?", "Italie", "Chine", "France", 2);
        addQuestion(q13);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put("question", question.getQuestion());
        cv.put("option1", question.getOption1());
        cv.put("option2", question.getOption2());
        cv.put("option3", question.getOption3());
        cv.put("correctRep", question.getcorrectRep());
        db.insert("Quiz", null, cv);
    }

    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Quiz", null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex("question")));
                question.setOption1(c.getString(c.getColumnIndex("option1")));
                question.setOption2(c.getString(c.getColumnIndex("option2")));
                question.setOption3(c.getString(c.getColumnIndex("option3")));
                question.setcorrectRep(c.getInt(c.getColumnIndex("correctRep")));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

}
