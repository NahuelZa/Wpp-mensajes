package org.example;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Date;

public class Personas   {

    private String nombre;
    private String apellido;
    private String alias;
    private int telefono;
    private Date fecha_nacimiento;
    private Categoria categoria;
    private Eventos evento;




    public void diplay() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/Pantalla_segunda.fxml"));

        App.getScene1().setRoot(root);

        //Ventana
        App.getWindow().setTitle("Seccion Personas");

        //layout


    }



}