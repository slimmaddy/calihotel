package ledzepelin.calihotel.application.event.model;

import org.springframework.context.ApplicationEvent;

public class SceneEvent extends ApplicationEvent {
    private final String event;

    public SceneEvent(String event) {
        super(event);
        this.event = event;
    }

    public String getEvent() {
        return event;
    }
}
