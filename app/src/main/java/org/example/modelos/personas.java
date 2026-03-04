package org.example.modelos;

import org.example.Categoria;

import java.time.LocalDate;
import java.util.List;

public class personas {

    private String nombre;
    private String apellido;
    private List<String> alias;
    private int telefono;
    private LocalDate fecha_nacimiento;
    private Categoria categoria;
    private List<Eventos> evento;

    public personas(String nombre, String apellido, int telefono, LocalDate fecha_nacimiento, Categoria categoria) {
        this(nombre, apellido, null, telefono, fecha_nacimiento, categoria);
    }

    public personas(String nombre, String apellido, List<String> alias, int telefono, LocalDate fecha_nacimiento, Categoria categoria) {
        this(nombre, apellido, alias, telefono, fecha_nacimiento, categoria, null);
    }

    public personas(String nombre, String apellido, List<String> alias, int telefono, LocalDate fecha_nacimiento, Categoria categoria, List<Eventos> evento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.alias = alias;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.categoria = categoria;
        this.evento = evento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<String> getAlias() {
        return alias;
    }

    public void setAlias(List<String> alias) {
        this.alias = alias;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Eventos> getEvento() {
        return evento;
    }

    public void setEvento(List<Eventos> evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "personas{" +
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


