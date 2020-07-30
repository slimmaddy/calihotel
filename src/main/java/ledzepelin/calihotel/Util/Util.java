package ledzepelin.calihotel.Util;

import ledzepelin.calihotel.application.entity.Group;
import ledzepelin.calihotel.application.entity.Guest;

public class Util {
    public static String guestFormatReponse(Guest guest) {
        return String.format("|%s|%s", guest.getSex(), guest.getEmail());
    }

    public static String groupFormatReponse(Group group) {
        return String.format("|%s|%s", group.getGroupName(), group.getBooker());
    }
}
