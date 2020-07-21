package ledzepelin.calihotel.controller.mainstage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ledzepelin.calihotel.Util.ViewUtil;
import ledzepelin.calihotel.application.entity.User;
import ledzepelin.calihotel.application.event.model.StageEvent;
import ledzepelin.calihotel.application.event.publisher.StageEventPublisher;
import ledzepelin.calihotel.application.service.UserService;
import ledzepelin.calihotel.config.Constants;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView
public class Login {

    @Autowired
    private UserService userService;

    @Autowired
    StageEventPublisher publisher;

    @FXML
    public TextField userNameTF;

    @FXML
    public TextField passwordTF;

    @FXML
    public Button signinBtn;



    public void signIn(ActionEvent actionEvent) {
        User user = new User();
        user.setUserName(userNameTF.getText());
        user.setPassword(passwordTF.getText());

        // TODO: validate input before query
        boolean success = userService.signIn(user);

        if (success) {
            // TODO: Create an user instance for globally access
            Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            publisher.publish(new StageEvent(Constants.STATE_LOG_IN, stage));
        } else {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Invalid user name or password");
        }
    }
}
