package org.example.millonario.domain.juego.values;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class RespuestaJugador implements ValueObject<Integer> {

    private final Integer respuesta;

    public RespuestaJugador(Integer respuesta) {
        if(!(respuesta >0 && respuesta <5)){
            throw new BusinessException(respuesta.toString(), "La respuesta debe estar entre 1 y 4");
        }
        this.respuesta = Objects.requireNonNull(respuesta, "La respuesta es requerida");
    }

    public static RespuestaJugador of(Integer value) {
        return new RespuestaJugador(value);
    }

    @Override
    public Integer value() {
        return respuesta;
    }
}
