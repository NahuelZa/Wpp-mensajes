package org.example;

public enum Filtros {
    Alfabetico,
    Fecha_cumpleanos,
    Canntidad_de_mensajes,
    Eventos;

    @Override
    public String toString() {
        return name().replace("_", " ");
    }
}
