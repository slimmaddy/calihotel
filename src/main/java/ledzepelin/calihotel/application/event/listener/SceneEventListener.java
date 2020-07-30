package ledzepelin.calihotel.application.event.listener;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import ledzepelin.calihotel.application.StageFactory;
import ledzepelin.calihotel.application.event.IEventConsumer;
import ledzepelin.calihotel.application.event.model.SceneEvent;
import ledzepelin.calihotel.config.Constants;
import ledzepelin.calihotel.controller.mainscene.BookingWindow;
import ledzepelin.calihotel.controller.mainscene.GroupWindow;
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
                Pane bookingPane = (Pane) stageFactory.getCurrentStage().getScene().lookup("#mainScene");
                bookingPane.getChildren().clear();
                bookingPane.getChildren().addAll(new Scene(fxWeaver.loadView(BookingWindow.class)).getRoot().getChildrenUnmodifiable());
                break;
            case Constants.STATE_GROUP:
                Pane groupPane = (Pane) stageFactory.getCurrentStage().getScene().lookup("#mainScene");
                groupPane.getChildren().clear();
                groupPane.getChildren().addAll(new Scene(fxWeaver.loadView(GroupWindow.class)).getRoot().getChildrenUnmodifiable());
                break;
            default:
                break;
        }
    }
}
