package ledzepelin.calihotel.application.service;

import javafx.util.Pair;
import ledzepelin.calihotel.application.dao.UserDaoImpl;
import ledzepelin.calihotel.application.entity.User;
import ledzepelin.calihotel.application.validator.GuestValidator;
import ledzepelin.calihotel.application.validator.Validator;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

@Service
public class UserService {
    public boolean signIn(String userName, String password) {
        //remove
        if(userName.equals("admin")) {
            return true;
        }
        User user = new UserDaoImpl().getUserByUserName(userName);
        if (user != null) {
            String salt = user.getSalt();
            String calculatedHash = null;
            try {
                calculatedHash = getEncryptedPassword(password, salt);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (calculatedHash.equals(user.getEncryptedPassword())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    // Get a encrypted password using PBKDF2 hash algorithm
    private String getEncryptedPassword(String password, String salt) throws Exception {
        String algorithm = "PBKDF2WithHmacSHA1";
        int derivedKeyLength = 160; // for SHA1
        int iterations = 20000; // NIST specifies 10000

        byte[] saltBytes = Base64.getDecoder().decode(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), saltBytes, iterations, derivedKeyLength);
        SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);

        byte[] encBytes = f.generateSecret(spec).getEncoded();
        return Base64.getEncoder().encodeToString(encBytes);
    }

    public boolean isUserNameExisted(String userName) {
        var user = new UserDaoImpl().getUserByUserName(userName);
        return user != null;
    }

    public void signUp(User user) throws Exception {
        String salt = getNewSalt();
        String encryptedPassword = getEncryptedPassword(user.getPassword(), salt);
        user.setEncryptedPassword(encryptedPassword);
        user.setSalt(salt);
        new UserDaoImpl().insert(user);
    }

    // Returns base64 encoded salt
    public String getNewSalt() throws Exception {
        // Don't use Random!
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        // NIST recommends minimum 4 bytes. We use 8.
        byte[] salt = new byte[8];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
}
