package sample.noyeau ;

import java.util.ArrayList;

public class Qcu extends Question {
    public ArrayList<String> proposition = new ArrayList<String>();
    public String reponse;

    protected Qcu (String question) {
        this.question = question;
        this.proposition.add("Private");
        this.proposition.add("Default");
        this.proposition.add("Final");
        this.reponse = "Final";
    }

    protected void afficherquestion() {
        System.out.println("- " + this.question);
        int i = 0;
        while (i < this.proposition.size()) {
            System.out.println(i + "- " + this.proposition.get(i));
            i++;
        }
    }

    protected boolean evaluerQuestion (String reponseEtudiant) {
        int i = 0;
        boolean trouve = false;
        while (i < this.proposition.size() && !trouve) {
            if (reponseEtudiant.equals(this.reponse)) {
                trouve = true;
            } else {
                i++;
            }
        }
        if (trouve) {
            return true;
        } else {
            return false;
        }
    }
}
