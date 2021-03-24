package org.example.millonario.domain.juego.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {

    private final String descripcion;

    public Descripcion(String descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion, "La descripción es requerida");
    }

    public static Descripcion of(String descripcion) {
        return new Descripcion(descripcion);
    }

    @Override
    public String value() {
        return descripcion;
    }
}
