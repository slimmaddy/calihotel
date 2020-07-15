package ledzepelin.calihotel.application.service;

import ledzepelin.calihotel.application.dao.UserDaoImpl;
import ledzepelin.calihotel.application.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public boolean signIn(User user) {
        return new UserDaoImpl().signIn(user);
    }
}
