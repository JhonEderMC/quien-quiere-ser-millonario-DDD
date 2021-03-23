package org.example.millonario.domain.juego;

import co.com.sofka.domain.generic.AggregateEvent;
import org.example.millonario.domain.juego.values.JuegoId;

public class Juego extends AggregateEvent<JuegoId> {

    protected  Jugador jugador;
    protected Map<RondaId, Ronda> rondas;
    protected Map<PreguntaId, Pregunta> pregunta;

    public Juego(JuegoId entityId) {
        super(entityId);
    }
}
