package org.example.millonario.usecase.juego.handle;

import co.com.sofka.business.annotation.CommandHandles;
import co.com.sofka.business.annotation.CommandType;
import co.com.sofka.business.asyn.UseCaseExecutor;
import co.com.sofka.business.support.RequestCommand;
import org.example.millonario.domain.juego.command.CrearRespuestaJugador;
import org.example.millonario.domain.juego.values.JuegoId;
import org.example.millonario.domain.juego.values.RespuestaJugador;
import org.example.millonario.usecase.juego.CrearRespuestaJugadorUseCase;


import java.util.Map;
import java.util.Objects;

@CommandHandles
@CommandType(name = "millonario.juego.respuesta", aggregate = "juego")
public class CrearRespuestaJugadorHandle extends UseCaseExecutor {

    private RequestCommand<CrearRespuestaJugador> request;

    @Override
    public void run() {
        runUseCase(new CrearRespuestaJugadorUseCase(), request);
    }

    @Override
    public void accept(Map<String, String> args) {
        var respuesta = Objects.requireNonNull(args.get("respuesta").split(","));

        request = new RequestCommand<>(new CrearRespuestaJugador(
                JuegoId.of(aggregateId()),
                RespuestaJugador.of(Integer.valueOf(respuesta[0])))
        );
    }
}
