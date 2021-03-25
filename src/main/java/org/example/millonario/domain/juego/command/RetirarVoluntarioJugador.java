package org.example.millonario.domain.juego.command;

import co.com.sofka.domain.generic.Command;
import org.example.millonario.domain.juego.values.JuegoId;
import org.example.millonario.domain.juego.values.JugadorId;

public class RetirarVoluntarioJugador implements Command {
    private JugadorId jugadorId;
    private final JuegoId juegoId;

    public RetirarVoluntarioJugador(JugadorId jugadorId, JuegoId juegoId) {
        this.jugadorId = jugadorId;
        this.juegoId = juegoId;
    }

    public JugadorId getJugadorId() {
        return jugadorId;
    }

    public JuegoId getJuegoId() {
        return juegoId;
    }
}
