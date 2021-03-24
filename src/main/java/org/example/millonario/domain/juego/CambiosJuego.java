package org.example.millonario.domain.juego;

import co.com.sofka.domain.generic.EventChange;
import org.example.millonario.domain.juego.events.JuegoBase;
import org.example.millonario.domain.juego.events.JugadorCreado;
import org.example.millonario.domain.juego.events.PreguntaCreada;

import java.util.HashMap;

public class CambiosJuego extends EventChange {
    public CambiosJuego(Juego juego) {
        apply((JuegoBase event)->{
            juego.juegoInicializado=Boolean.FALSE;
            juego.nivel = event.nivel();
            juego.preguntas = new HashMap<>();
            juego.rondas = new HashMap<>();
        });
        apply((JugadorCreado event)->{
            juego.jugador = new Jugador(
                    event.jugadorId(), event.nombre(), event.profesion(), event.telefonoAmigo(),
                    event.capital()
            );
        });
        apply((PreguntaCreada event)->{
            juego.preguntas.put(
                    event.preguntaId(),
                    new Pregunta(event.preguntaId(), event.descripcion(), event.respuestas())
            );
        });
    }
}
