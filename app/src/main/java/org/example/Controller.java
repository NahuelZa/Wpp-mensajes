package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;

public class Controller {

    @FXML
    private Button agregar_boton;
    @FXML
    private Button listar_boton;


    @FXML
    void onClick_PantallaInicial(ActionEvent event) {
        //Se guarda que boton aprete antes
        Button btnPresionado = (Button) event.getSource();


        try {
            // Cargo el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pantalla_segunda.fxml"));
            Parent root = loader.load();

            // Si quieres modificar algo de la SEGUNDA pantalla desde aquí,
            // necesitas pedirle al loader el controlador.
            Controller proximoControlador = loader.getController();

            // Cambio de pantalla al archivo FXML
            App.getScene1().setRoot(root);
            //Cambia el titulo de la segunda pantalla segun texto de boton presionado
            App.getWindow().setTitle("Sección " + btnPresionado.getText());
            // Cambio texto de segundo boton segun el texto del boton presionado
            proximoControlador.cambiarTextoBotonSecundario_agregar( btnPresionado.getText());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método nuevo dentro de la clase Controller para evitar el NullPointerException
    public void cambiarTextoBotonSecundario_agregar(String nuevoTexto) {
        if (agregar_boton != null ) {
            agregar_boton.setText("Agregar "+ nuevoTexto);
            listar_boton.setText("Listar "+ nuevoTexto + "s");
        }
    }

    @FXML
    public void initialize() {

    }
}