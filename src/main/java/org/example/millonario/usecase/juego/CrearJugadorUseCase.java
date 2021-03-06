package org.example.millonario.usecase.juego;

import co.com.sofka.business.annotation.EventListener;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.millonario.domain.juego.Juego;
import org.example.millonario.domain.juego.command.CrearJugador;
import org.example.millonario.domain.juego.values.JuegoId;


public class CrearJugadorUseCase extends UseCase<RequestCommand<CrearJugador>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearJugador> crearJugadorRequestCommand) {
        var command = crearJugadorRequestCommand.getCommand();

        var juego = Juego.from(command.juegoId(), retrieveEvents());
        juego.crearJugador(command.jugadorId(),command.nombre(),
                command.profesion(), command.telefonoAmigo(), command.capital()
        );

        emit().onResponse(new ResponseEvents(juego.getUncommittedChanges()));

    }
}
