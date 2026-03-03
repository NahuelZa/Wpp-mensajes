package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class modo_lista_eventos  extends modo_lista{

    @FXML
    private TextField buscar_boton;
    @FXML
    private Label label_titulo;

    @FXML
    private Button agregar_boton, aceptar_boton, cancelar_boton;
    @FXML
    private Pagination paginacion;

    @FXML
    @Override
    public void initialize() {
        // Llamamos al initialize del padre si tiene lógica (como llenar el ComboBox)
        super.initialize();

        // Ahora sí, cambiamos el texto

        aceptar_boton.setText("Hola perrita");
    }
}