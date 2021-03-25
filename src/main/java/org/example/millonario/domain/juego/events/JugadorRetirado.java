package org.example.millonario.domain.juego.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.millonario.domain.juego.values.JugadorId;

public class JugadorRetirado extends DomainEvent {

    private final JugadorId jugadorId;


    public JugadorRetirado(JugadorId jugadorId) {
        super("millonario.jugador.jugadorretirado");
        this.jugadorId = jugadorId;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }

}
