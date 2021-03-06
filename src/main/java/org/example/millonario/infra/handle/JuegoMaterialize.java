package org.example.millonario.infra.handle;


import co.com.sofka.domain.generic.DomainEvent;
import org.example.millonario.domain.juego.JuegoIniciado;
import org.example.millonario.domain.juego.events.*;
import org.example.millonario.domain.juego.values.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.logging.Logger;

@Component
public class JuegoMaterialize {

    private static final String COLLECTION_NAME = "juegos";
    private static final Logger logger = Logger.getLogger(JuegoMaterialize.class.getName());

    @Autowired
    @Qualifier("mongoTemplateQueries")
    private MongoTemplate mongoTemplate;

    @Async
    @EventListener
    public void handleEventJuegoBase(JuegoBase juegoBase){
        logger.info("****** Handle event juegoBase");
        Map<String, Object> data = new HashMap<>();
        data.put("_id", juegoBase.juegoId().value());
        data.put("juegoInicializado", false);

        mongoTemplate.save(data, COLLECTION_NAME);
    }

    @Async
    @EventListener
    public void handleEventJugadorCreado(JugadorCreado jugadorCreado) {
        logger.info("****** Handle event jugadorCreado");
        Update update = new Update();
        var id = jugadorCreado.jugadorId().value();
        update.set("jugador."+id+".nombre", jugadorCreado.nombre().value());
        update.set("jugador."+id+".profesion", jugadorCreado.profesion().value());
        update.set("jugador."+id+".telefono-amigo", jugadorCreado.telefonoAmigo().value());
        update.set("jugador."+id+".capital", jugadorCreado.capital().value());

        mongoTemplate.updateFirst(getFilterByAggregateId(jugadorCreado), update, COLLECTION_NAME);
    }

    @Async
    @EventListener
    public void handledEventIniciarJuegoIniciado(JuegoIniciado juegoIniciado){
        logger.info("****** Handle event jugadorCreado");
        Update update = new Update();
        update.set("juegoInicializado", true);

        mongoTemplate.updateFirst(getFilterByAggregateId(juegoIniciado), update, COLLECTION_NAME);
    }

    @Async
    @EventListener
    public void handledEventPreguntaCreada(PreguntaCreada preguntaCreada){
        logger.info("****** Handle event preguntaCreada");
        Update update = new Update();
        var id = preguntaCreada.preguntaId().value();
        update.set("preguntaId",id);
        update.set("pregunta."+id+".descripcion",preguntaCreada.descripcion().value());
        Set<Respuesta> respuestas = preguntaCreada.respuestas();
        int i=0;
        for (Respuesta respuesta: respuestas){
            i++;
            update.set("respuesta."+i+".descripcion",respuesta.value().descripcion().value());
            update.set("respuesta."+i+".estado",respuesta.value().estado().value());
        }

        mongoTemplate.updateFirst(getFilterByAggregateId(preguntaCreada), update, COLLECTION_NAME);
    }

    @Async
    @EventListener
    public void handledEventRespuestaJugador(RespuestaJugadorCreado respuestaJugador){
        logger.info("****** Handle event respuestajugador");
        Update update = new Update();

        update.set("repuestaJugador",respuestaJugador.respuestaJugador().value());

        mongoTemplate.updateFirst(getFilterByAggregateId(respuestaJugador), update, COLLECTION_NAME);
    }

    @Async
    @EventListener
    public  void handledEventRetirarJugador(JugadorRetirado jugadorRetirado){
        logger.info("****** Handle event respuestajugador");
        Update update = new Update();

        update.set("jugadorId",jugadorRetirado.getJugadorId());

        mongoTemplate.updateFirst(getFilterByAggregateId(jugadorRetirado), update, COLLECTION_NAME);
    }

    private Query getFilterByAggregateId(DomainEvent event) {
        return new Query(
                Criteria.where("_id").is(event.aggregateRootId())
        );
    }

}
