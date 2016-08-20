package by.boiko.crm.dao.impl;


import by.boiko.crm.dao.GroupDao;
import by.boiko.crm.model.Group;
import by.boiko.crm.model.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GroupDaoImpl implements GroupDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Group> loadAll() {
        return sessionFactory.getCurrentSession().createQuery("from Group")
                .list();
    }

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
    public Group load(int id) {
        return (Group) sessionFactory.getCurrentSession().createQuery("select u from Group u where id = :id").setParameter("id", id).uniqueResult();
    }

    @Override
    public List<Group> allGroup() {
        return sessionFactory.getCurrentSession().createQuery("FROM Group").list();
    }
}
