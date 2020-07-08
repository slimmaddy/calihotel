package ledzepelin.calihotel.application.validator;

import ledzepelin.calihotel.application.entity.Guest;
import ledzepelin.calihotel.application.model.InvalidDataException;

public class GuestValidator {
    public boolean validateGuestInput(Guest guest) throws Exception{
        if(guest.getFullName() == null || guest.getFullName().trim().isEmpty()) {
            throw new InvalidDataException("Fullname required");
        }
        return true;
    }
}
