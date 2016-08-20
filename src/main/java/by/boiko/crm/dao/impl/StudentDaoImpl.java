package by.boiko.crm.dao.impl;


import by.boiko.crm.dao.StudentDao;
import by.boiko.crm.model.Group;
import by.boiko.crm.model.Student;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * The class implements methods for access to MySQL database for Student.
 */
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Student> loadAll() {
        return sessionFactory.getCurrentSession().createQuery("from Student")
                .list();
    }

    @Override
    public List loadStudentsByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("select u from Student u where fullName LIKE :tagName");
        return query.setParameter("tagName", "%" + name + "%").list();
    }

    @Override
    public void delete(int id) {
        Student student = (Student) sessionFactory.getCurrentSession().load(
                Student.class, id);
        if (null != student) {
            sessionFactory.getCurrentSession().delete(student);
        }
    }

    @Override
    public void saveOrUpdate(Student student) {
        Group group = (Group) sessionFactory.getCurrentSession().createQuery("select u from Group u where id = :id").setParameter("id", student.getGroup().getId()).uniqueResult();
        student.setGroup(group);
        sessionFactory.getCurrentSession().saveOrUpdate(student);
    }

    @Override
    public Student load(int id) {
        return (Student) sessionFactory.getCurrentSession().createQuery("select u from Student u where id = :id").setParameter("id", id).uniqueResult();
    }

}