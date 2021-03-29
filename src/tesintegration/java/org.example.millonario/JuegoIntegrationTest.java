package org.example.millonario;

import org.example.millonario.domain.juego.values.JuegoId;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Map;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JuegoIntegrationTest extends CommandBaseIntegrationTest{

    private static final String aggregateId = new JuegoId().value();

    @Test
    @Order(1)
    void crearJuego(){
        executor(Map.of(
                "commandType", "millonario.juego.crear",
                "aggregateId", aggregateId,
                "nivel", "1"
                ), requestFields(
                fieldWithPath("commandType").description("Tipo de comando"),
                fieldWithPath("aggregateId").description("Identificador del agregado"),
                fieldWithPath("nivel").description("nivel del jugador")
                ), 1
        );
    }

    @Test
    @Order(2)
    void crearPregunta(){
        executor(Map.of(
                "commandType", "millonario.juego.pregunta",
                "aggregateId", aggregateId,
                "preguntaId", "pregunta1",
                "descripcion", "esta es la pregunta 1",
                "descripRespuesta","resp1, resp2, resp3, resp4",
                "estadoRespuesta", "false, false ,false , true"

                ), requestFields(
                fieldWithPath("commandType").description("Tipo de comando"),
                fieldWithPath("aggregateId").description("Identificador del agregado"),
                fieldWithPath("descripcion").description("Descripcion de la pregunta"),
                fieldWithPath("descripRespuesta").description("Descripcion de la respuesta"),
                fieldWithPath("estadoRespuesta").description("Estado de la respuesta")
                ), 3
        );
    }

    @Test
    @Order(3)
    void crearJugador(){
        executor(Map.of(
                "commandType", "millonario.juego.crearjugador",
                "aggregateId", aggregateId,
                "jugadorId", "jugador1",
                "nombre", "Jhon",
                "profesion", "worker",
                "telefono", "3134141",
                "capital", "100"
                ), requestFields(
                fieldWithPath("commandType").description("Tipo de comando"),
                fieldWithPath("aggregateId").description("Identificador del agregado"),
                fieldWithPath("jugadorId").description("Identificador del jugador"),
                fieldWithPath("nombre").description("Nombre del jugador"),
                fieldWithPath("profesion").description("Profesion del jugador"),
                fieldWithPath("telefono").description("Telefono del amigo del jugador"),
                fieldWithPath("capital").description("Dinero del jugador")
                ), 2
        );
    }

    @Test
    @Order(4)
    void crearRespuestaJugador(){
        executor(Map.of(
                "commandType", "millonario.juego.respuesta",
                "aggregateId", aggregateId,
                "respuesta", "2"
                ), requestFields(
                fieldWithPath("commandType").description("Tipo de comando"),
                fieldWithPath("aggregateId").description("Identificador del agregado"),
                fieldWithPath("respuesta").description("Respuesta del jugador")
                ), 1
        );
    }
}
