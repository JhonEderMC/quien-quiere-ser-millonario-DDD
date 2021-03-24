package org.example.millonario.domain.juego.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.millonario.domain.juego.Respuesta;
import org.example.millonario.domain.juego.values.Descripcion;
import org.example.millonario.domain.juego.values.PreguntaId;

import java.util.Set;

public class PreguntaCreada extends DomainEvent {

    private final PreguntaId preguntaId;
    private final Descripcion descripcion;
    private final Set<Respuesta> respuestas;

    public PreguntaCreada(PreguntaId preguntaId, Descripcion descripcion, Set<Respuesta> respuestas) {
        super("millonario.juego.preguntacreada");
        this.preguntaId = preguntaId;
        this.descripcion = descripcion;
        this.respuestas = respuestas;
    }

    public PreguntaId preguntaId() {
        return preguntaId;
    }

    public Descripcion descripcion() {
        return descripcion;
    }

    public Set<Respuesta> respuestas() {
        return respuestas;
    }
}
