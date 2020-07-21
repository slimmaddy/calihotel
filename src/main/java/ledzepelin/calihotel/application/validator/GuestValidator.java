package ledzepelin.calihotel.application.validator;

import javafx.scene.control.Alert;
import ledzepelin.calihotel.application.entity.Guest;
import ledzepelin.calihotel.application.model.InvalidDataException;

public class GuestValidator {
//    public static boolean validateGuestInput(Guest guest) throws InvalidDataException{
//        if(guest.getFullName() == null || guest.getFullName().trim().isEmpty()) {
//            throw new InvalidDataException("Fullname required");
//        }
//        return true;
//    }

    /// ??? ai code day. k hien alert o day nhe. tra ket qua hoac loi~ ra ngoai controller
    public void warning(String value){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error!!");
        alert.setHeaderText(null);
        if(value.equals("phone")) {
            alert.setContentText("The phone number you have entered is not valid, please enter another");
        }else if(value.equals("day")){
            alert.setContentText("Please enter a number");
        }
        alert.showAndWait();
    }
}
