package ledzepelin.calihotel.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView
public class MainWindow {

    private final FxWeaver fxWeaver;

    @FXML
    private Button bookingBtn;

    @FXML
    private Button backBtn;


    @Autowired
    public MainWindow(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    public void bookingModule(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxWeaver.loadView(BookingWindow.class));
            stage.setScene(scene);
        } catch (Exception e) {
            //handle
            e.printStackTrace();
        }
    }

    public void signOut(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxWeaver.loadView(Login.class));
            stage.setScene(scene);
        } catch (Exception e) {
            //handle
            e.printStackTrace();
        }
    }

}
