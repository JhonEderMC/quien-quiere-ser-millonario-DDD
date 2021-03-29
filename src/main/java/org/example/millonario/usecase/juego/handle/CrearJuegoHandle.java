package org.example.millonario.usecase.juego.handle;

import co.com.sofka.business.annotation.CommandHandles;
import co.com.sofka.business.annotation.CommandType;
import co.com.sofka.business.asyn.UseCaseExecutor;
import co.com.sofka.business.support.RequestCommand;
import org.example.millonario.domain.juego.command.CrearJuegoBase;
import org.example.millonario.domain.juego.values.JuegoId;
import org.example.millonario.domain.juego.values.Nivel;
import org.example.millonario.usecase.juego.CrearJuegoBaseUseCase;

import java.util.Map;
import java.util.Objects;

@CommandHandles
@CommandType(name = "millonario.juego.crear", aggregate = "juego")
public class CrearJuegoHandle extends UseCaseExecutor {

    private RequestCommand<CrearJuegoBase> request;

    @Override
    public void run() {
        runUseCase(new CrearJuegoBaseUseCase(), request);
    }

    @Override
    public void accept(Map<String, String> args) {

        var text = Objects.requireNonNull(args.get("nivel").split(","));
        var nivel = Integer.valueOf(text[0]);

        request = new RequestCommand<>(new CrearJuegoBase(Nivel.of(nivel), JuegoId.of(aggregateId())));

    }
}
