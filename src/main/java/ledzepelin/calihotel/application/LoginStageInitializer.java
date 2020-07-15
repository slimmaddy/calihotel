package ledzepelin.calihotel.application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ledzepelin.calihotel.controller.Login;
import ledzepelin.calihotel.controller.MainWindow;
import net.rgielen.fxweaver.core.FxWeaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author <a href="mailto:rene.gielen@gmail.com">Rene Gielen</a>
 */
@Component
public class LoginStageInitializer implements ApplicationListener<StageReadyEvent> {

    private final FxWeaver fxWeaver;

    @Autowired
    public LoginStageInitializer(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        Stage stage = event.stage;
        Scene scene = new Scene(fxWeaver.loadView(Login.class));
        stage.setScene(scene);
        stage.show();
    }
}
