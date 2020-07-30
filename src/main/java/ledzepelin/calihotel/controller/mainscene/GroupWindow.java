package ledzepelin.calihotel.controller.mainscene;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ledzepelin.calihotel.Util.Util;
import ledzepelin.calihotel.application.entity.Group;
import ledzepelin.calihotel.application.entity.Guest;
import ledzepelin.calihotel.application.service.GroupService;
import ledzepelin.calihotel.application.service.GuestService;
import ledzepelin.calihotel.application.validator.GuestValidator;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@FxmlView
public class GroupWindow {
    @Autowired
    private GroupService groupService;

    @FXML
    private TextField groupNameTF;

    @FXML
    private TextField travelAgencyTF;

    @FXML
    private TextField bookerTF;

    @FXML
    private TextField priceTF;

    @FXML
    private TextField phoneTF;

    @FXML
    private TextField paymentMethodTF;

    @FXML
    private TextField commentTF;

    @FXML
    private DatePicker arrivalTF;

    @FXML
    private DatePicker departureTF;

    @FXML
    private TextField daysTF;

    @FXML
    private TextField statusTF;

    @FXML
    private TextArea listGroupTA;

    @FXML
    private Button newBtn;

    @FXML
    private Button editBtn;

    @FXML
    private Button deleteBtn;

    public void addGroup() {
        try {
            Group group = new Group();
            group.setGroupName(groupNameTF.getText());
            group.setTravelAgency(travelAgencyTF.getText());
            group.setBooker(bookerTF.getText());
            group.setPrice(new BigDecimal(priceTF.getText()));
            group.setPaymentMethod(paymentMethodTF.getText());
            group.setComment(commentTF.getText());
            group.setArrival(arrivalTF.getValue());
            group.setDeparture(departureTF.getValue());
            int day = group.getDeparture().compareTo(group.getArrival());
            daysTF.setText(day + "");
            group.setDays(day);
            group.setStatus(statusTF.getText());

            groupService.addGroup(group);
            updateListGroup(group);
        } catch (Exception e) {
            //handle
            e.printStackTrace();
        }
    }

    public void editGuest(){
        groupService.updateGroup(new Group());
    }

    public void deleteGuest(){
        groupService.deleteGroup("1");
    }

    private void updateListGroup(Group group) {
        System.out.println(Util.groupFormatReponse(group));
        listGroupTA.setText(Util.groupFormatReponse(group));
    }

}
