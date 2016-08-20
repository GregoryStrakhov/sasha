package by.boiko.crm.service.impl;


import by.boiko.crm.dao.GroupDao;
import by.boiko.crm.model.Group;
import by.boiko.crm.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Transactional
    public List<Group> getAll() {
        return groupDao.loadAll();
    }

    @Transactional
    public Group get(int id) {
        return groupDao.load(id);
    }

    @Transactional
    public void delete(int id) {
        groupDao.delete(id);
    }

    @Transactional
    public void saveOrUpdate(Group group) {
        groupDao.saveOrUpdate(group);
    }

    @Transactional
    public List<Group> allGroup() {
        return groupDao.allGroup();
    }
}
