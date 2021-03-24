package org.example.millonario.domain.usecase.juego;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.millonario.domain.juego.Juego;
import org.example.millonario.domain.juego.command.CrearPregunta;
import org.example.millonario.domain.juego.values.JuegoId;
import org.example.millonario.domain.juego.values.JugadorId;

public class CrearPreguntaUseCase extends UseCase<RequestCommand<CrearPregunta>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearPregunta> crearPreguntaRequestCommand) {
        var command = crearPreguntaRequestCommand.getCommand();
        var juegoId = new JuegoId();

        if(command.respuestas().size()!=4){
            throw new BusinessException(CrearPreguntaUseCase.class.toString(), "Deben haber 4 respuestas");
        }

        var juego = Juego.from(juegoId, retrieveEvents());
        juego.agregarPregunta(command.preguntaId(), command.descripcion(), command.respuestas());

        emit().onResponse(new ResponseEvents(juego.getUncommittedChanges()));
    }
}
