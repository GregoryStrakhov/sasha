package by.boiko.crm.service.impl;


import by.boiko.crm.dao.GroupDao;
import by.boiko.crm.model.Group;
import by.boiko.crm.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Transactional
    public void delete(int id) {
        groupDao.delete(id);
    }

    @Transactional
    public void saveOrUpdate(Group group) {
        groupDao.saveOrUpdate(group);
    }

    @Transactional
    public List<Group> getAllGroup() {
        return groupDao.getAllGroup();
    }
}
