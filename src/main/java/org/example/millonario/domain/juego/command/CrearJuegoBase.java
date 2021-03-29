package org.example.millonario.domain.juego.command;

import co.com.sofka.domain.generic.Command;
import org.example.millonario.domain.juego.values.JuegoId;
import org.example.millonario.domain.juego.values.Nivel;

public class CrearJuegoBase implements Command {

    private  final Nivel nivel;

    public CrearJuegoBase(Nivel nivel, JuegoId juegoId) {
        this.nivel = nivel;
        this.juegoId = juegoId;
    }

    private final JuegoId juegoId;

    public JuegoId juegoId() {
        return juegoId;
    }

    public Nivel nivel() {
        return nivel;
    }
}
