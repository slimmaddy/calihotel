package ledzepelin.calihotel.application.dao;

import ledzepelin.calihotel.application.entity.User;

public interface UserDao {
    public boolean signIn(User user);
    public void signUp(User user);
}
