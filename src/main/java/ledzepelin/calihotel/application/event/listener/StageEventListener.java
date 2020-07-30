package ledzepelin.calihotel.application.event.listener;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ledzepelin.calihotel.application.StageFactory;
import ledzepelin.calihotel.application.event.IEventConsumer;
import ledzepelin.calihotel.application.event.model.StageEvent;
import ledzepelin.calihotel.config.Constants;
import ledzepelin.calihotel.controller.mainscene.BookingWindow;
import ledzepelin.calihotel.controller.mainscene.GroupWindow;
import ledzepelin.calihotel.controller.mainstage.Login;
import ledzepelin.calihotel.controller.mainstage.MainWindow;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StageEventListener implements IEventConsumer<StageEvent> {
    private final FxWeaver fxWeaver;

    @Autowired
    StageFactory stageFactory;

    @Autowired
    public StageEventListener(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @Override
    public void onApplicationEvent(StageEvent event) {
        switch (event.getEvent()) {
            case Constants.STATE_READY:
                stageFactory.registerStage(event.getStage());
                stageFactory.registerMainStage(event.getStage());
                Stage stage = event.getStage();
                Scene scene = new Scene(fxWeaver.loadView(Login.class));
                stage.setScene(scene);
                stage.sizeToScene();
                stage.show();
                break;
            case Constants.STATE_LOG_IN:
                stageFactory.getMainStage().setScene(new Scene(fxWeaver.loadView(MainWindow.class)));
                stageFactory.getMainStage().sizeToScene();
                stageFactory.getMainStage().show();
                break;
            case Constants.STATE_LOG_OUT:
                stageFactory.getMainStage().setScene(new Scene(fxWeaver.loadView(Login.class)));
                stageFactory.getMainStage().sizeToScene();
                stageFactory.getMainStage().show();
                break;
            case Constants.STATE_BOOKING:
                Pane bookingPane = (Pane)stageFactory.getCurrentStage().getScene().lookup("#mainScene");
                bookingPane.getChildren().clear();
                bookingPane.getChildren().addAll(new Scene(fxWeaver.loadView(BookingWindow.class)).getRoot().getChildrenUnmodifiable());
                break;
            case Constants.STATE_GROUP:
                Pane groupPane = (Pane)stageFactory.getCurrentStage().getScene().lookup("#mainScene");
                groupPane.getChildren().clear();
                groupPane.getChildren().addAll(new Scene(fxWeaver.loadView(GroupWindow.class)).getRoot().getChildrenUnmodifiable());
                break;
        }
    }
}
