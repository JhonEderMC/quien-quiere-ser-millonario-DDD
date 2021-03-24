package org.example.millonario.domain.juego;

import co.com.sofka.domain.generic.Entity;
import org.example.millonario.domain.juego.values.Descripcion;
import org.example.millonario.domain.juego.values.PreguntaId;

import java.util.Set;

public class Pregunta extends Entity<PreguntaId> {

    private final PreguntaId preguntaId;
    private final Descripcion descripcion;
    private final Set<Respuesta> respuestas;

    public Pregunta(PreguntaId preguntaId, Descripcion descripcion, Set<Respuesta> respuestas) {
        super(preguntaId);
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

    public Set<Respuesta> respuestasSet() {
        return respuestas;
    }
}
