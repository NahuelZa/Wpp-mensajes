package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Personas   {

    Stage window;
    Scene scene1;




    public void diplay() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/Pantalla_personas.fxml"));
        App.getScene1().setRoot(root);

        //Ventana
        App.getWindow().setTitle("Seccion Personas");


        //layout




    }



}