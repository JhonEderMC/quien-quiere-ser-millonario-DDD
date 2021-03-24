package org.example.millonario.domain.juego.events;

import co.com.sofka.domain.generic.Identity;
import org.example.millonario.domain.juego.Ronda;

public class RondaId extends Identity {
    public RondaId(String uuid) {
        super(uuid);
    }


    public static RondaId of(String value) {
        return new RondaId(value);
    }
}
