package ledzepelin.calihotel.application.validator;

import ledzepelin.calihotel.application.entity.Guest;
import ledzepelin.calihotel.application.model.InvalidDataException;

public class GuestValidator {
    public static boolean validateGuestInput(Guest guest) throws InvalidDataException{
        if(guest.getFullName() == null || guest.getFullName().trim().isEmpty()) {
            throw new InvalidDataException("Fullname required");
        }
        return true;
    }
}
