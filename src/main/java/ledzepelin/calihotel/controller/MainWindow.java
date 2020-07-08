package ledzepelin.calihotel.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ledzepelin.calihotel.Util.Util;
import ledzepelin.calihotel.application.entity.Guest;
import ledzepelin.calihotel.application.model.InvalidDataException;
import ledzepelin.calihotel.application.service.GuestService;
import ledzepelin.calihotel.application.validator.GuestValidator;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView
public class MainWindow {
    private GuestService guestService;

    @FXML
    private Button newBtn;

    @FXML
    private Button editBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private TextField fullnameTF;

    @FXML
    private TextField sexTF;

    @FXML
    private TextField emailTF;

    @FXML
    private TextArea listGuestTA;

    private GuestValidator guestValidator = new GuestValidator();

    @Autowired
    public MainWindow(GuestService guestService) {
        this.guestService = guestService;
    }

    public void addGuest() {
        try {
            System.out.println("haha");
            Guest guest = new Guest();
            guest.setFullName(fullnameTF.getText());
            guest.setSex(sexTF.getText());
            guest.setEmail(emailTF.getText());

            guestValidator.validateGuestInput(guest);

            guestService.addGuest(guest);
            updateListGuest(guest);
        } catch (InvalidDataException e) {
            //handle
            e.printStackTrace();
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
        System.out.println(Util.formatReponse(guest));
        listGuestTA.setText(Util.formatReponse(guest));
    }


}
