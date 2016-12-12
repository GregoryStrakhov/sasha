package by.boiko.crm.dao.impl;


import by.boiko.crm.dao.UserDao;
import by.boiko.crm.model.User;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The class implements methods for access to MySQL database for User.
 */
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<User> loadAll() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    @Transactional
    public List loadUserByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("select u from User u where u.name LIKE :tagName");
        return query.setParameter("tagName", "%" + name + "%").list();
    }

    @Override
    @Transactional
    public void delete(int id) {
        User user = sessionFactory.getCurrentSession().load(
                User.class, id);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Override
    @Transactional
    public void saveOrUpdate(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    @Transactional
    public User load(int id) {
        return (User) sessionFactory.getCurrentSession().createQuery("select u from User u where id = :id").setParameter("id", id).uniqueResult();
    }

    @Override
    @Transactional
    public List<User> loadUsers(int pageNum, int pageSize) {
        return sessionFactory.getCurrentSession().createQuery("from User").setFirstResult(pageNum * pageSize).setMaxResults(pageNum * pageSize + pageSize).list();
    }

    @Override
    @Transactional
    public long loadAllCount() {
        return (long) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(e) FROM User e").getSingleResult();
    }

}