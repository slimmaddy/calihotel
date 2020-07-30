package ledzepelin.calihotel.application.service;

import ledzepelin.calihotel.application.dao.GroupDaoImpl;
import ledzepelin.calihotel.application.dao.GuestDaoImpl;
import ledzepelin.calihotel.application.entity.Group;
import ledzepelin.calihotel.application.entity.Guest;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
    public void addGroup(Group group) {
        new GroupDaoImpl().insert(group);
    }

    public void deleteGroup(String groupID) {
    }

    public void updateGroup(Group group) {
    }
}
