package ledzepelin.calihotel.application;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.stereotype.Component;

@Component
public class StageFactory {

    private final ObservableList<Stage> openStages = FXCollections.observableArrayList();

    public ObservableList<Stage> getOpenStages() {
        return openStages ;
    }

    private final ObjectProperty<Stage> currentStage = new SimpleObjectProperty<>(null);

    private final ObjectProperty<Stage> mainStage = new SimpleObjectProperty<>(null);


    public final javafx.stage.Stage getCurrentStage() {
        return this.currentStage.get();
    }

    public final javafx.stage.Stage getMainStage() {
        return this.mainStage.get();
    }

    public final void setCurrentStage(final javafx.stage.Stage currentStage) {
        this.currentStage.set(currentStage);
    }

    public void registerStage(Stage stage) {
        stage.addEventHandler(WindowEvent.WINDOW_SHOWN, e ->
                openStages.add(stage));
        stage.addEventHandler(WindowEvent.WINDOW_HIDDEN, e ->
                openStages.remove(stage));
        stage.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (isNowFocused) {
                currentStage.set(stage);
            } else {
                currentStage.set(null);
            }
        });
    }

    public void registerMainStage(Stage stage) {
        stage.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (isNowFocused) {
                mainStage.set(stage);
            } else {
                mainStage.set(null);
            }
        });
    }

    public Stage createStage() {
        Stage stage = new Stage();
        registerStage(stage);
        return stage ;
    }

}