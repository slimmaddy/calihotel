package ledzepelin.calihotel.Util;

import javafx.scene.control.Alert;

public class ViewUtil {
    public static void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setContentText(message);
        alert.show();
    }
}
