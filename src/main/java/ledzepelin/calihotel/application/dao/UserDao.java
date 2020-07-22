package ledzepelin.calihotel.application.dao;

import ledzepelin.calihotel.application.entity.User;

public interface UserDao {
    public void insert(User user);
    public User getUserByUserName(String userName);
}
