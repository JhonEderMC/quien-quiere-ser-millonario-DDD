package org.example.millonario.domain.juego.command;

import co.com.sofka.business.annotation.CommandHandles;
import co.com.sofka.business.annotation.CommandType;
import co.com.sofka.domain.generic.Command;
import org.example.millonario.domain.juego.values.JuegoId;
import org.example.millonario.domain.juego.values.RespuestaJugador;

public class CrearRespuestaJugador implements Command {
    private final JuegoId juegoId;
    private final RespuestaJugador respuestaJugador;

    public CrearRespuestaJugador(JuegoId juegoId, RespuestaJugador respuestaJugador) {
        this.juegoId = juegoId;
        this.respuestaJugador = respuestaJugador;
    }

    public RespuestaJugador getRespuestaJugador() {
        return respuestaJugador;
    }
}
