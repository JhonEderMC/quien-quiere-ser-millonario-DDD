package org.example.millonario.infra.handle;


import org.example.millonario.domain.juego.events.JuegoBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
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

}
