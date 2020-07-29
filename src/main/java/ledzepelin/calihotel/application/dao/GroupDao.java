package ledzepelin.calihotel.application.dao;

import java.util.List;

import ledzepelin.calihotel.application.entity.Group;

public interface GroupDao {
    public void insert(Group group);
    public List<Group> getGroups();
}