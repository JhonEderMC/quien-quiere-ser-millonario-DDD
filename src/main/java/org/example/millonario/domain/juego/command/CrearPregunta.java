package org.example.millonario.domain.juego.command;

import co.com.sofka.domain.generic.Command;
import org.example.millonario.domain.juego.values.JuegoId;
import org.example.millonario.domain.juego.values.Respuesta;
import org.example.millonario.domain.juego.values.Descripcion;
import org.example.millonario.domain.juego.values.PreguntaId;

import java.util.Set;

public class CrearPregunta implements Command {

    private final PreguntaId preguntaId;
    private final Descripcion descripcion;
    private final Set<Respuesta> respuestas;
    private final JuegoId juegoId;



    public CrearPregunta(JuegoId juegoId, PreguntaId preguntaId, Descripcion descripcion, Set<Respuesta> respuestas) {
        this.juegoId = juegoId;
        this.preguntaId = preguntaId;
        this.descripcion = descripcion;
        this.respuestas = respuestas;
    }

    public JuegoId juegoId() {
        return juegoId;
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
