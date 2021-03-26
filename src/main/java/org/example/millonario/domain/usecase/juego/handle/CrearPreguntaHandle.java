package org.example.millonario.domain.usecase.juego.handle;

import co.com.sofka.business.asyn.UseCaseExecutor;
import co.com.sofka.business.support.RequestCommand;
import org.example.millonario.domain.juego.command.CrearPregunta;
import org.example.millonario.domain.juego.values.Descripcion;
import org.example.millonario.domain.juego.values.Estado;
import org.example.millonario.domain.juego.values.Respuesta;
import org.example.millonario.domain.usecase.juego.CrearPreguntaUseCase;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class CrearPreguntaHandle extends UseCaseExecutor {

    private RequestCommand<CrearPregunta> request;

    @Override
    public void run() {
        runUseCase(new CrearPreguntaUseCase(), request);
    }

    @Override
    public void accept(Map<String, String> args) {
        Set<Respuesta> respuestas = new HashSet<>();
        var id = Objects.requireNonNull(args.get("jugadorId").split(","));
        var  desripcion = Objects.requireNonNull(args.get("descripcion").split(","));
        var descripRespuesta = Objects.requireNonNull(args.get("descripRespuesta").split(","));
        var estadoRespuesta = Objects.requireNonNull(args.get("estadoRespuesta").split(","));

        for (int i = 0; i <descripRespuesta.length ; i++) {
            respuestas.add(
                    Respuesta.of(Descripcion.of(descripRespuesta[i]),
                            Estado.of(toBoolean(estadoRespuesta[i])))
            );

        }


    }
    private Boolean toBoolean(String s){
        if(Integer.parseInt(s) == 1){
            return Boolean.TRUE;
        }else if(Integer.parseInt(s) == 0){
            return Boolean.FALSE;
        }
        return null;
    }


}
