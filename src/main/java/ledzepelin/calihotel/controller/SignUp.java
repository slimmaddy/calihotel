package ledzepelin.calihotel.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Pair;
import ledzepelin.calihotel.application.entity.User;
import ledzepelin.calihotel.application.service.UserService;
import ledzepelin.calihotel.application.validator.Validator;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.security.Permission;
import java.util.ResourceBundle;

@Component
@FxmlView
public class SignUp {
    private final FxWeaver fxWeaver;
    private final UserService userService;

    @FXML
    public TextField fullNameTF;

    @FXML
    public TextField userNameTF;

    @FXML
    public TextField emailTF;

    @FXML
    public TextField passwordTF;

    @FXML
    public TextField confirmPassTF;

    @FXML
    public Label errLbl;

    @FXML
    public ComboBox permissionCbx;

    @Autowired
    public SignUp(FxWeaver fxWeaver, UserService userService) {
        this.fxWeaver = fxWeaver;
        this.userService = userService;
    }

    @FXML
    public void initialize() {
        // TODO: permission should be an enum or retrieve from database.
        ObservableList<String> list = FXCollections.observableArrayList("admin","receptionist");
        permissionCbx.setItems(list);
        permissionCbx.getSelectionModel().select(1);
    }

    public void signUp(ActionEvent actionEvent) {
            if (!passwordTF.getText().equals(confirmPassTF.getText())) {
                errLbl.setText("Invalid confirm password");
                errLbl.setVisible(true);
                return;
            }
            User user = new User();
            user.setPassword(passwordTF.getText());
            user.setUserName(userNameTF.getText());
            user.setFullName(fullNameTF.getText());
            user.setEmail(emailTF.getText());
            user.setPermission(permissionCbx.getSelectionModel().getSelectedIndex());
            Pair<Boolean, String> result = Validator.validateUserInput(user);
            if (result.getKey()) {
                if (userService.isUserNameExisted(user.getUserName())) {
                    errLbl.setText("User name is existed");
                    errLbl.setVisible(true);
                    errLbl.setTextFill(Color.RED);
                    return;
                }
                try {
                    userService.signUp(user);
                } catch (Exception e) {
                    errLbl.setText("Sign up failed");
                    errLbl.setVisible(true);
                    errLbl.setTextFill(Color.RED);
                    e.printStackTrace();
                    return;
                }
                errLbl.setText("Sign up succeed");
                errLbl.setVisible(true);
                errLbl.setTextFill(Color.GREEN);
            } else {
                errLbl.setText(result.getValue());
                errLbl.setVisible(true);
                errLbl.setTextFill(Color.RED);
            }

    }
}
