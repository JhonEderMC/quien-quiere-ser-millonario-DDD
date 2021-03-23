package org.example.millonario.domain.juego.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {
    private final String value;

    public Nombre(String nombre) {
        if (nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede ser en blanco");
        }
        this.value = Objects.requireNonNull(nombre, "El nombre no puede ser nulo");
    }

    public String nombre() {
        return value;
    }

    @Override
    public String value() {
        return this.value;
    }
}
