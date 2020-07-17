package ledzepelin.calihotel.Util;

import ledzepelin.calihotel.application.entity.Guest;

public class Util {
    public static String formatReponse(Guest guest) {
        return String.format("|%s|%s", guest.getSex(), guest.getEmail());
    }
}
