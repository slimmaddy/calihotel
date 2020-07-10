package ledzepelin.calihotel.application.dao;

import ledzepelin.calihotel.application.entity.Guest;

public interface GuestDao {
    public void insert(Guest guest);
    public void deleteById(int id);
}
