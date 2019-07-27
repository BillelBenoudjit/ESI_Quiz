package sample.noyeau ;

import java.util.ArrayList;
import java.util.Date;

public class Quiz {
    public String nom;
    protected Date dateouverture;
    protected Date dateexpiration;
    protected ArrayList<Notion> notionQuiz = new ArrayList<Notion>();
    protected ArrayList<Question> questionQuiz = new ArrayList<Question>();
    protected String etat;
    protected int idQuiz;
    protected static int nombrequiz;

    protected Quiz (String nom, Date dateouverture, Date dateexpiration, String etat) {
        this.nom = nom;
        this.dateouverture = dateouverture;
        this.dateexpiration = dateexpiration;
        this.etat = etat;
        this.idQuiz = nombrequiz;
        nombrequiz++;
    }

    public ArrayList<Question> getQuestionQuiz() {
        return questionQuiz;
    }

    protected void afficherQuiz () {
        System.out.println("Quiz : " + this.nom + ", ouvre le : " + this.dateouverture + ", termine le : " + this.dateexpiration + ". Etat : " + this.etat );
    }

    protected void etatQuiz () {

    }

    protected void reussiteQuiz () {

    }
}
