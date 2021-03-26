package org.example.millonario.domain.juego.values;

import co.com.sofka.domain.generic.ValueObject;

public class Puntaje implements ValueObject<Integer> {

    public Puntaje(Integer puntaje) {
        Puntaje = puntaje;
    }

    private final Integer Puntaje;

    public static Puntaje of(Integer value){
        return new Puntaje(value);
    }

    @Override
    public Integer value() {
        return Puntaje;
    }
}
