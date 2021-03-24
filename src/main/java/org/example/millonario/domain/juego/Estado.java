package org.example.millonario.domain.juego;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Estado implements ValueObject<Boolean> {

    private final Boolean estado;

    public Estado(Boolean estado) {
        this.estado = Objects.requireNonNull(estado,"El estado es requerido");
    }

    public static Estado of(Boolean value) {
        return new Estado(value);
    }

    @Override
    public Boolean value() {
        return estado;
    }
}
