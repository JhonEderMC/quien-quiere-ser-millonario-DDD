package org.example.millonario.domain.juego.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.millonario.domain.juego.values.*;

public class JugadorCreado extends DomainEvent {
    private final JugadorId jugadorId;
    private final Nombre nombre;
    private final Profesion profesion;
    private final TelefonoAyudaAmigo telefonoAmigo;
    private final Capital capital;

    public JugadorCreado(JugadorId jugadorId, Nombre nombre, Profesion profesion, TelefonoAyudaAmigo telefonoAmigo, Capital capital) {
        super("millonario.juego.jugadorcreado");
        this.jugadorId = jugadorId;
        this.nombre = nombre;
        this.profesion = profesion;
        this.telefonoAmigo = telefonoAmigo;
        this.capital = capital;
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
