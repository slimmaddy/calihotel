package ledzepelin.calihotel.application.service;

import ledzepelin.calihotel.application.dao.DBUtil;
import ledzepelin.calihotel.application.dao.GuestDaoImpl;
import ledzepelin.calihotel.application.entity.Guest;
import ledzepelin.calihotel.application.model.InvalidDataException;
import ledzepelin.calihotel.application.validator.GuestValidator;
import org.springframework.stereotype.Service;

@Service
public class GuestService {
    public void addGuest(Guest guest) {
        try {
            if (GuestValidator.validateGuestInput(guest)) {
                new GuestDaoImpl().insert(guest);
            }
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }

    }

    public void deleteGuest(String guestID) {

    }

    public void updateGuest(Guest guest) {

    }
}
