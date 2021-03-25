package org.example.millonario.domain.juego.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Retirado implements ValueObject<Boolean> {

    public Boolean retirado;

    public Retirado(Boolean retirado) {
        this.retirado = Objects.requireNonNull(retirado, "Retirado es requerido");
    }

    public static Retirado of(Boolean value) {
        return new Retirado(value);
    }

    @Override
    public Boolean value() {
        return retirado;
    }
}
