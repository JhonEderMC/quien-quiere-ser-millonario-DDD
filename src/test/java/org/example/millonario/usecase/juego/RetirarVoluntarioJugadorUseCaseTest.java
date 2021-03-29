package org.example.millonario.usecase.juego;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.millonario.domain.juego.command.RetirarVoluntarioJugador;
import org.example.millonario.domain.juego.events.JuegoBase;
import org.example.millonario.domain.juego.events.JugadorCreado;
import org.example.millonario.domain.juego.events.JugadorRetirado;
import org.example.millonario.domain.juego.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class RetirarVoluntarioJugadorUseCaseTest {

    @Mock
    DomainEventRepository repository;

    private JuegoId juegoId = JuegoId.of("xxx");
    
    @Test
    void retirarJugador(){
        var command = new RetirarVoluntarioJugador(JugadorId.of("jg1"), juegoId);
        var useCase = new RetirarVoluntarioJugadorUseCase();

        Mockito.when(repository.getEventsBy(juegoId.value())).thenReturn(listEvent(juegoId));
        useCase.addRepository(repository);

        var events = getDomainEvents(juegoId, command, useCase);

        var jugadorRetirado = (JugadorRetirado) events.get(0);

        Assertions.assertEquals("jg1", jugadorRetirado.getJugadorId().value());

    }

    private List<DomainEvent> getDomainEvents(JuegoId juegoId, RetirarVoluntarioJugador command, RetirarVoluntarioJugadorUseCase useCase) {
        return UseCaseHandler.getInstance()
                .setIdentifyExecutor(juegoId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
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
                        Capital.of(0))

        );
    }



}