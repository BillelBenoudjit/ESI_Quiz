package sample.controllers ;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import java.io.*;
import javafx.scene.control.ScrollPane ;
import javafx.scene.layout.* ;
import java.awt.event.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font ;
import sample.noyeau.Qcm;
import sample.noyeau.Qcu;
import sample.noyeau.Qo;
import sample.noyeau.Question;

public class questionsController implements Initializable  {
    @FXML
    private AnchorPane questions ;
    @FXML
    private Pane questionsContainer  ;
    @FXML
    private ScrollPane questionsContainerScroll ;
    @FXML
    private void backHandler() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../interfaces/listQuiz.fxml")) ;
        questions.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (int i = 0 ; i < loginController.loginFormateur.getFormation().getQuiz().get(0).getQuestionQuiz().size() ; i++ ) {
            AnchorPane question = new AnchorPane() ;
            Label questionStatement = new Label() ;
            Pane questionComponent1 = new Pane() ;
            questionStatement.setText(loginController.loginFormateur.getFormation().getQuiz().get(0).getQuestionQuiz().get(i).question);
            questionStatement.setLayoutX(14.0);
            questionStatement.setLayoutY(15.0);
            questionStatement.setFont(new Font(14.0));
            questionStatement.setTextFill(Color.web("#8c90b3", 1));
            question.setPrefHeight(50.0);
            question.setPrefWidth(270.0);
            question.setStyle("-fx-border-color: #8c90b3; -fx-border-radius: 2;");
            question.getChildren().add(questionStatement) ;
            question.setLayoutY(180 * i );
            Question currentQuestion  = loginController.loginFormateur.getFormation().getQuiz().get(0).getQuestionQuiz().get(i) ;
            if(currentQuestion instanceof Qcm ) {
                for(int j = 0 ; j < ((Qcm)currentQuestion).proposition.size()  ; j++) {
                    Label reponseStatement = new Label() ;
                    reponseStatement.setText( ( (Qcm) currentQuestion).proposition.get(j));
                    reponseStatement.setLayoutX(14.0);
                    reponseStatement.setLayoutY( 180 * i + 50 + 25 * j );
                    reponseStatement.setFont(new Font(14.0));
                    if (  ((Qcm) currentQuestion).reponse.contains(((Qcm) currentQuestion).proposition.get(j)) ) {
                        reponseStatement.setTextFill(Color.web("#43bb73", 1));

                    } else {
                        reponseStatement.setTextFill(Color.web("#8c90b3", 1));
                    }

                    questionComponent1.getChildren().add(reponseStatement) ;
                }

            }
            if (currentQuestion instanceof Qcu ) {
                for(int j = 0 ; j < ((Qcu)currentQuestion).proposition.size()  ; j++) {
                    Label reponseStatement = new Label() ;
                    reponseStatement.setText( ( (Qcu) currentQuestion).proposition.get(j));
                    reponseStatement.setLayoutX(14.0);
                    reponseStatement.setLayoutY( 180 * i + 50 + 25 * j );
                    reponseStatement.setFont(new Font(14.0));
                    if (  ((Qcu) currentQuestion).reponse.contains(((Qcu) currentQuestion).proposition.get(j)) ) {
                        reponseStatement.setTextFill(Color.web("#43bb73", 1));

                    } else {
                        reponseStatement.setTextFill(Color.web("#8c90b3", 1));
                    }

                    questionComponent1.getChildren().add(reponseStatement) ;
                }

            }
            if (currentQuestion instanceof Qo ) {
                for(int j = 0 ; j < ((Qo)currentQuestion).proposition.length  ; j++) {
                    Label reponseStatement = new Label() ;
                    reponseStatement.setText( ( (Qo) currentQuestion).proposition[j]);
                    reponseStatement.setLayoutX(14.0);
                    reponseStatement.setLayoutY( 180 * i + 50 + 25 * j );
                    reponseStatement.setFont(new Font(14.0));
                    reponseStatement.setTextFill(Color.web("#43bb73", 1));
                    questionComponent1.getChildren().add(reponseStatement) ;
                }

            }
            questionComponent1.getChildren().add(question) ;
            questionsContainerScroll.setPannable(true);
            questionsContainer.getChildren().add(questionComponent1) ;
        }
    }
}
