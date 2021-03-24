package org.example.millonario.domain.juego.values;

import co.com.sofka.domain.generic.Identity;

public class PreguntaId extends Identity {
    public PreguntaId(String uuid) {
        super(uuid);
    }

    public static PreguntaId of(String value) {
        return new PreguntaId(value);
    }
}
