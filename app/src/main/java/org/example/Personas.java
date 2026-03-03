package org.example;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Personas   {

    private String nombre;
    private String apellido;
    private List<String> alias;
    private int telefono;
    private LocalDate fecha_nacimiento;
    private Categoria categoria;
    private List<Eventos> evento;


    public Personas(String nombre, String apellido, List<String> alias, int telefono, LocalDate fecha_nacimiento,Categoria categoria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.alias = alias;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.categoria = categoria;
        this.evento = null;
    }

    public Personas(String nombre, String apellido, List<String> alias, int telefono, LocalDate fecha_nacimiento, Categoria categoria, List<Eventos> evento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.alias = alias;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.categoria = categoria;
        this.evento = evento;
    }

    public void diplay() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/Pantalla_segunda.fxml"));

        App.getScene1().setRoot(root);

        //Ventana
        App.getWindow().setTitle("Seccion Personas");

        //layout


    }

    @Override
    public String toString() {
        return "Personas{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", alias=" + alias +
                ", telefono=" + telefono +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", categoria=" + categoria +
                ", evento=" + evento +
                '}';
    }
}