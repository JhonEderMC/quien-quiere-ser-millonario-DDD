package org.example.millonario.domain.usecase.juego;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.millonario.domain.juego.Juego;
import org.example.millonario.domain.juego.command.CrearRespuestaJugador;
import org.example.millonario.domain.juego.values.JuegoId;

public class CrearRespuestaJugadorUseCase extends UseCase<RequestCommand<CrearRespuestaJugador>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearRespuestaJugador> crearRespuestaJugadorRequestCommand) {
        var command = crearRespuestaJugadorRequestCommand.getCommand();
        var respuesta = command.getRespuestaJugador();
        var juegoId = new JuegoId();
        var juego = Juego.from(juegoId, retrieveEvents());

        juego.crearRespuesta(respuesta);

        emit().onResponse(new ResponseEvents(juego.getUncommittedChanges()));


    }
}
