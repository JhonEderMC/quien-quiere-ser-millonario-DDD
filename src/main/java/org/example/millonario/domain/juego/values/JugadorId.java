package org.example.millonario.domain.juego.values;

import co.com.sofka.domain.generic.Identity;

public class JugadorId extends Identity {

    public JugadorId(String uuid) {
        super(uuid);
    }

    public static JugadorId of(String value) {
        return new JugadorId(value);
    }
}
