package org.example.millonario.domain.usecase.juego;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.millonario.domain.juego.Juego;
import org.example.millonario.domain.juego.JuegoIniciado;
import org.example.millonario.domain.juego.events.JugadorCreado;
import org.example.millonario.domain.juego.values.JuegoId;

public class IniciarJuegoUseCase extends UseCase<TriggeredEvent<JugadorCreado>, ResponseEvents> {


    @Override
    public void executeUseCase(TriggeredEvent<JugadorCreado> jugadorCreadoTriggeredEvent) {
        var event = jugadorCreadoTriggeredEvent.getDomainEvent();
        var juegoId = JuegoId.of(event.aggregateRootId());
        var juego = Juego.from(juegoId, retrieveEvents());

        juego.iniciarJuego(juegoId);

        emit().onResponse(new ResponseEvents(juego.getUncommittedChanges()));
    }
}
