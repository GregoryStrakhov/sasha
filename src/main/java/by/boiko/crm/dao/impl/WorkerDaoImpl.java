package by.boiko.crm.dao.impl;


import by.boiko.crm.dao.WorkerDao;
import by.boiko.crm.model.Worker;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerDaoImpl implements WorkerDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Worker findByLogin(String login) {
        return (Worker) sessionFactory.getCurrentSession().createQuery("select u from Worker u where login = :login").setParameter("login", login).uniqueResult();
    }
}
