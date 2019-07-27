package sample.noyeau ;


public class Qo extends Question {
    public String proposition[] = new String[2];

    protected Qo (String question) {
        this.question = question;
        this.proposition[0] = "Map";
        this.proposition[1] = "Hash";
    }

    protected void afficherquestion() {
        System.out.println("- " + this.question);
    }

    protected boolean evaluerQuestion (String reponseEtudiant) {
        int i = 0;
        boolean trouve = false;
        while (i < this.proposition.length && !trouve) {
            if (this.proposition[i].equals(reponseEtudiant)) {
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
