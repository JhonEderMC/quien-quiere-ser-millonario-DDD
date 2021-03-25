package org.example.millonario.domain.juego;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.millonario.domain.juego.events.*;
import org.example.millonario.domain.juego.values.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Juego extends AggregateEvent<JuegoId> {

    protected Jugador jugador;
    protected Map<RondaId, Ronda> rondas;
    protected Map<PreguntaId, Pregunta> preguntas;
    protected Boolean juegoInicializado;
    protected Nivel nivel;


    public Juego(JuegoId juegoId,Nivel nivel) {
        super(juegoId);
        appendChange(new JuegoBase(juegoId,nivel)).apply();
    }

    private Juego(JuegoId juegoId) {
        super(juegoId);
        subscribe(new CambiosJuego(this));
    }

    public static Juego from(JuegoId juegoId, List<DomainEvent> eventList) {
        var juego = new Juego(juegoId);
        eventList.forEach(juego::applyEvent);
        return juego;
    }

    public void crearJugador(JugadorId jugadorId, Nombre nombre, Profesion profesion, TelefonoAyudaAmigo telefonoAmigo,Capital capital){
        appendChange(new JugadorCreado(jugadorId, nombre, profesion, telefonoAmigo,capital)).apply();
    }

    public void agregarPregunta(PreguntaId preguntaId, Descripcion descripcion, Set<Respuesta> respuestas ){
        appendChange(new PreguntaCreada(preguntaId,descripcion, respuestas)).apply();
        crearRonda(RondaId.of(preguntaId.value()), preguntaId);
    }

    public void iniciarJuego(JuegoId juegoId){
        appendChange(new JuegoIniciado(juegoId)).apply();
    }

    public void crearRonda(RondaId rondaId,PreguntaId preguntaId ){
        appendChange(new RondaCreada( rondaId, preguntaId)).apply();
    }

    public void crearRespuesta(RespuestaJugador respuesta){
        appendChange(new RespuestaJugadorCreado(respuesta)).apply();
    }

    public void retirarJugador(JugadorId jugadorId) {
        appendChange( new JugadorRetirado(jugadorId)).apply();
    }
}
