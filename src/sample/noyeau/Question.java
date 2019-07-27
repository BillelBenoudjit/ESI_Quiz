package sample.noyeau ;

import java.util.ArrayList;

public abstract class Question {
    public String question;

    abstract void afficherquestion();
    abstract boolean evaluerQuestion(String reponseEtudiant);
}
