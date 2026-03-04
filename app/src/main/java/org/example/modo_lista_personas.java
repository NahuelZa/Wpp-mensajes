package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.DbConnection.*;
import org.example.modelos.personas;

import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class modo_lista_personas extends modo_lista {

    @FXML
    private TextField buscar_boton;
    @FXML
    private Label label_titulo;
    @FXML
    private ComboBox<Filtros> filtro_orden;
    @FXML
    private Button agregar_boton, aceptar_boton, cancelar_boton;
    @FXML
    private Pagination paginacion;
    @FXML
    private TableView<personas> tabla_contenido;
    @FXML
    private TableColumn<personas, String> fechaCol;
    @FXML
    private TableColumn<personas, String> nombreCol;
    @FXML
    private TableColumn<personas, String> apellidoCol;
    @FXML
    private TableColumn<personas, Enum> categoriaCol;
    @FXML
    private TableColumn<personas, Integer> telefonoCol;

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    personas persona = null;

    ObservableList<personas> personaList = FXCollections.observableArrayList();

    @FXML
    @Override
    public void initialize() throws SQLException {
        // Llamamos al initialize del padre si tiene lógica (como llenar el ComboBox)
        try {
            super.initialize();
            loadData();
            }
        catch (SQLException e){
            System.out.println("error nose pudo cargar base de dats");
        }


        // Ahora sí, cambiamos el texto
        agregar_boton.setText("Agregar Persona");
    }

    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void refreshTable() {
        try {
            personaList.clear();

            query = "SELECT * FROM `persona`";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            System.out.println(preparedStatement);

            while (resultSet.next()) {
                LocalDate fechaNac = resultSet.getDate("birthday").toLocalDate();
                int categoriaId = resultSet.getInt("categoriaId");
                //como los ENUM tiene numeros asignaods y empiezan desde 0 y sql empieza desde 1 los ID le quito 1 al dato traido de sql
                Categoria categoria = Categoria.values()[categoriaId - 1];
                System.out.println("perra");

                personaList.add(new personas(
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("phone"),
                        fechaNac,
                        categoria


                ));
            }


            tabla_contenido.setItems(personaList);


        } catch (SQLException ex) {
            System.out.println("Eerror" + ex);
        }


    }



    private void loadData() throws SQLException {

        connection = DbConnection.getConnection();
        refreshTable();

        //idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombreCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellidoCol.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        fechaCol.setCellValueFactory(new PropertyValueFactory<>("fecha_nacimiento"));
        categoriaCol.setCellValueFactory(new PropertyValueFactory<>("categoria"));




        tabla_contenido.setItems(personaList);


    }



}