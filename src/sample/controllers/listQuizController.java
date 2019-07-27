package sample.controllers ;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import java.io.*;
import javafx.scene.layout.AnchorPane ;
import sample.noyeau.Qcm;
import sample.noyeau.Question;

import java.awt.event.*;

public class listQuizController implements Initializable  {
    @FXML
    private AnchorPane toAdd ;
    @FXML
    private Pane listContainer ;
    @FXML
    private void loadAddQuiz() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../interfaces/addQuiz.fxml")) ;
        toAdd.getChildren().setAll(pane);
    }
    @FXML
    private void viewQuiz() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../interfaces/questions.fxml")) ;
        toAdd.getChildren().setAll(pane);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources)  {
        System.out.println("///////////////////////////////////////////////////////////////////::");
        //System.out.println(listContainer.getChildren().indexOf());/
        System.out.println("////////////////////////////////////////////////////////////////////::");
        for (int i = 0 ; i < loginController.loginFormateur.getFormation().getQuiz().size() ; i++ ) {
            AnchorPane question = new AnchorPane() ;
            javafx.scene.control.Label questionStatement = new javafx.scene.control.Label() ;
            questionStatement.setText(loginController.loginFormateur.getFormation().getQuiz().get(i).nom);
            questionStatement.setLayoutX(14.0);
            questionStatement.setLayoutY(15.0);
            questionStatement.setId(new Integer(i+1).toString());
            questionStatement.setFont(new javafx.scene.text.Font(14.0));
            questionStatement.setTextFill(javafx.scene.paint.Color.web("#8c90b3", 1));
            question.setPrefHeight(50.0);
            question.setOnMouseClicked((e) -> {
                try {
                    this.viewQuiz();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
            question.setPrefWidth(270.0);
            question.setStyle("-fx-border-color: #8c90b3; -fx-border-radius: 2;");
            question.getChildren().add(questionStatement) ;
            question.setLayoutY(0 + 60 * i );

            listContainer.getChildren().add(question) ;

        }
    }
}
