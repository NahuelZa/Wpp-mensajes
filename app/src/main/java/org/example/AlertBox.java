package org.example;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void display(String title, String message){
        Stage window=new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(200);

        Label label=new Label();
        label.setText(message);
        Button boton = new Button("Close the window");
        boton.setOnAction(actionEvent -> window.close());

        VBox layout= new VBox(10);
        layout.getChildren().addAll(label,boton);
        layout.setAlignment(Pos.CENTER);

        Scene escnea = new Scene(layout);
        window.setScene(escnea);
        window.showAndWait();


    }
}
