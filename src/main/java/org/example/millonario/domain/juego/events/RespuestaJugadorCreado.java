package org.example.millonario.domain.juego.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.millonario.domain.juego.values.RespuestaJugador;

public class RespuestaJugadorCreado extends DomainEvent {

    private final RespuestaJugador respuestaJugador;

    public RespuestaJugadorCreado(RespuestaJugador respuestaJugador) {
        super("millonario.juego.respuestajugadorcreado");
        this.respuestaJugador = respuestaJugador;
    }

    public RespuestaJugador respuestaJugador() {
        return respuestaJugador;
    }
}
