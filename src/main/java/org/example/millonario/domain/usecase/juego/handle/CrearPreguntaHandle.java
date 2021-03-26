package org.example.millonario.domain.usecase.juego.handle;

import co.com.sofka.business.annotation.CommandHandles;
import co.com.sofka.business.annotation.CommandType;
import co.com.sofka.business.asyn.UseCaseExecutor;
import co.com.sofka.business.support.RequestCommand;
import org.example.millonario.domain.juego.command.CrearPregunta;
import org.example.millonario.domain.juego.values.Descripcion;
import org.example.millonario.domain.juego.values.Estado;
import org.example.millonario.domain.juego.values.PreguntaId;
import org.example.millonario.domain.juego.values.Respuesta;
import org.example.millonario.domain.usecase.juego.CrearPreguntaUseCase;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@CommandHandles
@CommandType(name = "millonario.juego.pregunta", aggregate = "juego")
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

        request = new RequestCommand<>(new CrearPregunta(
                PreguntaId.of(id[0]), Descripcion.of(descripRespuesta[0]),
                respuestas)
        );


    }
    private Boolean toBoolean(String s){
        if (s.equalsIgnoreCase("true")){
            return Boolean.TRUE;
        }else if(s.equalsIgnoreCase("false")){
            return Boolean.FALSE;
        }
        else if(Integer.parseInt(s) == 1){
            return Boolean.TRUE;
        }else if(Integer.parseInt(s) == 0){
            return Boolean.FALSE;
        }
        return null;
    }


}
