package ledzepelin.calihotel.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ledzepelin.calihotel.application.entity.Guest;
import ledzepelin.calihotel.application.entity.User;
import ledzepelin.calihotel.application.service.UserService;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@FxmlView
public class Login {

    private final FxWeaver fxWeaver;
    private final UserService userService;

    @FXML
    public TextField userNameTF;

    @FXML
    public TextField passwordTF;

    @FXML
    public Button signinBtn;

    @Autowired
    public Login(FxWeaver fxWeaver, UserService userService){
        this.fxWeaver = fxWeaver;
        this.userService = userService;
    }

    public void signIn(ActionEvent actionEvent) {
        User user = new User();
        user.setUserName(userNameTF.getText());
        user.setPassword(passwordTF.getText());

        // TODO: validate input before query
        boolean success = userService.signIn(user);

        if (success) {
            // TODO: Create an user instance for globally access
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxWeaver.loadView(MainWindow.class));
            stage.setScene(scene);
        } else {
            // Show prompt
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Invalid user name or password");
            alert.show();

        }
    }
}
