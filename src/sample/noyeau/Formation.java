package sample.noyeau ;

import java.util.ArrayList;
import java.util.Date;
public class Formation {
    protected String nom;
    protected String description;
    protected Date datedebut;
    protected Date datefin;
    protected ArrayList<Notion> notion = new ArrayList<Notion>();
    protected ArrayList<Quiz> quiz = new ArrayList<Quiz>();

    public ArrayList<Quiz> getQuiz() {
        return quiz;
    }

    public ArrayList<Notion> getNotion() {
        return notion;
    }

    protected Formation (String nom, String description, Date datedebut, Date datefin) {
        this.nom = nom;
        this.description = description;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    protected void afficherFormation () {
        System.out.println("Nom formation : " + this.nom);
        System.out.println("Description formation : " + this.description);
        System.out.println("Datedebut formation : " + this.datedebut);
        System.out.println("Datefin formation : " + this.datefin);
    }

    public void creerNotion (String notion) {
        this.notion.add(new Notion(notion));
    }

    protected void modifierNotion (String notion) {
    }
}
