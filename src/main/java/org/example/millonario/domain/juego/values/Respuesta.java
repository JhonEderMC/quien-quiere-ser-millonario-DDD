package org.example.millonario.domain.juego.values;

import co.com.sofka.domain.generic.ValueObject;

public class Respuesta implements ValueObject<Respuesta.Value> {

    private final Descripcion descripcion;
    private final Estado estado;

    public Respuesta(Descripcion descripcion, Estado estado) {
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public static Respuesta of (Descripcion descripcion, Estado estado){
        return  new Respuesta(descripcion, estado);
    }

    @Override
    public Value value() {
        return new Value() {
            @Override
            public Descripcion descripcion() {
                return descripcion;
            }

            @Override
            public Estado estado() {
                return estado;
            }
        };
    }

    public interface Value{
        Descripcion descripcion();
        Estado estado();
    }
}
