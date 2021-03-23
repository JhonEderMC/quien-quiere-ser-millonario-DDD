package org.example.millonario.domain.juego.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nivel implements ValueObject<Integer> {
    private final Integer nivel;

    public Nivel(Integer nivel) {
        if(nivel<0){
            throw new  IllegalArgumentException("El nivel tiene que ser un numero mayor a 0");
        }
        if(nivel>5){
            throw new  IllegalArgumentException("El nivel maximo es 5");
        }
        this.nivel = Objects.requireNonNull(nivel, "El nivel es requerido");
    }
    public Nivel(){
        this.nivel=1; //por defecto
    }

    public static Nivel of(int i) {
        return new Nivel(i);
    }

    public Integer nivel() {
        return nivel;
    }

    @Override
    public Integer value() {
        return this.nivel;
    }
}
