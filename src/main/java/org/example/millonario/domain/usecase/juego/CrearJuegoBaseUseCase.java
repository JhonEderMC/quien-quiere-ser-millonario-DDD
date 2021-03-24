package org.example.millonario.domain.usecase.juego;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.millonario.domain.juego.Juego;
import org.example.millonario.domain.juego.command.CrearJuegoBase;
import org.example.millonario.domain.juego.values.JuegoId;

public class CrearJuegoBaseUseCase extends UseCase<RequestCommand<CrearJuegoBase>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearJuegoBase> crearJuegoBaseRequestCommand) {
        var command = crearJuegoBaseRequestCommand.getCommand();
        var juegoId = new JuegoId();

         var juego = new Juego(juegoId, command.nivel() );
         emit().onResponse(new ResponseEvents(juego.getUncommittedChanges()));
    }
}
