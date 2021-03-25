package org.example.millonario.domain.usecase.juego;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.millonario.domain.juego.Juego;
import org.example.millonario.domain.juego.command.CrearRespuestaJugador;
import org.example.millonario.domain.juego.events.JuegoBase;
import org.example.millonario.domain.juego.events.JugadorCreado;
import org.example.millonario.domain.juego.events.PreguntaCreada;
import org.example.millonario.domain.juego.events.RespuestaJugadorCreado;
import org.example.millonario.domain.juego.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearRespuestaJugadorUseCaseTest {

    @Mock
    DomainEventRepository repository;

    private JuegoId juegoId = JuegoId.of("xxx");

    @Test
    void crearRespuesta(){
        var command = new CrearRespuestaJugador( new RespuestaJugador(4));
        var useCase = new CrearRespuestaJugadorUseCase();

        Mockito.when(repository.getEventsBy(juegoId.value())).thenReturn(listEvent(juegoId));
        useCase.addRepository(repository);

        var events = getDomainEvents(juegoId, command, useCase);

         var respuestaJugador = (RespuestaJugadorCreado) events.get(0);

        Assertions.assertEquals(4, respuestaJugador.respuestaJugador().value());

    }

    @Test
    void errorCrearRespuesta(){
        Assertions.assertThrows(BusinessException.class, ()->{
            new CrearRespuestaJugador(new RespuestaJugador(7));
                } , "La respuesta debe estar entre 1 y 4"
        );
    }

    private List<DomainEvent> getDomainEvents(JuegoId juegoId,CrearRespuestaJugador commnand , CrearRespuestaJugadorUseCase useCase) {
        return UseCaseHandler.getInstance()
                .setIdentifyExecutor(juegoId.value())
                .syncExecutor(useCase, new RequestCommand<>(commnand))
                .orElseThrow()
                .getDomainEvents();
    }

    private List<DomainEvent> listEvent(JuegoId juegoId) {
        return List.of(
                new JuegoBase(juegoId, Nivel.of(2)),
                preguntaCreada(),
                new JugadorCreado(JugadorId.of("jugador1"),
                        Nombre.of("Diego"),
                        Profesion.of("Descripcion jugador 1"),
                        TelefonoAyudaAmigo.of("13131313"),
                        Capital.of(0))

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


}