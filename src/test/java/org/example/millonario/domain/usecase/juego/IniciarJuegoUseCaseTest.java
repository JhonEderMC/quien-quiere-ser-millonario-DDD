package org.example.millonario.domain.usecase.juego;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.millonario.domain.juego.JuegoIniciado;
import org.example.millonario.domain.juego.command.CrearPregunta;
import org.example.millonario.domain.juego.events.JuegoBase;
import org.example.millonario.domain.juego.events.JugadorCreado;
import org.example.millonario.domain.juego.events.PreguntaCreada;
import org.example.millonario.domain.juego.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class IniciarJuegoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    private JuegoId juegoId = JuegoId.of("juego1");

    @Test
    void iniciarJuego(){
        var eventTrigger = eventJugadorCreado();
        var useCase = new IniciarJuegoUseCase();

        Mockito.when(repository.getEventsBy(juegoId.value())).thenReturn(listEvent(juegoId));
        useCase.addRepository(repository);

        eventTrigger.setAggregateRootId(juegoId.value());

        var events = getDomainEvents(juegoId,eventTrigger, useCase);

        var juegoIniciado = (JuegoIniciado) events.get(0);
        Assertions.assertEquals(juegoId.value(), juegoIniciado.aggregateRootId());




    }

    private List<DomainEvent> getDomainEvents(JuegoId juegoId,JugadorCreado triggerEvent ,IniciarJuegoUseCase useCase) {
        return UseCaseHandler.getInstance()
                .setIdentifyExecutor(juegoId.value())
                .syncExecutor(useCase, new TriggeredEvent<>(triggerEvent))
                .orElseThrow()
                .getDomainEvents();
    }

    private List<DomainEvent> listEvent(JuegoId juegoId) {
        return List.of(
                new JuegoBase(juegoId, Nivel.of(2)),
                new JugadorCreado(JugadorId.of("jugador1"),
                        Nombre.of("Diego"),
                        Profesion.of("Descripcion jugador 1"),
                        TelefonoAyudaAmigo.of("13131313"),
                        Capital.of(0)),
                preguntaCreada()
        );
    }

    private PreguntaCreada preguntaCreada() {
        return new PreguntaCreada(
                PreguntaId.of("pregunta1"),
                Descripcion.of("descripcion1"),
                Set.of(new Respuesta(Descripcion.of("descripcion respuesta 1"), Estado.of(Boolean.FALSE)),
                        new Respuesta(Descripcion.of("descripcion respuesta 2"), Estado.of(Boolean.TRUE)),
                        new Respuesta(Descripcion.of("descripcion respuesta 3"), Estado.of(Boolean.FALSE)),
                        new Respuesta(Descripcion.of("descripcion respuesta 4"), Estado.of(Boolean.FALSE))                )
        );
    }

    private JugadorCreado eventJugadorCreado() {
        return  new JugadorCreado(
                JugadorId.of("jg1"),
                Nombre.of("Diego"),
                Profesion.of("saada"),
                TelefonoAyudaAmigo.of("dadad"),
                Capital.of(20)
        );
    }

}