package org.example;

public enum Categoria {
        MEJOR_AMIGO,
        TRABAJO,
        AMIGO,
        CONOCIDO,
        FAMILIAR;


@Override
public String toString() {
        // Esto cambia "MEJOR_AMIGO" por "MEJOR AMIGO"
        return name().replace('_', ' ');
}
        }