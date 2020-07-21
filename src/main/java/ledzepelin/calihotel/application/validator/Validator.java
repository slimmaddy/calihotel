package ledzepelin.calihotel.application.validator;

import ledzepelin.calihotel.application.entity.User;
import javafx.util.Pair;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
    public static final String EMAIL_PATTERN = "^(.+)@(.+)$";

    private static boolean validateUserName(String userName){
        if (userName == null || userName.isBlank() || userName.isEmpty()) return false;
        Pattern pattern = Pattern.compile(USERNAME_PATTERN);
        Matcher matcher = pattern.matcher(userName);
        return matcher.matches();
    }

    private static boolean validateEmail(String email) {
        if (email == null || email.isBlank() || email.isEmpty()) return false;

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean validatePassword(String password) {
        if (password == null || password.isEmpty() || password.isBlank()) return false;
        return true;
    }

    private static boolean validateFullName(String fullName) {
        if (fullName == null || fullName.isEmpty() || fullName.isBlank()) return false;
        return true;
    }

    public static Pair<Boolean,String> validateUserInput(User user){
        if (!validateFullName(user.getFullName()))
            return new Pair<Boolean, String>(false, "Invalid full name");
        if (!validateUserName(user.getUserName()))
            return new Pair<Boolean, String>(false, "Invalid user name");
        if (!validateEmail(user.getEmail()))
            return new Pair<Boolean, String>(false, "Invalid email");
        if (!validatePassword(user.getPassword()))
            return new Pair<Boolean, String>(false, "Invalid password");
        return new Pair<Boolean, String>(true, "");
    }
}
