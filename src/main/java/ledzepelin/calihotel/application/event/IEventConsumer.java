package ledzepelin.calihotel.application.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public interface IEventConsumer<S extends ApplicationEvent> extends ApplicationListener<S> {

}
