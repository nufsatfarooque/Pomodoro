package com.example.lab07_1a_210041115;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;

public class HelloController implements Initializable {
    @FXML
    private Button pomodoro;
    @FXML
    private Button shortBreak;
    @FXML
    private Button longBreak;
    @FXML
    private Button start;
    @FXML
    private Button startOri;
    @FXML
    private Label time;
    @FXML
    private TextArea txtAr;
    @FXML
    private AnchorPane main;
    @FXML
    private AnchorPane newF;
    private int min=25;
    private int sec=0;
    private TaskScene ts;
    int i=0;
    @FXML
    private TextArea textArea;//=new TextArea();
    @FXML
    private Button newBut;//=new Button();
    private Timeline timeline=new Timeline(new KeyFrame(Duration.seconds(1), event->{
        if(sec>0){
            sec--;
        }
        else if(min>0)
        {
            min--;
            sec=59;
        }
        else
        {
            shortBreak();
        }
        updateTime();
    }));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String formatText= String.format("%02d:%02d", min, sec);
        time.setText(formatText);
        timeline.setCycleCount(Animation.INDEFINITE);
        setPomodoro();
        start.setStyle("-fx-padding: 15px; -fx-border-color: black; -fx-border-width: 2px; " +
                        "-fx-border-style: dashed; -fx-border-radius: 1px;");
        //txtAr.setVisible(false);
        textArea.setVisible(false);
        newBut.setVisible(false);
    }
    private void updateTime(){
        String formatText= String.format("%02d:%02d", min, sec);
        time.setText(formatText);
    }

    @FXML
    public void setPomodoro(){
        min=25;
        sec=0;
        updateTime();
        timeline.stop();
        main.setStyle("-fx-background-color: #dd5858");
        pomodoro.setStyle("-fx-background-color:  #d03939");
        shortBreak.setStyle("-fx-background-color:  #d03939");
        longBreak.setStyle("-fx-background-color:  #d03939");
        //timeline.play();
    }

    @FXML
    public void LongBreak(ActionEvent Event){
        min=15;
        sec=0;
        updateTime();
        timeline.stop();
        //timeline.play();
        main.setStyle("-fx-background-color: #3778ba");
        pomodoro.setStyle("-fx-background-color:  #226aa6");
        shortBreak.setStyle("-fx-background-color:  #226aa6");
        longBreak.setStyle("-fx-background-color:  #226aa6");
    }
    @FXML
    public void shortBreak()
    {
        min=5;
        sec=0;
        updateTime();
        timeline.stop();
        main.setStyle("-fx-background-color: #349a9a");
        pomodoro.setStyle("-fx-background-color:  #108d87");
        shortBreak.setStyle("-fx-background-color:  #108d87");
        longBreak.setStyle("-fx-background-color:  #108d87");
        //timeline.play();
    }
    @FXML
    public void start(ActionEvent Event){
        timeline.play();
    }
    @FXML
    public void pause(ActionEvent Event){
        timeline.stop();
    }
    @FXML
    public void stop(ActionEvent Event){
        timeline.stop();
        setPomodoro();
    }


    public void addTaskHandler(ActionEvent E) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("taskScene.fxml"));
        Parent root=(Parent) loader.load();
        TaskScene ts=loader.getController();
        ts.setHelloController(this);


        //System.out.println(i);
        ts=loader.getController();

            String data = ts.saveButton();
            if(data!=null) {
                System.out.println(data);
                textBox(data);
            }
        //textBox(data);

        Stage stage=new Stage();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void textBox(String task){
        i++;
        System.out.println(i);
        //TextArea textArea=new TextArea();
        //Button newBut=new Button();
        //main.getChildren().add(textArea);
        //main.getChildren().add(newBut);
//        textArea.setLayoutX(20);
//        textArea.setLayoutY(i*350+50);
//        textArea.setMaxSize(180, 40);
        textArea.setVisible(true);
        textArea.setText(task);
//        newBut.setLayoutX(205);
//        newBut.setLayoutY(i*409);
        newBut.setVisible(true);
    }
    @FXML
    public void delete()
    {
        textArea.setVisible(false);

        newBut.setVisible(false);
        //main.getChildren().remove(textArea);
        //main.getChildren().remove(newBut);
    }



}