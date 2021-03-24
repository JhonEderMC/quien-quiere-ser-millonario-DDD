package org.example.millonario.domain.juego;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.millonario.domain.juego.values.JuegoId;

public class JuegoIniciado extends DomainEvent {
    private final JuegoId juegoId;

    public JuegoIniciado(JuegoId juegoId) {
        super("millonario.juego.juegoiniciado");
        this.juegoId = juegoId;
    }

    public JuegoId juegoId() {
        return juegoId;
    }
}
