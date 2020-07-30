package ledzepelin.calihotel.controller.mainscene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import ledzepelin.calihotel.Util.Util;
import ledzepelin.calihotel.application.entity.Guest;
import ledzepelin.calihotel.application.model.InvalidDataException;
import ledzepelin.calihotel.application.service.GuestService;
import ledzepelin.calihotel.application.validator.GuestValidator;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView
public class BookingWindow{
    @Autowired
    private GuestService guestService;

    @FXML
    private TextField lastNameTF;

    @FXML
    private TextField nameTF;

    @FXML
    private TextField sexTF;

    @FXML
    private TextField emailTF;

    @FXML
    private TextField phoneTF;

    @FXML
    private DatePicker arrivalTF;

    @FXML
    private DatePicker departureTF;

    @FXML
    private DatePicker checkOutTF;

    @FXML
    private TextField dayTF;

    @FXML
    private TextField travelAgencyTF;

    @FXML
    private TextField roomNoTF;

    @FXML
    private TextField priceTF;

    @FXML
    private TextField commentTF;

    @FXML
    private TextField paymentMethodTF;

    @FXML
    private TextField vipTF;

    @FXML
    private TextField specialsTF;

    @FXML
    private TextField statusTF;


    @FXML
    private TextArea listGuestTA;

    @FXML
    private Button newBtn;

    @FXML
    private Button editBtn;

    @FXML
    private Button deleteBtn;

    private GuestValidator guestValidator = new GuestValidator();

    public void addGuest() {
        try {
            Guest guest = new Guest();
            guest.setLastName(lastNameTF.getText());
            guest.setName(nameTF.getText());
            guest.setSex(sexTF.getText());
            guest.setEmail(emailTF.getText());
            try {
                guest.setPhone(Long.parseLong(phoneTF.getText()));
            }catch (Exception e){
                guestValidator.warning("phone");
            }
            guest.setArrival(arrivalTF.getValue());
            guest.setDeparture(departureTF.getValue());
            guest.setCheckOut(checkOutTF.getValue());
            int day = guest.getCheckOut().compareTo(guest.getArrival());
            dayTF.setText(day + "");
            guest.setDays(day);
            guest.setTravelAgency(travelAgencyTF.getText());
            guest.setRoomNo(roomNoTF.getText());
            guest.setPrice(Integer.parseInt(priceTF.getText()));
            guest.setComment(commentTF.getText());
            guest.setPaymentMethod(paymentMethodTF.getText());
            guest.setVip(vipTF.getText());
            guest.setSpecials(specialsTF.getText());
            guest.setStatus(statusTF.getText());

            guestService.addGuest(guest);
            updateListGuest(guest);
        } catch (Exception e) {
            //handle
            e.printStackTrace();
        }
    }

    public void editGuest(){
        guestService.updateGuest(new Guest());
    }

    public void deleteGuest(){
        guestService.deleteGuest("1");
    }

    private void updateListGuest(Guest guest) {
        System.out.println(Util.guestFormatReponse(guest));
        listGuestTA.setText(Util.guestFormatReponse(guest));
    }

}
