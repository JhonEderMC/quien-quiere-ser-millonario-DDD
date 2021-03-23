package org.example.millonario.domain.juego.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.millonario.domain.juego.values.JuegoId;
import org.example.millonario.domain.juego.values.Nivel;

public class JuegoBase extends DomainEvent {
    private final JuegoId juegoId;
    private final Nivel nivel;

    public JuegoBase(JuegoId juegoId, Nivel nivel) {
        super("millonario.juego.juegobase");
        this.juegoId = juegoId;
        this.nivel = nivel;
    }

    public JuegoId juegoId() {
        return juegoId;
    }

    public Nivel nivel() {
        return nivel;
    }
}
