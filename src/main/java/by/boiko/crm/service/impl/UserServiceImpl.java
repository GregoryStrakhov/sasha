package by.boiko.crm.service.impl;


import by.boiko.crm.dao.UserDao;
import by.boiko.crm.model.User;
import by.boiko.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAll() {
        return userDao.loadAll();
    }

    public User get(int id) {
        return userDao.load(id);
    }

    public List<User> getUserByName(String name) {
        return userDao.loadUserByName(name);
    }

    @Override
    public List<User> getUsers(int value, int maxResult) {
        return userDao.loadUsers(value, maxResult);
    }

    @Override
    public long getAllCount() {
        return userDao.loadAllCount();
    }

    public void delete(int id) {
        userDao.delete(id);
    }

    public void saveOrUpdate(User user) {
        userDao.saveOrUpdate(user);
    }
}