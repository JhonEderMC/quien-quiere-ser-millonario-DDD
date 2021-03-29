package org.example.millonario.usecase.juego;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.millonario.domain.juego.Juego;
import org.example.millonario.domain.juego.command.RetirarVoluntarioJugador;
import org.example.millonario.domain.juego.values.JuegoId;

public class RetirarVoluntarioJugadorUseCase extends UseCase<RequestCommand<RetirarVoluntarioJugador>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<RetirarVoluntarioJugador> retirarVoluntarioJugadorRequestCommand) {
        var command = retirarVoluntarioJugadorRequestCommand.getCommand();
        var juegoId = new JuegoId();

        var juego = Juego.from(juegoId, retrieveEvents());
        juego.retirarJugador(command.getJugadorId());

        emit().onResponse(new ResponseEvents(juego.getUncommittedChanges()));

    }
}
