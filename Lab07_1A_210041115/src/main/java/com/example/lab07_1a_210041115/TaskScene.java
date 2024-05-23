package com.example.lab07_1a_210041115;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class TaskScene {
    @FXML
    TextField text;
    @FXML
    private Button save;
    String data;
    int i=0;
    private HelloController hc;
    public void saveButtonHandler(ActionEvent e) throws IOException {
        data= text.getText();
        System.out.println(data);
        if (hc != null) {
            System.out.println("NULL");
            hc.textBox(data);
        } else {
            System.out.println("HelloController instance not set!");
        }
        //hc.textBox(data);
        i++;
    }
    public void setHelloController(HelloController helloController) {
        this.hc = helloController;
    }
    public String saveButton(){
       // String data= text.getText();
        return data;
        //HelloController hc=new HelloController();
        //hc.textBox(data);
    }
}
