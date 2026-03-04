package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

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
    public void initialize() throws SQLException {
        // Llamamos al initialize del padre si tiene lógica (como llenar el ComboBox)
        super.initialize();

        // Ahora sí, cambiamos el texto

        agregar_boton.setText("Agregar Evento");
    }
}