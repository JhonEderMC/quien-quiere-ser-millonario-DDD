package org.example.millonario.domain.usecase.juego;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.millonario.domain.juego.Juego;
import org.example.millonario.domain.juego.JuegoIniciado;
import org.example.millonario.domain.juego.events.PreguntaCreada;
import org.example.millonario.domain.juego.events.RondaId;
import org.example.millonario.domain.juego.values.JuegoId;


public class CrearRondaUseCase extends UseCase<TriggeredEvent<PreguntaCreada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<PreguntaCreada> preguntaCreadaTriggeredEvent) {
        var event = preguntaCreadaTriggeredEvent.getDomainEvent();
        var juegoId = JuegoId.of(event.aggregateRootId());

        var juego = Juego.from(juegoId, retrieveEvents());

        juego.crearRonda(RondaId.of(event.preguntaId().value()), event.preguntaId());

        emit().onResponse(new ResponseEvents(juego.getUncommittedChanges()));


    }
}
