package org.example.millonario.domain.juego;

import co.com.sofka.domain.generic.Entity;
import org.example.millonario.domain.juego.values.*;

public class Jugador extends Entity<JugadorId> {

    private final Nombre nombre;
    private final Profesion profesion;
    private final TelefonoAyudaAmigo telefonoAmigo;
    private Capital capital;
    private Integer posicion;
    private Retirado retirado;

    public Jugador(JugadorId entityId, Nombre nombre, Profesion profesion, TelefonoAyudaAmigo telefonoAmigo, Capital capital) {
        super(entityId);
        this.nombre = nombre;
        this.profesion = profesion;
        this.telefonoAmigo = telefonoAmigo;
        this.capital = capital;
        this.posicion=0;
        this.retirado = Retirado.of(Boolean.FALSE);
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

    public Integer posicion() {
        return posicion;
    }

    public void aumentarPosicion(){
        this.posicion++;
    }

    public void retirarJugador(){
        this.retirado = Retirado.of(Boolean.TRUE);
    }
}
