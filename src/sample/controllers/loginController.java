package sample.controllers ;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import java.io.*;
import javafx.scene.layout.AnchorPane ;
import java.awt.event.*;
import sample.noyeau.* ;
import java.util.*;
import java.time.LocalDate;
import com.jfoenix.controls.* ;
public class loginController implements Initializable  {
    public static Formateur loginFormateur = new Formateur("Billel", "Benoudjit");

    @FXML
    private AnchorPane toQuiz ;
    int a ;
    @FXML
    private JFXTextField email ;
    @FXML
    private JFXPasswordField password ;
    @FXML
    private Label error ;
    @FXML
    private void loadListQuiz() throws IOException {
        String b = "";
        if(email.getText().equals(b) || password.getText().equals(b) ) {
            error.setText("Veuillez indiquer votre identité !");
        } else {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../interfaces/listQuiz.fxml")) ;
            toQuiz.getChildren().setAll(pane);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        this.loginFormateur.creerCompteApprenant("Ouchar", "Abdelhak", date, "Oran");
        System.out.println("Compte Apprenant créeé !");
        this.loginFormateur.getApprenant().get(0).afficherApprenant();
        Date date1 = new GregorianCalendar(2019, Calendar.APRIL, 11).getTime();
        Date date2 = new GregorianCalendar(2019, Calendar.JULY, 11).getTime();
        this.loginFormateur.creerFormation("POO", "Une formation qui a pour but d'introduire les notions de bases de la programmation orienté objet", date1, date2);
        this.loginFormateur.afficherFormateur();
        this.loginFormateur.getFormation().creerNotion("Héritage");
        this.loginFormateur.getFormation().creerNotion("Encapsulation");
        this.loginFormateur.getFormation().creerNotion("Collections");

        this.loginFormateur.getFormation().getNotion().get(0).ajouterQuestion("Question 1 ?");
        this.loginFormateur.getFormation().getNotion().get(0).ajouterQuestion("Question 2 ?");
        this.loginFormateur.getFormation().getNotion().get(0).ajouterQuestion("Question 3 ?");
        this.loginFormateur.getFormation().getNotion().get(0).ajouterQuestion("Question 4 ?");
        this.loginFormateur.getFormation().getNotion().get(0).ajouterQuestion("Question 5 ?");
        this.loginFormateur.getFormation().getNotion().get(0).ajouterQuestion("Question 6 ?");
        this.loginFormateur.getFormation().getNotion().get(0).ajouterQuestion("Question 7 ?");
        this.loginFormateur.getFormation().getNotion().get(0).ajouterQuestion("Question 8 ?");
        this.loginFormateur.getFormation().getNotion().get(0).ajouterQuestion("Question 9 ?");

        this.loginFormateur.getFormation().getNotion().get(1).ajouterQuestion("Surdefinition ?");
        this.loginFormateur.getFormation().getNotion().get(1).ajouterQuestion("Redéfinition ?");
        this.loginFormateur.getFormation().getNotion().get(1).ajouterQuestion("Surdefinition ?");
        this.loginFormateur.getFormation().getNotion().get(1).ajouterQuestion("Redéfinition ?");
        this.loginFormateur.getFormation().getNotion().get(1).ajouterQuestion("Surdefinition ?");
        this.loginFormateur.getFormation().getNotion().get(1).ajouterQuestion("Redéfinition ?");
        this.loginFormateur.getFormation().getNotion().get(1).ajouterQuestion("Surdefinition ?");
        this.loginFormateur.getFormation().getNotion().get(1).ajouterQuestion("Redéfinition ?");

        this.loginFormateur.getFormation().getNotion().get(2).ajouterQuestion("Hash ?");
        this.loginFormateur.getFormation().getNotion().get(2).ajouterQuestion("Map ?");
        this.loginFormateur.getFormation().getNotion().get(2).ajouterQuestion("ArrayList ?");
    }
}
