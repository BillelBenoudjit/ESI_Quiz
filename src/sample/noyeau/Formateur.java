package sample.noyeau ;
import java.util.*;

public class Formateur extends Authentification {
    protected Formation formation;
    protected ArrayList<Apprenant> apprenant = new ArrayList<Apprenant>();
    protected String nom;
    protected String prenom;

    Scanner sc = new Scanner(System.in);

    public ArrayList<Apprenant> getApprenant() {
        return apprenant;
    }

    public Formation getFormation() {
        return formation;
    }

    public Formateur (String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    protected void creerCompte () {

    }

    protected void seConnecter () {

    }

    public void afficherFormateur () {
        System.out.println("le formateur est : " + this.nom + " " + this.prenom);
        this.formation.afficherFormation();
    }

    public void creerFormation (String nom, String description, Date datedebut, Date datefin) {
        this.formation = new Formation(nom, description, datedebut, datefin);
    }

    public void creerCompteApprenant (String nom, String prenom, Date datenaissance, String adresse) {
        this.apprenant.add(new Apprenant (nom, prenom, datenaissance, adresse));
    }

    protected void modifierCompteApprenant (int id) {
        int i = 1;
        if (id < Apprenant.nombreapprenant) {
            while (i != 0) {
                this.apprenant.get(id).afficherApprenant();
                System.out.println("/// Modification compte apprenant ///");
                System.out.println("1- Voulez vous modifier le nom de l'apprenant ?");
                System.out.println("2- Voulez vous modifier le prénom de l'apprenant ?");
                System.out.println("3- Voulez vous modifier la date de naissance de l'apprenant ?");
                System.out.println("4- Voulez vous modifier l'adresse de l'apprenant ?");
                int k = sc.nextInt();
                switch (k) {
                    case 1:
                        System.out.println(this.apprenant.get(id).nom);
                        System.out.println("- Veuillez indiquer le nouveau nom de l'apprenant:");
                        this.apprenant.get(id).nom = sc.next();
                        break;
                    case 2:
                        System.out.println("- Veuillez indiquer le nouveau prénom de l'apprenant:");
                        this.apprenant.get(id).prenom = sc.next();
                        break;
                    case 3:
                        System.out.println("- Veuillez indiquer la date de naissance de l'apprenant:");
                        System.out.println("Service indisponible !");
                        break;
                    case 4:
                        System.out.println("- Veuillez indiquer l'adresse de l'apprenant:");
                        this.apprenant.get(id).adresse = sc.next();
                    default:
                        System.out.println("Vous ne pouvez effectuer aucune modification !");
                }
                System.out.println("////////////////////");
                this.apprenant.get(id).afficherApprenant();
                System.out.println("////////////////////");
                System.out.println("Voulez vous effectuer d'autres modifications ? Oui = */Non = 0");
                i = sc.nextInt();
            }

        }
    }

    protected void supprimerCompteApprenant (int id) {
        if (id < Apprenant.nombreapprenant) {
            this.apprenant.remove(id);
            Apprenant.nombreapprenant--;
        } else {
            System.out.println("Etudiant n'existe pas !");
        }
    }

    public void creerQuiz (String nom, Date dateouverture, Date dateexpiration, String etat , int number1 , int number2 , int number3) {
        int i = 0;
        int j;
        int k;
        int etudiant = 0;
        int notion = 0;
        int question = 0;
        int taille = 0;
        ArrayList<Integer> randomQuestion = new ArrayList<Integer>();
        Quiz quizAjout = new Quiz(nom, dateouverture, dateexpiration, etat);
        this.formation.quiz.add(quizAjout);
        int indice = Quiz.nombrequiz - 1;
        System.out.println("Indice du quiz :" + indice);
        /*while (etudiant < this.apprenant.size()) {
            this.apprenant.get(etudiant).quizList.add(quizAjout);
            etudiant++;
        }*/
        System.out.println("Nombre Quiz : " + Quiz.nombrequiz);
        System.out.println("/// Traitement des notions ///");
        while (i < this.formation.notion.size()) {
            this.formation.notion.get(i).afficherNotion();
            System.out.println("Voulez-vous ajouter cette notion au quiz ? Oui = 1/ Non = *");
//            k = sc.nextInt();
            k = 1 ;
            if (k == 1) {
                this.formation.quiz.get(indice).notionQuiz.add(this.formation.notion.get(i));
                etudiant = 0;
                /*while (etudiant < this.apprenant.size()) {
                    this.apprenant.get(etudiant).quizList.get(indice).notionQuiz.add(this.formation.notion.get(i));
                    etudiant++;
                }*/
            }
            i++;
        }
        i = 0;
        System.out.println("//////////////////////////////");
        System.out.println("/// Traitement des questions des notions choisies ///");
        while (i < this.formation.quiz.get(indice).notionQuiz.size()) {
            System.out.println("Veuillez indiquer le nombre de question à ajouter au quiz, au maximum : " + this.formation.quiz.get(indice).notionQuiz.get(i).question.size() + ", Oui = 1 / Non = 1");
//            taille = sc.nextInt();
            switch (i) {
                case 0 : {
                    taille = number1 ;
                    break;
                }
                case 1 : {
                    taille = number2 ;
                    break;
                }
                case 2 : {
                    taille = number3 ;
                    break;
                }
                default: break;
            }
            if (taille == this.formation.quiz.get(indice).notionQuiz.get(i).question.size()) {
                j = 0;
                while (j < this.formation.quiz.get(indice).notionQuiz.get(i).question.size()) {
                    this.formation.quiz.get(indice).notionQuiz.get(i).question.get(j).afficherquestion();
                    this.formation.quiz.get(indice).questionQuiz.add(this.formation.quiz.get(indice).notionQuiz.get(i).question.get(j));
                    etudiant = 0;
                    /*while (etudiant < this.apprenant.size()) {
                        this.apprenant.get(etudiant).quizList.get(indice).questionQuiz.add(this.formation.quiz.get(indice).notionQuiz.get(i).question.get(j));
                        etudiant++;
                    }*/
                    j++;
                }
                i++;
            } else if (taille < this.formation.quiz.get(indice).notionQuiz.get(i).question.size()) {
                k = 0;
                Random rand = new Random();
                int rand_question = rand.nextInt(1000);
                while (k < taille) {
                    rand_question = rand.nextInt(this.formation.quiz.get(indice).notionQuiz.get(i).question.size());
                    if (k == 0) {
                        randomQuestion.add(rand_question);
                        k++;
                    } else if (randomQuestion.contains(rand_question)) {
                    } else {
                        randomQuestion.add(rand_question);
                        k++;
                    }
                }
                k = 0;
                while (k < taille) {
                    System.out.println("Le numéro de question : " + randomQuestion.get(k));
                    System.out.println("La taille du random liste : " + randomQuestion.size());
                    this.formation.quiz.get(indice).notionQuiz.get(i).question.get(randomQuestion.get(k)).afficherquestion();
                    this.formation.quiz.get(indice).questionQuiz.add(this.formation.quiz.get(indice).notionQuiz.get(i).question.get(randomQuestion.get(k)));
                    etudiant = 0;
                    /*while (etudiant < this.apprenant.size()) {
                        this.apprenant.get(etudiant).quizList.get(indice).questionQuiz.add(this.formation.quiz.get(indice).notionQuiz.get(i).question.get(randomQuestion.get(k)));
                        etudiant++;
                    }*/
                    k++;
                }
                k = taille - 1;
                while (k >= 0) {
                    randomQuestion.remove(k);
                    k--;
                }
                System.out.println("La taille du random liste aprés création : " + randomQuestion.size());
                i++;
            } else {
                System.out.println("Veuillez indiquer un nombre acceptable de questions pour le quiz !");
            }
        }
        etudiant = 0;
        while (etudiant < this.apprenant.size()) {
            this.apprenant.get(etudiant).reponsequiz.add(new Reponsequiz());
            etudiant++;
        }
    }

    public void consulterQuiz (int id) {
        if (id < Quiz.nombrequiz) {
            this.formation.quiz.get(id-1).afficherQuiz();
            int i = 0;
            System.out.println("/// Notions du quiz ///");
            while (i < this.formation.quiz.get(id-1).notionQuiz.size()) {
                this.formation.quiz.get(id-1).notionQuiz.get(i).afficherNotion();
                i++;
            }
            i = 0;
            System.out.println("/// Questions du quiz ///");
            while (i < this.formation.quiz.get(id-1).questionQuiz.size()) {
                i++;
                System.out.print("///////////// " + i + "");
                i--;
                this.formation.quiz.get(id-1).questionQuiz.get(i).afficherquestion();
                i++;
            }
        }
    }

    protected void supprimerQuestionQuiz (int id) {
        this.consulterQuiz(id);
        System.out.println("Veuillez indiquer le id de la question à supprimer");
        int i = sc.nextInt();
        i--;
        if (i < this.formation.quiz.get(id).questionQuiz.size()) {
            this.formation.quiz.get(id).questionQuiz.remove(i);
        } else {
            System.out.println("Question n'existe pas !");
        }
        this.consulterQuiz(id);
    }

    protected void ajouterQuestionQuiz (int id) {
        int i = 0;
        int l;
        int etudiant;
        int k;

        while (i < this.formation.quiz.get(id-1).notionQuiz.size()) {
            this.formation.quiz.get(id-1).notionQuiz.get(i).afficherNotion();
            System.out.println("Voulez vous ajouter une question de cette notion ? Oui = 1/Non = *");
            k = sc.nextInt();
            if (k == 1) {
                l = 0;
                while (l < this.formation.quiz.get(id-1).notionQuiz.get(i).question.size()) {
                    this.formation.quiz.get(id-1).notionQuiz.get(i).question.get(l).afficherquestion();
                    if (this.formation.quiz.get(id-1).questionQuiz.contains(this.formation.quiz.get(id-1).notionQuiz.get(i).question.get(l))) {
                        System.out.println("Pas d'ajout, question existe déja !");
                    } else {
                        System.out.println("Voulez vous ajouter cette question au quiz ? Oui = 1 / Non = *");
                        k = sc.nextInt();
                        if (k == 1) {
                            this.formation.quiz.get(id-1).questionQuiz.add(this.formation.quiz.get(id-1).notionQuiz.get(i).question.get(l));
                            etudiant = 0;
                            while (etudiant < this.apprenant.size()) {
                                this.apprenant.get(etudiant).quizList.get(id-1).questionQuiz.add(this.formation.quiz.get(id-1).notionQuiz.get(i).question.get(l));
                                etudiant++;
                            }
                            System.out.println("Question ajoutée !");
                        }
                    }
                    l++;
                }
            } i++;
        }
    }

    protected void remplacerQuestionQuiz (int id) {
        consulterQuiz(id);
        int i = 0;
        int j = 0;
        int m;
        int k;
        int l;
        int etudiant = 0;
        boolean trouve = false;
        boolean arret = false;
        System.out.println("Veuillez indiquer le numéro de question à remplacer");
        k = sc.nextInt();
        k--;
        while (i < this.formation.quiz.get(id-1).notionQuiz.size() && !trouve) {
            j = 0;
            while (j < this.formation.quiz.get(id-1).questionQuiz.size() && !trouve) {
                if (this.formation.quiz.get(id-1).questionQuiz.get(k).question.equals(this.formation.quiz.get(id-1).notionQuiz.get(i).question.get(j).question)) {
                    trouve = true;
                } else {
                    j++;
                }
            }
            i++;
        }
        if (trouve) {
            m = 0;
            i--;
            while (m < this.formation.quiz.get(id-1).notionQuiz.get(i).question.size() && !arret) {
                if (m != j) {
                    if (this.formation.quiz.get(id-1).questionQuiz.contains(this.formation.quiz.get(id-1).notionQuiz.get(i).question.get(m))) {
                    } else {
                        this.formation.quiz.get(id-1).notionQuiz.get(i).question.get(m).afficherquestion();
                        System.out.println("Voulez vous remplacer la question par celle là ? Oui = 1/Non = *");
                        l = sc.nextInt();
                        if (l == 1) {
                            this.formation.quiz.get(id-1).questionQuiz.set(k, this.formation.quiz.get(id-1).notionQuiz.get(i).question.get(m));
                            System.out.println("Question remplacée !");
                            arret = true;
                            while (etudiant < this.apprenant.size()) {
                                this.apprenant.get(etudiant).quizList.get(id-1).questionQuiz.set(k, this.formation.quiz.get(id-1).notionQuiz.get(i).question.get(m));
                                etudiant++;
                            }
                        }
                    }
                }
                m++;
            }

        }
        if (!arret) {
            System.out.println("Question non remplacée");
        }
        this.consulterQuiz(id);
    }

    protected void classementApprenant () {
        Collections.sort(this.apprenant);

        for (Apprenant str:this.apprenant) {
            System.out.println(str);
        }
    }
}
