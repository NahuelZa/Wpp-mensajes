package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

import static org.example.Controller.dimensiones_estandar_pantalla;

public class modo_lista {
        @FXML
        private ComboBox<Filtros> filtro_orden;
        @FXML
        private Button  cancelar_boton;


        //isInt(label_telefono,label_telefono.getText)


        @FXML
        public void initialize() {
                //Agrego valores de ENUM filtro al comboBox
                filtro_orden.getItems().setAll(Filtros.values());
                cancelar_boton.setOnAction(actionEvent -> {
                        Controller.cancelar_funcion(); });

        }

        public static void display(modo_lista controlador, int height, int width) throws IOException {
                FXMLLoader loader = new FXMLLoader(modo_lista.class.getResource("/Pantalla_listar.fxml"));
                // ASIGNAMOS el controlador manualmente ANTES de cargar
                loader.setController(controlador);
                Parent root = loader.load();
                App.getScene1().setRoot(root);
                Controller.dimensiones_estandar_pantalla(height, width);
        }
}


