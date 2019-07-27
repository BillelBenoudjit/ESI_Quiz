//import java.time.LocalDate;
//import java.util.*;
//
//public class Esiquiz {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        Date date;
//
//        date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
//        System.out.println(date);
//
//        Formateur formateur1 = new Formateur("Billel", "Ben");
//        formateur1.creerCompteApprenant("Ouchar", "Abdelhak", date, "Oran");
//        System.out.println("Compte Apprenant créeé !");
//        formateur1.apprenant.get(0).afficherApprenant();
//        formateur1.creerCompteApprenant("Oukacha", "Fouzi", date, "Setif");
//        System.out.println("Compte Apprenant créeé !");
//        formateur1.apprenant.get(1).afficherApprenant();
//        formateur1.creerCompteApprenant("Namani", "Adel", date, "Annaba");
//        System.out.println("Compte Apprenant créeé !");
//        formateur1.apprenant.get(1).afficherApprenant();
//        Date date1 = new GregorianCalendar(2019, Calendar.APRIL, 11).getTime();
//        Date date2 = new GregorianCalendar(2019, Calendar.JULY, 11).getTime();
//        formateur1.creerFormation("POO", "Une formation qui a pour but d'introduire les notions de bases de l'orienté objet", date1, date2);
//        formateur1.afficherFormateur();
//        formateur1.formation.creerNotion("Heritage");
//        System.out.println("Notion créeé !");
//        formateur1.formation.notion.get(0).ajouterQuestion("Abstraction ?");
//        formateur1.formation.notion.get(0).ajouterQuestion("Interface ?");
//        formateur1.formation.notion.get(0).ajouterQuestion("Instance ?");
//        formateur1.formation.creerNotion("Polymorphisme");
//        System.out.println("Notion créeé !");
//        formateur1.formation.notion.get(1).ajouterQuestion("Surdefinition ?");
//        formateur1.formation.notion.get(1).ajouterQuestion("Redéfinition ?");
//        date1 = new GregorianCalendar(2019, Calendar.APRIL, 11).getTime();
//        date2 = new GregorianCalendar(2019, Calendar.JULY, 1).getTime();
//        formateur1.creerQuiz("Initiation POO", date1, date2, "ouvert");
//        formateur1.consulterQuiz(1);
//        System.out.println("//////////////////////////////////////////////");
//        System.out.println("//////////////////////////////////////////////");
//        System.out.println("//////////////////////////////////////////////");
//        formateur1.ajouterQuestionQuiz(1);
//        System.out.println("Voulez vou remplacer une question du quiz ? Oui = 1/ Non = *");
//        int yup = sc.nextInt();
//        if (yup == 1) {
//            formateur1.remplacerQuestionQuiz(1);
//        }
//        formateur1.consulterQuiz(1);
//        formateur1.apprenant.get(0).afficherApprenant();
//        System.out.println("//////////////////////////////////////////////");
//        formateur1.apprenant.get(0).afficherListeQuiz();
//        System.out.println("//////////////////////////////////////////////");
//        formateur1.apprenant.get(0).repondreQuiz(1);
//        System.out.println("//////////////////////////////////////////////");
//        formateur1.apprenant.get(0).afficherReponsesApprenant(1);
//        System.out.println("//////////////////////////////////////////////");
//        formateur1.apprenant.get(0).modifierReponseQuiz(1);
//        System.out.println("//////////////////////////////////////////////");
//        formateur1.apprenant.get(0).afficherReponsesApprenant(1);
//        System.out.println("//////////////////////////////////////////////");
//        formateur1.apprenant.get(0).evaluerReponsesApprenant(1);
//        System.out.println("//////////////////////////////////////////////");
//        System.out.println("//////////////////////////////////////////////");
//        System.out.println("//////////////////////////////////////////////");
//        formateur1.apprenant.get(1).afficherApprenant();
//        System.out.println("//////////////////////////////////////////////");
//        formateur1.apprenant.get(1).repondreQuiz(1);
//        System.out.println("//////////////////////////////////////////////");
//        formateur1.apprenant.get(1).afficherReponsesApprenant(1);
//        System.out.println("//////////////////////////////////////////////");
//        formateur1.apprenant.get(1).evaluerReponsesApprenant(1);
//        System.out.println("//////////////////////////////////////////////");
//        System.out.println("//////////////////////////////////////////////");
//        System.out.println("//////////////////////////////////////////////");
//        formateur1.apprenant.get(2).afficherApprenant();
//        System.out.println("//////////////////////////////////////////////");
//        formateur1.apprenant.get(2).repondreQuiz(1);
//        System.out.println("//////////////////////////////////////////////");
//        formateur1.apprenant.get(2).afficherReponsesApprenant(1);
//        System.out.println("//////////////////////////////////////////////");
//        formateur1.apprenant.get(2).evaluerReponsesApprenant(1);
//        System.out.println("//////////////////////////////////////////////");
//        System.out.println("//////////////////////////////////////////////");
//        System.out.println("//////////////////////////////////////////////");
//        formateur1.apprenant.get(2).activiteApprenant();
//        System.out.println("//////////////////////////////////////////////");
//        formateur1.apprenant.get(1).activiteApprenant();
//        System.out.println("//////////////////////////////////////////////");
//        formateur1.apprenant.get(0).activiteApprenant();
//        System.out.println("//////////////////////////////////////////////");
//        formateur1.classementApprenant();
//    }
//}
