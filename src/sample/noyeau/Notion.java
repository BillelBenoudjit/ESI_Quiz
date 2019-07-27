package sample.noyeau ;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Notion {
    protected String notion;
    protected ArrayList<Question> question = new ArrayList<Question>();

    Scanner sc = new Scanner(System.in);

    public String getNotion() {
        return notion;
    }

    protected Notion (String notion) {
        this.notion = notion;
    }

    protected void afficherNotion() {
        System.out.println("Notion : " + this.notion);
    }

    public void ajouterQuestion (String question) {
        System.out.println("- " + question);
        System.out.println("Veuillez choisir le type de question");
        System.out.println("1- Qcm.  2- Qo.  3-Qcu");
//        int i = sc.nextInt();
        Random rand = new Random();
        int rand_question = rand.nextInt(3);
        int i = rand_question + 1 ;
        switch (i) {
            case 1:
                this.question.add(new Qcm(question));
                break;
            case 2:
                this.question.add(new Qo(question));
                break;
            case 3:
                this.question.add(new Qcu(question));
                break;
            default:
                System.out.println("Veuillez re-indiquer votre choix !");
        }


    }

    protected void changerQuestion () {

    }

    protected void supprimerQuestion () {

    }
}
