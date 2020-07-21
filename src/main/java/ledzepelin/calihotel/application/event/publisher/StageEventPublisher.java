package ledzepelin.calihotel.application.event.publisher;

import ledzepelin.calihotel.application.event.IEventPublisher;
import ledzepelin.calihotel.application.event.model.StageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class StageEventPublisher implements IEventPublisher<StageEvent> {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publish(StageEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
