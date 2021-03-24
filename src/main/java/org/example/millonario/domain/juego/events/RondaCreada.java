package org.example.millonario.domain.juego.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.millonario.domain.juego.values.PreguntaId;

public class RondaCreada extends DomainEvent {
    private final RondaId rondaId;
    private final PreguntaId preguntaId;

    public RondaCreada(RondaId rondaId, PreguntaId preguntaId) {
        super("millonario.juego.rondacreada");
        this.rondaId = rondaId;
        this.preguntaId = preguntaId;
    }

    public RondaId rondaId() {
        return rondaId;
    }

    public PreguntaId preguntaId() {
        return preguntaId;
    }
}
