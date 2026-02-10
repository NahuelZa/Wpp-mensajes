package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Eventos extends App {

    Stage window;
    Scene scene1;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Pantalla_inicial.fxml"));

        scene1=new Scene(root,500,500);
        //Ventana
        window = primaryStage;
        window.setTitle("Bus 69");
        window.setScene(scene1);

        //layout
        window.show();



    }


    public static void main(String[] args) {
        launch(args);
        ;

    }
}