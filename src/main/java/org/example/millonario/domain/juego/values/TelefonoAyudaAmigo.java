package org.example.millonario.domain.juego.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TelefonoAyudaAmigo implements ValueObject<String>{
    private final String value;

    public TelefonoAyudaAmigo(String telefono) {
        if(telefono.isBlank()){
            throw  new IllegalArgumentException("El telefono no puede ser vacio");
        }
        this.value = Objects.requireNonNull(telefono, "El telefono no puede ser nulo");
    }

    public static TelefonoAyudaAmigo of(String value) {
        return new TelefonoAyudaAmigo(value);
    }

    @Override
    public String value() {
        return this.value;
    }
}
