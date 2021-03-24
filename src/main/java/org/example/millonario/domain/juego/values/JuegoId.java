package org.example.millonario.domain.juego.values;

import co.com.sofka.domain.generic.Identity;

public class JuegoId  extends Identity {

    public JuegoId(String uuid) {
        super(uuid);
    }

    public JuegoId() {
    }

    public static JuegoId of(String value) {
        return new JuegoId(value);
    }
}
