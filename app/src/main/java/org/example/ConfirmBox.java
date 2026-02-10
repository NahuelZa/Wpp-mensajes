package org.example;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    public static void display(String nombre, int edad){
        Stage window=new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Informacion");
        window.setWidth(200);

        Label labelNombre=new Label();
        labelNombre.setText("Tu nombre es " + nombre);

        Label labelEdad=new Label();
        labelEdad.setText("Tienes " + (edad-4) + " años");

        Button boton=new Button("Confrirmar");

        boton.setOnAction(actionEvent -> window.close());


        VBox box =new VBox(10);
        box.setPadding(new Insets(10));


        box.getChildren().addAll(labelNombre,labelEdad,boton);

        Scene escnea = new Scene(box,200,200);
        window.setScene(escnea);
        window.showAndWait();
    }
}
