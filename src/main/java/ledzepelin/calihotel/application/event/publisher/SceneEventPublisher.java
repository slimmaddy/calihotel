package ledzepelin.calihotel.application.event.publisher;

import ledzepelin.calihotel.application.event.IEventPublisher;
import ledzepelin.calihotel.application.event.model.SceneEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class SceneEventPublisher implements IEventPublisher<SceneEvent> {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publish(SceneEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
