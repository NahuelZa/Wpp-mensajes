package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

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
            proximoControlador.cambiarTextoBotones_segundaPantalla(btnPresionado.getText());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cambio el texto de los botones de la segunda pantalla segun eleccion del usuario
    public void cambiarTextoBotones_segundaPantalla(String nuevoTexto) {
        if (agregar_boton != null) {
            agregar_boton.setText("Agregar " + nuevoTexto);
            listar_boton.setText("Listar " + nuevoTexto);
        }
    }

    public static void dimensiones_estandar_pantalla(int width, int height) {
        App.getWindow().setWidth(width);
        App.getWindow().setHeight(height);
    }

    private void cambio_pantalla_fxml(String fxml) throws IOException {
        try {
            // Cargo el archivo FXML
            FXMLLoader loaderAgregar = new FXMLLoader(getClass().getResource(fxml));
            Parent rootAgregar = loaderAgregar.load();
            App.getScene1().setRoot(rootAgregar);
        } catch (IOException e) {
            e.printStackTrace();


        }
    }

    public static void cancelar_funcion() {

        try {
            // Cargo el archivo FXML
            FXMLLoader loader = new FXMLLoader(Controller.class.getResource("/Pantalla_inicial.fxml"));
            Parent root = loader.load();
            // Cambio de pantalla al archivo FXML
            App.getScene1().setRoot(root);
            Controller.dimensiones_estandar_pantalla(500, 500);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void onClick_PantallaAgregar() throws IOException {
        try {
            if (agregar_boton.getText().equals("Agregar Personas")) {
                cambio_pantalla_fxml("/Pantalla_agregar_persona.fxml");

                //Cambia el titulo de la segunda pantalla segun texto de boton presionado
                App.getWindow().setTitle("Agregar Personas");
                dimensiones_estandar_pantalla(263, 500);
            }
            if (agregar_boton.getText().equals("Agregar Eventos")) {
                cambio_pantalla_fxml("/Pantalla_agregar_eventos.fxml");
                dimensiones_estandar_pantalla(263, 500);
            }

            if (agregar_boton.getText().equals("Agregar Mensajes")) {
                cambio_pantalla_fxml("/Pantalla_agregar_mensaje.fxml");
                dimensiones_estandar_pantalla(263, 500);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onClick_PantallaListar() throws IOException {
        try {
            if (listar_boton.getText().equals("Listar Personas")) {
                modo_lista.display(new modo_lista_personas(), 900, 900);

            }
            if (listar_boton.getText().equals("Listar Eventos")) {
                modo_lista.display(new modo_lista_eventos(), 900, 900);

            }

            if (listar_boton.getText().equals("Listar Mensajes")) {
                modo_lista.display(new modo_lista_personas(),900,900);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //Para cambiar estilos etc

    @FXML
    public void initialize() {


    }
}