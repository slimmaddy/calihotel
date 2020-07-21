package ledzepelin.calihotel.application.event.listener;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import ledzepelin.calihotel.application.StageFactory;
import ledzepelin.calihotel.application.event.IEventConsumer;
import ledzepelin.calihotel.application.event.model.SceneEvent;
import ledzepelin.calihotel.config.Constants;
import ledzepelin.calihotel.controller.mainscene.BookingWindow;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SceneEventListener implements IEventConsumer<SceneEvent> {
    @Autowired
    StageFactory stageFactory;

    private final FxWeaver fxWeaver;

    @Autowired
    public SceneEventListener(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }
    @Override
    public void onApplicationEvent(SceneEvent sceneEvent) {
        switch (sceneEvent.getEvent()) {
            case Constants.STATE_BOOKING:
                Pane pane = (Pane)stageFactory.getCurrentStage().getScene().lookup("#mainScene");
                pane.getChildren().clear();
                pane.getChildren().addAll(new Scene(fxWeaver.loadView(BookingWindow.class)).getRoot().getChildrenUnmodifiable());
                break;
        }
    }
}
