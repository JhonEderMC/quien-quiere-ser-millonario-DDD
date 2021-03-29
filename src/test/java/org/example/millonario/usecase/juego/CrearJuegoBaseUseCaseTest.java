package org.example.millonario.usecase.juego;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.example.millonario.domain.juego.command.CrearJuegoBase;
import org.example.millonario.domain.juego.events.JuegoBase;
import org.example.millonario.domain.juego.values.JuegoId;
import org.example.millonario.domain.juego.values.Nivel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearJuegoBaseUseCaseTest {

    @Test
    void crearJuegoBase(){
        var comammd = new CrearJuegoBase(Nivel.of(3), JuegoId.of("juego1"));
        var useCase = new CrearJuegoBaseUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(comammd))
                .orElseThrow()
                .getDomainEvents();

        var juegoBase = (JuegoBase) events.get(0);

        Assertions.assertEquals(3, juegoBase.nivel().value());

    }


}