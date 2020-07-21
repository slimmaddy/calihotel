package ledzepelin.calihotel.application.event;


import org.springframework.context.ApplicationEvent;

public interface IEventPublisher<S extends ApplicationEvent> {
    void publish(S event);
}
