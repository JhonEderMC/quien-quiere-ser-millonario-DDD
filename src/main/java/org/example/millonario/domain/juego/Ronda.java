package org.example.millonario.domain.juego;

import co.com.sofka.domain.generic.Entity;
import org.example.millonario.domain.juego.events.Puntaje;
import org.example.millonario.domain.juego.events.RondaId;
import org.example.millonario.domain.juego.values.JugadorId;
import org.example.millonario.domain.juego.values.PreguntaId;

public class Ronda extends Entity<RondaId> {

    private static final Integer DEFAULT_VALUE=0;


    private final PreguntaId preguntaId;
    private Puntaje puntaje;

    public Ronda(RondaId entityId, PreguntaId preguntaId) {
        super(entityId);
        this.preguntaId = preguntaId;
        this.puntaje= Puntaje.of(DEFAULT_VALUE);
    }

    public PreguntaId preguntaId() {
        return preguntaId;
    }

    public Puntaje puntaje() {
        return puntaje;
    }
}