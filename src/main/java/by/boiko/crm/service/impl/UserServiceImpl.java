package by.boiko.crm.service.impl;


import by.boiko.crm.dao.UserDao;
import by.boiko.crm.model.User;
import by.boiko.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public List<User> getAll() {
        return userDao.loadAll();
    }

    @Transactional
    public User get(int id) {
        return userDao.load(id);
    }


    @Transactional
    public List<User> getUserByName(String name) {
        return userDao.loadUserByName(name);
    }

    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }

    @Transactional
    public void saveOrUpdate(User user) {
        userDao.saveOrUpdate(user);
    }
}