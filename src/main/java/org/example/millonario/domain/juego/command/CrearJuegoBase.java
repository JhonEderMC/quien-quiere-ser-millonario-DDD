package org.example.millonario.domain.juego.command;

import co.com.sofka.domain.generic.Command;
import org.example.millonario.domain.juego.values.JuegoId;
import org.example.millonario.domain.juego.values.Nivel;

public class CrearJuegoBase implements Command {

    private  final Nivel nivel;

    public CrearJuegoBase(Nivel nivel) {
        this.nivel = nivel;
    }

    public Nivel nivel() {
        return nivel;
    }
}
