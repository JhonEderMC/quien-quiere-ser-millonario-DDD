package org.example.millonario.domain.juego.values;

import co.com.sofka.domain.generic.Identity;

public class RondaId extends Identity {
    public RondaId(String uuid) {
        super(uuid);
    }


    public static RondaId of(String value) {
        return new RondaId(value);
    }
}
