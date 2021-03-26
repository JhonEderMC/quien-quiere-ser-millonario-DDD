package org.example.millonario.domain.juego.command;

import co.com.sofka.business.annotation.CommandHandles;
import co.com.sofka.business.annotation.CommandType;
import co.com.sofka.domain.generic.Command;
import org.example.millonario.domain.juego.values.RespuestaJugador;

public class CrearRespuestaJugador implements Command {
    private final RespuestaJugador respuestaJugador;

    public CrearRespuestaJugador(RespuestaJugador respuestaJugador) {
        this.respuestaJugador = respuestaJugador;
    }

    public RespuestaJugador getRespuestaJugador() {
        return respuestaJugador;
    }
}
