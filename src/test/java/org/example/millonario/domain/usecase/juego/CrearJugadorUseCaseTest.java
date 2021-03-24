package org.example.millonario.domain.usecase.juego;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.millonario.domain.juego.Juego;
import org.example.millonario.domain.juego.command.CrearJugador;
import org.example.millonario.domain.juego.events.JuegoBase;
import org.example.millonario.domain.juego.events.JugadorCreado;
import org.example.millonario.domain.juego.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.logging.Handler;


@ExtendWith(MockitoExtension.class)
class CrearJugadorUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearJugador(){
        var juegoId = JuegoId.of("juego1");
        var command = new CrearJugador(
                JugadorId.of("jugador1"), Nombre.of("daniel"),
                Profesion.of("cantante"), TelefonoAyudaAmigo.of("1313131"),
                Capital.of(300));
        var useCase = new CrearJugadorUseCase();

        Mockito.when(repository.getEventsBy(juegoId.value())).thenReturn(listEvent(juegoId));
        useCase.addRepository(repository);

        var juego = Juego.from(juegoId, listEvent(juegoId));

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(juegoId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var jugadorCreado = (JugadorCreado) events.get(0);
        Assertions.assertEquals("jugador1", jugadorCreado.jugadorId().value());
        Assertions.assertEquals("daniel", jugadorCreado.nombre().value());
        Assertions.assertEquals(300, jugadorCreado.capital().value());

    }

    private List<DomainEvent> listEvent(JuegoId juegoId) {
        return List.of(new JuegoBase(juegoId, Nivel.of(2)));
    }


}