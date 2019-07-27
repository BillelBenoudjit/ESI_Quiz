package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label ;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.awt.*;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import java.io.*;
import javafx.scene.layout.AnchorPane ;
import java.awt.event.*;
import com.jfoenix.controls.JFXDatePicker ;
import sample.noyeau.* ;
import java.time.LocalDate;
import java.time.Instant;

public class addQuizController implements Initializable  {
    @FXML
    private AnchorPane toListQuiz , notions ;
    @FXML
    private TextField nomQuiz , number1 , number2 , number3;
    @FXML
    private JFXDatePicker dateDebut ;
    @FXML
    private JFXDatePicker dateFin ;
    @FXML
    private Label notion1 , notion2 , notion3 ;
    @FXML
    private void loadListQuiz() throws IOException {
        java.util.Date dateDebut2 = java.sql.Date.valueOf(dateDebut.getValue());
        java.util.Date dateFin2 = java.sql.Date.valueOf(dateFin.getValue());
        String QuizName = nomQuiz.getText() ;
        loginController.loginFormateur.creerQuiz( QuizName , dateDebut2 , dateFin2, "ouvert" , Integer.parseInt(number1.getText()) , Integer.parseInt(number2.getText()) , Integer.parseInt(number3.getText()));
        loginController.loginFormateur.consulterQuiz(1);
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../interfaces/listQuiz.fxml")) ;
        toListQuiz.getChildren().setAll(pane);
    }
    @FXML
    private void backHandler() throws IOException {
        System.out.println(nomQuiz.getText());
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../interfaces/listQuiz.fxml")) ;
        toListQuiz.getChildren().setAll(pane);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        notion1.setText(loginController.loginFormateur.getFormation().getNotion().get(0).getNotion());
        notion2.setText(loginController.loginFormateur.getFormation().getNotion().get(1).getNotion());
        notion3.setText(loginController.loginFormateur.getFormation().getNotion().get(2).getNotion());
    }
}
