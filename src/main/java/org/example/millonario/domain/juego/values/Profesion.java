package org.example.millonario.domain.juego.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Profesion implements ValueObject<String> {
    private final String value;

    public Profesion(String profesion) {
        if (profesion.isBlank()){
            throw new IllegalArgumentException("El nombre no puede ser en blanco");
        }
        this.value = Objects.requireNonNull(profesion, "El nombre no puede ser nulo");
    }

    public static Profesion of(String value) {
        return new Profesion(value);
    }

    @Override
    public String value() {
        return this.value;
    }
}
