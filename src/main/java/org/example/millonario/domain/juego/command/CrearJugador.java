package org.example.millonario.domain.juego.command;

import co.com.sofka.domain.generic.Command;
import org.example.millonario.domain.juego.values.*;

public class CrearJugador implements Command {

    private final JugadorId jugadorId;
    private final Nombre nombre;
    private final Profesion profesion;
    private final TelefonoAyudaAmigo telefonoAmigo;
    private final Capital capital;
    private final JuegoId juegoId;

    public CrearJugador(JuegoId juegoId, JugadorId jugadorId, Nombre nombre, Profesion profesion, TelefonoAyudaAmigo telefonoAmigo, Capital capital) {
        this.juegoId = juegoId;
        this.jugadorId = jugadorId;
        this.nombre = nombre;
        this.profesion = profesion;
        this.telefonoAmigo = telefonoAmigo;
        this.capital = capital;
    }

    public JuegoId juegoId() {
        return juegoId;
    }

    public JugadorId jugadorId() {
        return jugadorId;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Profesion profesion() {
        return profesion;
    }

    public TelefonoAyudaAmigo telefonoAmigo() {
        return telefonoAmigo;
    }

    public Capital capital() {
        return capital;
    }
}
