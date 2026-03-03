package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.Stage;


public class Controller_agregar_persona {
    @FXML
    private TextField label_nombre, label_apellido, label_telefono, label_alias;
    @FXML
    private RadioButton evento_radioButton_y, evento_radioButton_n;
    @FXML
    private ComboBox<Categoria> categoria_comboBox;
    @FXML
    private DatePicker fechaNacimiento_datePicker;
    @FXML
    private Label error_label, error_nombre, error_apellido, error_categoria, error_fecha;
    @FXML
    private Button boton_aceptar,boton_cancelar;
    private boolean valido;
    private int telefono;
    private String nombre;
    private String apellido;
    private LocalDate fecha;
    private Categoria categoria;


    //isInt(label_telefono,label_telefono.getText)



    @FXML
    public void initialize() {
        categoria_comboBox.getItems().setAll(Categoria.values());

        label_telefono.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                error_label.setText("");
                valido = false;
            } else if (!newValue.matches("\\d*")) {
                error_label.setText("Ingrese solo numeros");
                valido = false;
            } else {
                error_label.setText("");

            }
        });
        System.out.println(valido);




        boton_aceptar.setOnAction(actionEvent -> {
            //Si nombre esta vacio error
            valido = true;
            if (!label_nombre.getText().isBlank()) {
                nombre = label_nombre.getText();
                error_nombre.setText("");

            } else {
                error_nombre.setText("*");
                valido = false;
            }
            //Si apellido esta vacio error
            if (!label_apellido.getText().isBlank()) {
                apellido = label_apellido.getText();
                error_apellido.setText("");

            } else {
                error_apellido.setText("*");
                valido = false;
            }

            //Si date esta vacio error
            if (fechaNacimiento_datePicker.getValue() != null) {
                fecha = fechaNacimiento_datePicker.getValue();
                error_fecha.setText("");

            } else {
                error_fecha.setText("*");
                valido = false;
            }

            if (!label_telefono.getText().isBlank() && label_telefono.getText().matches("\\d+")) {
                telefono = Integer.parseInt(label_telefono.getText());
            } else {

                valido = false;
            }

            if (categoria_comboBox.getValue() != null) {
                categoria = categoria_comboBox.getValue();
                error_categoria.setText("");

            } else {
                error_categoria.setText("*");
                valido = false;
            }

            ;
            /**
             * Tomo el texto del label alias los separa por comas
             * map aplica funcion a cada elemento.
             * String::trim se encarga de limpiar los espacios en blanco
             * filter solo deja pasar los elementos que no estén vacíos
             * toList empaqueta elementos en una List<String>
             **/
            List<String> listaAlias = Arrays.stream(label_alias.getText().split(",")).map(String::trim).filter(s -> !s.isEmpty()).toList();


            if (valido) {
                Personas nuevaPersona = new Personas(nombre, apellido, listaAlias, telefono, fecha, categoria);
                AlertBox.display("Agregado exitoso",  nuevaPersona + " agregado exitosamente");


            } else {
                error_label.setText("Completa todos los campos vieja");
            }


        });



       boton_cancelar.setOnAction(actionEvent -> Controller.cancelar_funcion());


    }
}
