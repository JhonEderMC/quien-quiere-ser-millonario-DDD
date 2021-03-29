package org.example.millonario.usecase.juego.handle;

import co.com.sofka.business.annotation.CommandHandles;
import co.com.sofka.business.annotation.CommandType;
import co.com.sofka.business.asyn.UseCaseExecutor;
import co.com.sofka.business.support.RequestCommand;
import org.example.millonario.domain.juego.command.CrearJugador;
import org.example.millonario.domain.juego.values.*;

import org.example.millonario.usecase.juego.CrearJugadorUseCase;

import java.util.Map;
import java.util.Objects;

@CommandHandles
@CommandType(name = "millonario.juego.crearjugador", aggregate = "juego")
public class CrearJugadorHandle extends UseCaseExecutor {

    private RequestCommand<CrearJugador> request;

    @Override
    public void run() {
        runUseCase(new CrearJugadorUseCase(), request);
    }

    @Override
    public void accept(Map<String, String> args) {

        var jugadorId = Objects.requireNonNull(args.get("jugadorId").split(","));
        var  nombre = Objects.requireNonNull(args.get("nombre").split(","));
        var  profesion = Objects.requireNonNull(args.get("profesion").split(","));
        var telefono = Objects.requireNonNull(args.get("telefono").split(","));
        var capit = Objects.requireNonNull(args.get("capital").split(","));
        var capital = Capital.of(Integer.valueOf(capit[0]));

        request = new RequestCommand<>(
              new  CrearJugador(JuegoId.of(aggregateId()), JugadorId.of(jugadorId[0]), Nombre.of(nombre[0]),
                        Profesion.of(profesion[0]), TelefonoAyudaAmigo.of(telefono[0]),
                        capital)
        );
    }
}
