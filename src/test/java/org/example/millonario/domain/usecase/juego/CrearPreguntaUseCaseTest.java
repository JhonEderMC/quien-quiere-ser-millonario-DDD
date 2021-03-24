package org.example.millonario.domain.usecase.juego;


import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.millonario.domain.juego.Estado;
import org.example.millonario.domain.juego.Juego;
import org.example.millonario.domain.juego.Respuesta;
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

import java.util.Collections;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class CrearPreguntaUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void crearPregunta(){
        var juegoId = JuegoId.of("xxx");
        var command = crearCommand();

        var useCase = new CrearPreguntaUseCase();

        Mockito.when(repository.getEventsBy(juegoId.value())).thenReturn(listEvent(juegoId));
        useCase.addRepository(repository);

        var juego = Juego.from(juegoId, listEvent(juegoId));
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(juegoId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var preguntaCreada = (PreguntaCreada) events.get(0);
        Assertions.assertEquals("pregunta1", preguntaCreada.preguntaId().value());
        Assertions.assertEquals("descripcion1",preguntaCreada.descripcion().value());
        Assertions.assertEquals(4,  preguntaCreada.respuestas().size());
    }

    @Test
   void errorAlCrearPregunta(){
        var juegoId = JuegoId.of("xxx");
        var command = crearCommandError();

        var useCase = new CrearPreguntaUseCase();

        Mockito.when(repository.getEventsBy(juegoId.value())).thenReturn(listEvent(juegoId));
        useCase.addRepository(repository);

        var juego = Juego.from(juegoId, listEvent(juegoId));

        Assertions.assertThrows(BusinessException.class, ()->{
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(juegoId.value())
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow()
                    .getDomainEvents();
            }, "Deben haber 4 respuestas");

    }

    private List<DomainEvent> listEvent(JuegoId juegoId) {
        return List.of(
                new JuegoBase(juegoId, Nivel.of(2)),
                new JugadorCreado(JugadorId.of("jugador1"),
                        Nombre.of("Diego"),
                        Profesion.of("Descripcion jugador 1"),
                        TelefonoAyudaAmigo.of("13131313"),
                        Capital.of(0)));
    }

    private CrearPregunta crearCommand() {
        return new CrearPregunta(
                PreguntaId.of("pregunta1"),
                Descripcion.of("descripcion1"),
                Set.of(new Respuesta(Descripcion.of("descripcion respuesta 1"), Estado.of(Boolean.FALSE)),
                       new Respuesta(Descripcion.of("descripcion respuesta 2"), Estado.of(Boolean.TRUE)),
                       new Respuesta(Descripcion.of("descripcion respuesta 3"), Estado.of(Boolean.FALSE)),
                       new Respuesta(Descripcion.of("descripcion respuesta 4"), Estado.of(Boolean.FALSE))                )
        );
    }

    private CrearPregunta crearCommandError() {
        return new CrearPregunta(
                PreguntaId.of("pregunta1"),
                Descripcion.of("descripcion1"),
                Set.of(new Respuesta(Descripcion.of("descripcion respuesta 1"), Estado.of(Boolean.FALSE)),
                        new Respuesta(Descripcion.of("descripcion respuesta 2"), Estado.of(Boolean.TRUE))                                      )
        );
    }

}