package sample.noyeau ;

import java.util.ArrayList;

public class Qcm extends Question implements Qcmevaluer {
    public ArrayList<String> proposition = new ArrayList<String>();
    public ArrayList<String> reponse = new ArrayList<String>();


    protected Qcm(String question) {
        this.question = question;
        this.proposition.add("Instance");
        this.proposition.add("Class");
        this.proposition.add("Public");
        this.proposition.add("Méthode");
        this.proposition.add("Attribut");
        this.reponse.add("Class");
        this.reponse.add("Public");
    }

    protected void afficherquestion () {
        System.out.println("- " + this.question);
        int i = 0;
        while (i < this.proposition.size()) {
            System.out.println(i + "- " + this.proposition.get(i));
            i++;
        }
    }

    public double evaluerQuestionQcm(Reponse Reponse) {
        int i = 0;
        int j;
        int k;
        int l;
        double cpt = 0;
        int point = 0;
        boolean correcte;
        boolean trouve;
        while (i < this.proposition.size()) {
            j = 0;
            trouve = false;
            while (j < this.reponse.size() && !trouve) {
                if (this.proposition.get(i).equals(this.reponse.get(j))) {
                    trouve = true;
                } else {
                    j++;
                }
            }
            if (trouve) {
                k = 0;
                correcte = false;
                while (k < Reponse.reponse.size() && !correcte) {
                    if (this.proposition.get(i).equals(Reponse.reponse.get(k))) {
                        correcte = true;
                    } else {
                        k++;
                    }
                }
                if (correcte) {
                    cpt++;
                } else {
                    cpt--;
                }
            } else {
                l= 0;
                correcte = false;
                while (l < Reponse.reponse.size() && !correcte) {
                    if (Reponse.reponse.get(l).equals(this.proposition.get(i))) {
                        correcte = true;
                    } else {
                        l++;
                    }
                }
                if (correcte) {
                    cpt--;
                } else {
                    cpt++;
                }
            }
            i++;
        }
        if (cpt < 0) {
            return 0;
        } else {
            return cpt/this.proposition.size();
        }
    }

    protected boolean evaluerQuestion (String reponseEtudiant) {
        return false;
    }
}
