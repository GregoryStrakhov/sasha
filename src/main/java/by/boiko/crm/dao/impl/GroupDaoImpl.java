package by.boiko.crm.dao.impl;


import by.boiko.crm.dao.GroupDao;
import by.boiko.crm.model.Group;
import by.boiko.crm.model.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * The class implements methods for access to MySQL database for Group.
 */
public class GroupDaoImpl implements GroupDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(int id) {
        Group group = (Group) sessionFactory.getCurrentSession().load(
                Group.class, id);
        if (null != group) {
            sessionFactory.getCurrentSession().delete(group);
        }
    }

    @Override
    public void saveOrUpdate(Group group) {
        sessionFactory.getCurrentSession().saveOrUpdate(group);
    }

    @Override
    public List<Group> getAllGroup() {
        return sessionFactory.getCurrentSession().createQuery("FROM Group").list();
    }
}
