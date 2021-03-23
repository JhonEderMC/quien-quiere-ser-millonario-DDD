package org.example.millonario.domain.juego;

import co.com.sofka.domain.generic.Entity;
import org.example.millonario.domain.juego.values.*;

public class Jugador extends Entity<JugadorId> {

    private final Nombre nombre;
    private final Profesion profesion;
    private final TelefonoAyudaAmigo telefonoAmigo;
    private Capital capital;

    public Jugador(JugadorId entityId, Nombre nombre, Profesion profesion, TelefonoAyudaAmigo telefonoAmigo, Capital capital) {
        super(entityId);
        this.nombre = nombre;
        this.profesion = profesion;
        this.telefonoAmigo = telefonoAmigo;
        this.capital = capital;
    }

    public void aumentarCapital(Capital capital){
        this.capital = this.capital.aumentar(capital.value());
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
