package ledzepelin.calihotel.controller.mainstage;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ledzepelin.calihotel.application.event.model.SceneEvent;
import ledzepelin.calihotel.application.event.model.StageEvent;
import ledzepelin.calihotel.application.event.publisher.SceneEventPublisher;
import ledzepelin.calihotel.application.event.publisher.StageEventPublisher;
import ledzepelin.calihotel.config.Constants;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView
public class MainWindow{
    @FXML
    private Button bookingBtn;

    @FXML
    private Button guestBtn;

    @FXML
    private Button groupBtn;

    @Autowired
    SceneEventPublisher publisher;

    /**
     * Replaces the vista displayed in the vista holder with a new vista.
     *
     */
    @FXML
    public void initialize() {
        bookingBtn.setOnMouseClicked(mouseEvent -> publisher.publish(new SceneEvent(Constants.STATE_BOOKING)));
        guestBtn.setOnMouseClicked(mouseEvent -> publisher.publish(new SceneEvent(Constants.STATE_GUEST)));
        groupBtn.setOnMouseClicked(mouseEvent -> publisher.publish(new SceneEvent(Constants.STATE_GROUP)));
    }
}
