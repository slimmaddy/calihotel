package ledzepelin.calihotel.application.service;

import ledzepelin.calihotel.application.dao.GuestDaoImpl;
import ledzepelin.calihotel.application.entity.Guest;
import org.springframework.stereotype.Service;

@Service
public class GuestService {
    public void addGuest(Guest guest) {
        new GuestDaoImpl().insert(guest);
    }

    public void deleteGuest(String guestID) {
    }

    public void updateGuest(Guest guest) {
    }
}
