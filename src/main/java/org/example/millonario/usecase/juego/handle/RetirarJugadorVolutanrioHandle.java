package org.example.millonario.usecase.juego.handle;

import co.com.sofka.business.annotation.CommandHandles;
import co.com.sofka.business.annotation.CommandType;
import co.com.sofka.business.asyn.UseCaseExecutor;
import co.com.sofka.business.support.RequestCommand;
import org.example.millonario.domain.juego.command.RetirarVoluntarioJugador;
import org.example.millonario.domain.juego.values.JuegoId;
import org.example.millonario.domain.juego.values.JugadorId;
import org.example.millonario.usecase.juego.RetirarVoluntarioJugadorUseCase;

import java.util.Map;
import java.util.Objects;

@CommandHandles
@CommandType(name = "millonario.juego.retirar", aggregate = "juego")
public class RetirarJugadorVolutanrioHandle extends UseCaseExecutor  {
    private RequestCommand<RetirarVoluntarioJugador> request;

    @Override
    public void run() {
        runUseCase(new RetirarVoluntarioJugadorUseCase(), request);
    }

    @Override
    public void accept(Map<String, String> args) {
        var jugadorId = Objects.requireNonNull(args.get("jugadorId").split(","));
        var juegoId = Objects.requireNonNull(args.get("juegoId").split(","));

        request = new RequestCommand<>(new RetirarVoluntarioJugador(JugadorId.of(jugadorId[0]), JuegoId.of(juegoId[0])));
    }
}
