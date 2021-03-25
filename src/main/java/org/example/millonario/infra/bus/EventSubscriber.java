package org.example.millonario.infra.bus;

public interface EventSubscriber {
    void subscribe(String eventType, String exchange);
}