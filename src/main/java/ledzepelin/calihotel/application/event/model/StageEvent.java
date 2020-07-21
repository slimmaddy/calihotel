package ledzepelin.calihotel.application.event.model;

import javafx.stage.Stage;
import org.springframework.context.ApplicationEvent;


public class StageEvent extends ApplicationEvent {

    private final Stage stage;
    private final String event;

    public StageEvent(String event, Stage stage) {
        super(stage);
        this.stage = stage;
        this.event = event;
    }

    public Stage getStage() {
        return stage;
    }

    public String getEvent() {
        return event;
    }
}
